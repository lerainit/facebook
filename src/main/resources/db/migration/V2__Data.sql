INSERT INTO public.users ( full_name,email,password,city,country,gender,work_place,about,birth_date,profile_picture,profile_background_picture,created_date,updated_date,activated,activation_code) VALUES
                                                                                                                                                                                                        ('Alex Smith','alex@gmail.com','$2a$10$BXH1wlAJPIMXvjnJTBoRuea4CvZwSs8/Zqz4bDRZBDJ6hxvXoHlqq','New York','USA','male','UIGA','successful investor','2016-07-26 05:15:58','https://qph.cf2.quoracdn.net/main-qimg-ed424b4d548229863a57603462976e3e.webp' ,'https://photographylife.com/wp-content/uploads/2017/01/Best-of-2016-Nasim-Mansurov-20.jpg','2016-07-26 05:15:58','2016-07-26 05:15:58',true,'a42f726b-5483-4082-bf3c-f9fc7f980c00') ,
                                                                                                                                                                                                        ('Cris Thomson','cris@gmail.com','$2a$10$BXH1wlAJPIMXvjnJTBoRuea4CvZwSs8/Zqz4bDRZBDJ6hxvXoHlqq','London','Great Britain','male','JklO','web designer','2016-07-26 05:15:58', 'https://assets.thehansindia.com/h-upload/2020/05/16/969648-k-pop-singer-bts-v-most-han.webp','https://ichef.bbci.co.uk/news/999/cpsprodpb/6D5A/production/_119449972_10.jpg','2016-07-26 05:15:58','2016-07-26 05:15:58',true,'a42f726b-5483-4082-bf3c-f9fc7f980c00'),
                                                                                                                                                                                                        ('Roger Williams','roger@gmail.com','$2a$10$BXH1wlAJPIMXvjnJTBoRuea4CvZwSs8/Zqz4bDRZBDJ6hxvXoHlqq','LA','USA','male','FAliy Hospital','surgeon','2016-07-26 05:15:58','https://www.thecoldwire.com/wp-content/uploads/2021/11/Closeup-portrait-of-a-handsome-man-at-gym.jpeg','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7SPMxYYTAmSxcMRvEIwePcBNpJi9eEdEM9A&usqp=CAU','2016-07-26 05:15:58','2016-07-26 05:15:58',true,'a42f726b-5483-4082-bf3c-f9fc7f980c00');










INSERT INTO public.friends(user_id,friend_id,status,created_date,updated_date) VALUES

                                                                                   (1,2,'fulfilled','2016-07-26 05:15:58','2016-07-26 05:15:58'),
                                                                                   (2,1,'fulfilled','2016-07-26 05:15:58','2016-07-26 05:15:58'),
                                                                                   (3,2,'fulfilled','2016-07-26 05:15:58','2016-07-26 05:15:58'),
                                                                                   (1,3,'pending','2016-07-26 05:15:58','2016-07-26 05:15:58'),
                                                                                   (2,3,'pending','2016-07-26 05:15:58','2016-07-26 05:15:58'),
                                                                                   (3,1,'pending','2016-07-26 05:15:58','2016-07-26 05:15:58');

INSERT INTO chats (created_date, updated_date, created_by, updated_by)
VALUES
    (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'John', 'John'),
    (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Alice', 'Alice'),
    (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Bob', 'Bob'),
    (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Emma', 'Emma'),
    (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'David', 'David');


INSERT INTO messages (content, created_date, updated_date, created_by, updated_by, chat_id, user_id)
VALUES
    ('Hello', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'John', 'John', 1, 1),
    ('Hi', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Alice', 'Alice', 1, 2),
    ('How are you?', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Bob', 'Bob', 2, 3),
    ('I am fine, thanks!', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Emma', 'Emma', 2, 1),
    ('Good morning', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'David', 'David', 3, 2);

INSERT INTO message_images (created_date, updated_date, created_by, updated_by, img_url, message_id,chat_id)
VALUES
    (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'John', 'John', 'image1.jpg', 1,2),
    (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Alice', 'Alice', 'image2.jpg', 2,3),
    (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Bob', 'Bob', 'image3.jpg', 3,4),
    (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Emma', 'Emma', 'image4.jpg', 4,2),
    (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'David', 'David', 'image5.jpg', 5,3);

INSERT INTO user_images (created_date, updated_date, created_by, updated_by, img_url, user_id,image_user_id)
VALUES
    (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'John', 'John', 'image1.jpg', 1,1),
    (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Alice', 'Alice', 'image2.jpg', 2,2),
    (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Bob', 'Bob', 'image3.jpg', 3,3),
    (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Emma', 'Emma', 'image4.jpg', 1,1),
    (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'David', 'David', 'image5.jpg', 2,2);


INSERT INTO public.posts (user_id, post_type, content, parent_id, created_date, updated_date)
VALUES
    (NULL, 'post', 'Привет, мир!', NULL, '2023-06-25 10:00:00', '2023-06-25 10:00:00'),
    (NULL, 'comment', 'Это отличный пост!', 1, '2023-06-25 10:05:00', '2023-06-25 10:05:00'),
    (NULL, 'post', 'Здесь ничего интересного...', NULL, '2023-06-25 10:10:00', '2023-06-25 10:10:00');

INSERT INTO public.users_liked_posts (post_id, user_id)
VALUES
    (1,2),
    (1,3),
    (2,3),
    (2,1),
    (3,2),
    (3,1);
INSERT INTO public.users_reposted_posts (post_id, user_id)
VALUES
    (2, 3),
    (3, 1),
    (1, 2);
INSERT INTO public.post_images (post_id, img_url, created_date, updated_date)
VALUES
    (1, 'https://example.com/image1.jpg', '2023-06-25 10:00:00', '2023-06-25 10:00:00'),
    (2, 'https://example.com/image2.jpg', '2023-06-25 10:05:00', '2023-06-25 10:05:00');
INSERT INTO public.users_chats (user_id,chat_id) VALUES

                                                     (1,1),
                                                     (1,2),
                                                     (2,3),
                                                     (2,4),
                                                     (3,1),
                                                     (1,3),
                                                     (3,4),
                                                     (3,2);








