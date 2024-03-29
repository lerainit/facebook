package org.finalproject.service.jwt;




import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.*;
import org.finalproject.entity.User;
import org.finalproject.exception.AuthException;
import org.finalproject.jwt.*;
import org.finalproject.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
@RequiredArgsConstructor
@Getter
@Setter
@Transactional
@AllArgsConstructor
public class AuthService {
    @Autowired
    private  UserService userService;
    private  Map<String, String> refreshStorage = new HashMap<>();

    private  Map<String, HttpServletResponse> responseStorage = new HashMap<>();
    @Autowired
    private GeneralService<User> serviceUser;
    @Autowired
    private  JwtProvider jwtProvider;
    @Autowired
    private  PasswordEncoder passwordEncoder;

    @Autowired

    private JavaMailSender javaMailSender;

    public JwtResponse login(@NonNull JwtRequest authRequest) {
        final User user = userService.getByEmail(authRequest.getEmail())
                .orElseThrow(() -> new AuthException("User not found"));
        if (passwordEncoder.matches(authRequest.getPassword(), user.getPassword()) && user.isActivated() == true) {

            final String refreshToken = jwtProvider.generateRefreshToken(user);
           if (refreshStorage.containsKey(authRequest.getEmail())) {
               return new JwtResponse(jwtProvider.generateAccessToken(user), refreshStorage.get(authRequest.getEmail()));

           } else {
           refreshStorage.put(authRequest.getEmail(), refreshToken);

            return new JwtResponse(jwtProvider.generateAccessToken(user), refreshToken);

           }
        } else {
            throw new AuthException("Password is incorrect");
        }
    }

    public void register(@NonNull RegisterRequest authRequest) {
        User newUser = new User();
        newUser.setEmail(authRequest.getEmail());
        String encodedPassword =  passwordEncoder.encode(authRequest.getPassword());
        newUser.setPassword(encodedPassword);
        String fullName = authRequest.getName() + " " + authRequest.getSurname();
        newUser.setFullName(fullName);
        newUser.setGender(authRequest.getGender());
        LocalDate birthDate =  LocalDate.of(Integer.parseInt(authRequest.getYear()),Integer.parseInt(authRequest.getMonth()),Integer.parseInt(authRequest.getDay()));
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Instant instant = birthDate.atStartOfDay(defaultZoneId).toInstant();
        Date birthDay = Date.from(instant);

        newUser.setBirthDate(birthDay);
        newUser.setActivationCode(UUID.randomUUID().toString());
        newUser.setActivated(false);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(authRequest.getEmail());
        simpleMailMessage.setSubject("Visit this page to activate you account");
        simpleMailMessage.setText("https://social-network-backend-2782464b9c31.herokuapp.com/api/auth/activate/" + newUser.getActivationCode());

        javaMailSender.send(simpleMailMessage);
        serviceUser.save(newUser);
    }

    public void sendMessage(String email,String code) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject(" Use this code to restore your password");
        simpleMailMessage.setText( "Code:"  + code);

        javaMailSender.send(simpleMailMessage);


    }

    public void loginAuth2(String email,String refreshToken) {


        refreshStorage.put(email, refreshToken);

    }

    public JwtResponse getAccessToken(@NonNull String refreshToken) {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String email = claims.getSubject();

            System.out.println(email);
            final String saveRefreshToken = refreshStorage.get(email);

            System.out.println(saveRefreshToken);
            System.out.println(saveRefreshToken.equals(refreshToken));
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
                final User user = userService.getByEmail(email)
                        .orElseThrow(() -> new AuthException("User not found"));
                final String accessToken = jwtProvider.generateAccessToken(user);
                return new JwtResponse(accessToken, null);
            }
        }
        return new JwtResponse(null, null);
    }

    public JwtResponse refresh(@NonNull String refreshToken) {

            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String email = claims.getSubject();
            final String saveRefreshToken = refreshStorage.get(email);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
                final User user = userService.getByEmail(email)
                        .orElseThrow(() -> new AuthException("User not found"));
                final String accessToken = jwtProvider.generateAccessToken(user);
                final String newRefreshToken = jwtProvider.generateRefreshToken(user);
                refreshStorage.put(user.getEmail(), newRefreshToken);
                return new JwtResponse(accessToken, newRefreshToken);
            } else {
                return new JwtResponse(null, null);
            }


    }

    public String returnRefresh( String refresh) {

        final Claims claims = jwtProvider.getRefreshClaims(refresh);
        final String email = claims.getSubject();
        refreshStorage.put(email,refresh);
        return refreshStorage.get(email);

    }

   public void sendChangePasswordMessage(Optional<User> userOptional, Email email) {

       SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
       simpleMailMessage.setTo(email.getEmail());
       simpleMailMessage.setSubject(" Use this code to restore your password");
       simpleMailMessage.setText(" Code:"  + userOptional.get().getActivationCode());

       javaMailSender.send(simpleMailMessage);

   }

    public JwtAuthentication getAuthInfo() {
        return (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }

}
