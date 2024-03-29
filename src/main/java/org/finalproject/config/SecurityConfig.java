package org.finalproject.config;

import io.jsonwebtoken.Claims;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.finalproject.controller.AuthController;
import org.finalproject.entity.User;
import org.finalproject.filter.JwtFilter;
import org.finalproject.repository.UserJpaRepository;
import org.finalproject.service.GeneralService;
import org.finalproject.service.jwt.AuthService;
import org.finalproject.service.jwt.CustomOAuth2UserService;
import org.finalproject.service.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfig {
    private final JwtFilter jwtFilter;
    private final AuthService authService;
    private final AuthController authController;
    private final GeneralService<User> userService;
    private final JwtProvider jwtProvider;
    @Autowired
    private CustomOAuth2UserService oauthUserService;
    private final UserJpaRepository repository;

    @Bean
    public CorsConfiguration corsConfiguration() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        corsConfiguration.setAllowedOriginPatterns(List.of("*:[*]"));
        corsConfiguration.setAllowedHeaders(List.of("*"));
        corsConfiguration.setExposedHeaders(List.of("*"));
        corsConfiguration.setMaxAge(1000L);
        return corsConfiguration;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .cors()
                .configurationSource(cors -> corsConfiguration()).and()
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .oauth2Login()
                .loginPage( authController.getUrl() )

                .userInfoEndpoint()
                .userService(oauthUserService)
                .and()
                .successHandler(new AuthenticationSuccessHandler() {

                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                        Authentication authentication) throws IOException, ServletException {
                        System.out.println("AuthenticationSuccessHandler invoked");

                        System.out.println("Authentication name: " + authentication.getPrincipal());

                        OidcUser oauthUser = (OidcUser) authentication.getPrincipal();

                        System.out.println(oauthUser.getClaims().get("email"));

                        System.out.println(oauthUser.getClaims().get("name"));
                        String email = oauthUser.getClaims().get("email").toString();
                        String fullName = oauthUser.getClaims().get("name").toString();

                        Optional<User> existingUser = userService.findAll().stream().filter(el ->el.getEmail().equals(email)).findAny();
                        if (existingUser.isEmpty()) {

                            User authUser = new User();
                            authUser.setEmail(email);
                            authUser.setFullName(fullName);
                            authUser.setActivated(true);
                            userService.save(authUser);
                        } else {
                            fullName = existingUser.get().getFullName();
                        }

                        Long id = repository.getByEmail(email).get().getId();

                        String token = jwtProvider.generateOauthAccessToken(email,id,fullName);
                        Map<String, String> newRefreshStorage = authService.getRefreshStorage();
                        newRefreshStorage.put("token",token);

                        authService.setRefreshStorage(newRefreshStorage);

                        response.sendRedirect( authController.getUrl());

                    }

                })

                .and()


                .exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint() {
                    @Override
                    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
                        response.setStatus(401);
                    }
                })
                .and()
                .authorizeHttpRequests(
                        authz -> authz

                                .requestMatchers("/api/auth/**", "/api/auth/token","/api/auth","/swagger-ui/**","api/oauth2/authorization/google","/posts/**", "/websocket-endpoint/**", "/topic/messages","/ws/**").permitAll()
                                .anyRequest().authenticated()
                                .and()
                                .addFilterAfter(jwtFilter, UsernamePasswordAuthenticationFilter.class)

                )
                .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("v3/api-docs/**");
    }

}
