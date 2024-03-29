DROP TABLE IF EXISTS public.posts CASCADE ;
CREATE TABLE public.posts (
                              id SERIAL PRIMARY KEY,
                              user_id INT REFERENCES users(id),
                              post_type VARCHAR(255) NOT NULL,
                              content VARCHAR(255),
                              parent_id INT REFERENCES posts(id),
                              created_date TIMESTAMP NOT NULL,
                              updated_date TIMESTAMP NOT NULL,
                              created_by VARCHAR,
                              updated_by VARCHAR
);

INSERT INTO public.posts (user_id, post_type, content, parent_id, created_date, updated_date)
VALUES
    (1, 'post', 'Привет, мир!', NULL, '2023-06-25 10:00:00', '2023-06-25 10:00:00'),
    (3, 'comment', 'Это отличный пост!', 1, '2023-06-25 10:05:00', '2023-06-25 10:05:00'),
    (2, 'post', 'Здесь ничего интересного...', NULL, '2023-06-25 10:10:00', '2023-06-25 10:10:00'),
    (1, 'post', 'Здесь я провел восхитительный отпуск!', NULL, '2023-06-25 10:00:00', '2023-06-25 10:00:00'),
    (3, 'comment', 'Прекрасное фото! ', 1, '2023-06-25 10:05:00', '2023-06-25 10:05:00'),
    (2, 'post', 'Новый рецепт моей любимой пасты ', NULL, '2023-06-25 10:10:00', '2023-06-25 10:10:00'),
    (1, 'post', 'Наш новый член семьи ', NULL, '2023-06-25 10:15:00', '2023-06-25 10:15:00'),
    (3, 'comment', 'Какой милый котенок!', 4, '2023-06-25 10:20:00', '2023-06-25 10:20:00'),
    (2, 'post', 'Поделюсь своими мыслями о путешествии...', NULL, '2023-06-25 10:25:00', '2023-06-25 10:25:00'),
    (1, 'comment', 'У вас просто потрясающие фото!', 6, '2023-06-25 10:30:00', '2023-06-25 10:30:00'),
    (3, 'post', 'Сегодня замечательный день! ', NULL, '2023-06-25 10:35:00', '2023-06-25 10:35:00'),
    (2, 'comment', 'Отличный настрой на фото ', 8, '2023-06-25 10:40:00', '2023-06-25 10:40:00'),
    (1, 'post', 'Поздравляю с днем рождения, друг! ', NULL, '2023-06-25 10:45:00', '2023-06-25 10:45:00'),
    (3, 'comment', 'Спасибо за поздравления!', 10, '2023-06-25 10:50:00', '2023-06-25 10:50:00'),
    (2, 'post', 'Моя новая татуировка! ', NULL, '2023-06-25 10:55:00', '2023-06-25 10:55:00'),
    (1, 'comment', 'Очень стильно!', 10, '2023-06-25 11:00:00', '2023-06-25 11:00:00'),
    (3, 'post', 'С друзьями на пляже ', NULL, '2023-06-25 11:05:00', '2023-06-25 11:05:00'),
    (2, 'comment', 'Какой классный день провели!', 14, '2023-06-25 11:10:00', '2023-06-25 11:10:00'),
    (1, 'post', 'Спасибо за отличное вечеринку! ', NULL, '2023-06-25 11:15:00', '2023-06-25 11:15:00');

DROP TABLE IF EXISTS public.users_liked_posts CASCADE;
CREATE TABLE public.users_liked_posts (
                                          id SERIAL PRIMARY KEY,
                                          post_id INTEGER REFERENCES posts(id),
                                          user_id INTEGER REFERENCES users(id)
);

INSERT INTO public.users_liked_posts (post_id, user_id)
VALUES
    (1, 2),(1, 3),(2, 3),(2, 1),(3, 2),(3, 1),(4, 2),(4, 3),(6, 3),(5, 1),(5, 2),(8, 1),(7, 2),(7, 3),(9, 3),(11, 1),(10, 2),(10, 1),(11, 2),(7, 3),(13, 3),(12, 1),(12, 2),(14, 1),(15, 1),(15, 2),(16, 2),(16, 3),(17, 3),(17, 1),(18, 1),(18, 2);

DROP TABLE IF EXISTS public.post_images CASCADE ;
CREATE TABLE public.post_images (
                                    id SERIAL PRIMARY KEY,
                                    post_id INT REFERENCES posts(id),
                                    img_url VARCHAR(255),
                                    created_date TIMESTAMP NOT NULL,
                                    updated_date TIMESTAMP NOT NULL,
                                    created_by VARCHAR,
                                    updated_by VARCHAR
);
INSERT INTO public.post_images (post_id, img_url, created_date, updated_date)
VALUES
    (3, 'https://cdn.pixabay.com/photo/2020/08/28/13/15/river-5524569_1280.jpg', '2023-06-25 10:10:00', '2023-06-25 10:10:00'),
    (4, 'https://images.pexels.com/photos/785293/pexels-photo-785293.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', '2023-06-25 10:15:00', '2023-06-25 10:15:00'),
    (5, 'https://linchakin.com/files/word/1000/212/1.jpg', '2023-06-25 10:20:00', '2023-06-25 10:20:00'),
    (6, 'https://p4.wallpaperbetter.com/wallpaper/30/770/536/full-hd-download-nature-images-1920x1200-wallpaper-preview.jpg', '2023-06-25 10:25:00', '2023-06-25 10:25:00'),
    (7, 'https://media.istockphoto.com/id/546200366/ru/%D1%84%D0%BE%D1%82%D0%BE/%D1%80%D0%BE%D1%81%D1%82.jpg?s=612x612&w=0&k=20&c=F07W1xuXGypn38uUQgFQQoC0QC4lUIudgRyAI24kINc=', '2023-06-25 10:30:00', '2023-06-25 10:30:00'),
    (8, 'https://thumbs.dreamstime.com/b/%D1%81%D1%84%D0%B5%D1%80%D0%B0-%D0%B8%D0%B7%D0%BE%D0%B1%D1%80%D0%B0%D0%B6%D0%B5%D0%BD%D0%B8%D0%B9-44140012.jpg', '2023-06-25 10:35:00', '2023-06-25 10:35:00'),
    (9, 'https://cdn.pixabay.com/photo/2018/02/08/22/27/flower-3140492_1280.jpg', '2023-06-25 10:40:00', '2023-06-25 10:40:00'),
    (10, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8lyxdgQzYPjUH1mMXnkOQ3ZHP1KfYa8DJQA&usqp=CAU', '2023-06-25 10:45:00', '2023-06-25 10:45:00'),
    (11, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPR6-gNbPwQDSa4J7aw2wt54kn3kyp6_w90w&usqp=CAU', '2023-06-25 10:50:00', '2023-06-25 10:50:00'),
    (12, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTkGnLh1zk5zJL1hatwtKg40YI9BSCfckFPYQ&usqp=CAU', '2023-06-25 10:55:00', '2023-06-25 10:55:00');
