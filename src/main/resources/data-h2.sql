
INSERT INTO public.users ( full_name,email,password,city,country,gender,work_place,about,birth_date,profile_picture,profile_background_picture,created_date,updated_date, activated, activation_code)
VALUES
('Alex Smith','alex@gmail.com','$2a$10$BXH1wlAJPIMXvjnJTBoRuea4CvZwSs8/Zqz4bDRZBDJ6hxvXoHlqq','New York','USA','male','UIGA','successful investor',PARSEDATETIME('11 Mar 1985, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),'https://qph.cf2.quoracdn.net/main-qimg-ed424b4d548229863a57603462976e3e.webp' ,'https://photographylife.com/wp-content/uploads/2017/01/Best-of-2016-Nasim-Mansurov-20.jpg',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'), true, 'a42f726b-5483-4082-bf3c-f9fc7f980c00') ,
('Cris Thomson','cris@gmail.com','$2a$10$BXH1wlAJPIMXvjnJTBoRuea4CvZwSs8/Zqz4bDRZBDJ6hxvXoHlqq','London','Great Britain','male','JklO','web designer',PARSEDATETIME('15 Feb 1999, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'), 'https://assets.thehansindia.com/h-upload/2020/05/16/969648-k-pop-singer-bts-v-most-han.webp','https://ichef.bbci.co.uk/news/999/cpsprodpb/6D5A/production/_119449972_10.jpg',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'), true, 'a42f726b-5483-4082-bf3c-f9fc7f980c00'),
('Greg White','greg@gmail.com','$2a$10$BXH1wlAJPIMXvjnJTBoRuea4CvZwSs8/Zqz4bDRZBDJ6hxvXoHlqq','LA','USA','male','FAliy Hospital','surgeon',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),'https://storage.yandexcloud.net/yandexpro/storage/images/originals/qZEALznNzzFc0pO7igFzH1qNsrhvp2pOpvNjVzcv.jpg','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7SPMxYYTAmSxcMRvEIwePcBNpJi9eEdEM9A&usqp=CAU',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'), true,'a42f726b-5483-4082-bf3c-f9fc7f980c00'),
('Amely Brown','amely@gmail.com','$2a$10$BXH1wlAJPIMXvjnJTBoRuea4CvZwSs8/Zqz4bDRZBDJ6hxvXoHlqq','Kyiv','Ukraine','female','HollyDay Hotel','receptionist',PARSEDATETIME('01 Aug 2007, 00:00:00 AM','dd MMM yyyy, hh:mm:ss a','en'),'https://images.pexels.com/photos/17564939/pexels-photo-17564939.jpeg','https://moya-planeta.ru/upload/images/l/51/ed/51edab18a4faf2efcf3edf37a51870f7adb69209.jpg',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'), true,'a42f726b-5483-4082-bf3c-f9fc7f980c00'),
('Angelina Brown','angelina@gmail.com','$2a$10$BXH1wlAJPIMXvjnJTBoRuea4CvZwSs8/Zqz4bDRZBDJ6hxvXoHlqq','Kyiv','Ukraine','female','HollyDay Hotel','receptionist',PARSEDATETIME('01 Aug 2007, 00:00:00 AM','dd MMM yyyy, hh:mm:ss a','en'),'https://images.pexels.com/photos/16179987/pexels-photo-16179987.jpeg','https://moya-planeta.ru/upload/images/l/51/ed/51edab18a4faf2efcf3edf37a51870f7adb69209.jpg',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'), true,'a42f726b-5483-4082-bf3c-f9fc7f980c00'),
('Elise Yellow','elise@gmail.com','$2a$10$BXH1wlAJPIMXvjnJTBoRuea4CvZwSs8/Zqz4bDRZBDJ6hxvXoHlqq','Kyiv','Ukraine','female','HollyDay Hotel','receptionist',null,'https://images.pexels.com/photos/9571268/pexels-photo-9571268.jpeg','https://moya-planeta.ru/upload/images/l/51/ed/51edab18a4faf2efcf3edf37a51870f7adb69209.jpg',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'), true,'a42f726b-5483-4082-bf3c-f9fc7f980c00'),
('Suzi Blue','suzi@gmail.com','$2a$10$BXH1wlAJPIMXvjnJTBoRuea4CvZwSs8/Zqz4bDRZBDJ6hxvXoHlqq','Kyiv','Ukraine','female','HollyDay Hotel','receptionist',PARSEDATETIME('10 Aug 2007, 00:00:00 AM','dd MMM yyyy, hh:mm:ss a','en'),'https://images.pexels.com/photos/17871514/pexels-photo-17871514.jpeg','https://moya-planeta.ru/upload/images/l/51/ed/51edab18a4faf2efcf3edf37a51870f7adb69209.jpg',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'), true,'a42f726b-5483-4082-bf3c-f9fc7f980c00'),
('Tina White','tina@gmail.com','$2a$10$BXH1wlAJPIMXvjnJTBoRuea4CvZwSs8/Zqz4bDRZBDJ6hxvXoHlqq','Kyiv','Ukraine','female','HollyDay Hotel','receptionist',PARSEDATETIME('15 Aug 2007, 00:00:00 AM','dd MMM yyyy, hh:mm:ss a','en'),'https://images.pexels.com/photos/17987491/pexels-photo-17987491.jpeg','https://moya-planeta.ru/upload/images/l/51/ed/51edab18a4faf2efcf3edf37a51870f7adb69209.jpg',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'), true,'a42f726b-5483-4082-bf3c-f9fc7f980c00'),
('Lilia Gray','lilia@gmail.com','$2a$10$BXH1wlAJPIMXvjnJTBoRuea4CvZwSs8/Zqz4bDRZBDJ6hxvXoHlqq','Kyiv','Ukraine','female','HollyDay Hotel','receptionist',PARSEDATETIME('20 Aug 2007, 00:00:00 AM','dd MMM yyyy, hh:mm:ss a','en'),'https://images.pexels.com/photos/17997548/pexels-photo-17997548.jpeg','https://moya-planeta.ru/upload/images/l/51/ed/51edab18a4faf2efcf3edf37a51870f7adb69209.jpg',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'), true,'a42f726b-5483-4082-bf3c-f9fc7f980c00'),
('Jessie Black','jessie@gmail.com','$2a$10$BXH1wlAJPIMXvjnJTBoRuea4CvZwSs8/Zqz4bDRZBDJ6hxvXoHlqq','Kyiv','Ukraine','female','HollyDay Hotel','receptionist',PARSEDATETIME('09 Aug 2007, 00:00:00 AM','dd MMM yyyy, hh:mm:ss a','en'),'https://images.pexels.com/photos/17564939/pexels-photo-17564939.jpeg','https://moya-planeta.ru/upload/images/l/51/ed/51edab18a4faf2efcf3edf37a51870f7adb69209.jpg',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'), true,'a42f726b-5483-4082-bf3c-f9fc7f980c00'),
('Roger Williams','roger@gmail.com','$2a$10$BXH1wlAJPIMXvjnJTBoRuea4CvZwSs8/Zqz4bDRZBDJ6hxvXoHlqq','Boston','USA','male','MI','student',PARSEDATETIME('08 Dec 2008, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),'https://www.thecoldwire.com/wp-content/uploads/2021/11/Closeup-portrait-of-a-handsome-man-at-gym.jpeg','https://ethnomir.ru/upload/medialibrary/6fb/ozero_baikal.jpg',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'), true,'a42f726b-5483-4082-bf3c-f9fc7f980c00'),
('Jason Yellow','JasonYellow@gmail.com','$2a$10$BXH1wlAJPIMXvjnJTBoRuea4CvZwSs8/Zqz4bDRZBDJ6hxvXoHlqq','Boston','USA','male','Boston University','student',PARSEDATETIME('25 Dec 2010, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSgoz9SaONgwiA7QtescP08tbxF4haEHBs9Yg&usqp=CAU','https://www.ejin.ru/wp-content/uploads/2017/09/1-716.jpg',PARSEDATETIME('06 Sep 1998, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'), true,'a42f726b-5483-4082-bf3c-f9fc7f980c00'),
('Igor Gray','IgorGray@gmail.com','$2a$10$BXH1wlAJPIMXvjnJTBoRuea4CvZwSs8/Zqz4bDRZBDJ6hxvXoHlqq','Kyiv','Ukraine','male','NTKI','student',PARSEDATETIME('08 Dec 2008, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQ8MANQDcQRChsMnCj5bfwMOBbkGENZqZ2eA&usqp=CAU','https://klike.net/uploads/posts/2019-09/1568528357_1.jpg',PARSEDATETIME('06 Sep 1998, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'), true,'a42f726b-5483-4082-bf3c-f9fc7f980c00');


INSERT INTO public.friends(user_id,friend_id,status,created_date,updated_date)
VALUES
(1,2,'accepted',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en')),
(2,3,'accepted',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en')),
(4,1,'accepted',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en')),
(4,3,'accepted',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en')),
(4,6,'accepted',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en')),
(4,7,'accepted',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en')),
(4,8,'accepted',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en')),
(4,9,'accepted',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en')),
(4,10,'accepted',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en')),
(4,11,'accepted',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en')),
(4,12,'accepted',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en')),
(4,5,'accepted',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en')),
(3,1,'pending',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en')),
(2,4,'pending',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en')),
(1,5,'pending',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en')),
(2,5,'accepted',PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'),PARSEDATETIME('26 Jul 2016, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'));

INSERT INTO chats (created_date, updated_date, created_by, updated_by)
VALUES
    (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'John', 'John'),
    (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Alice', 'Alice'),
    (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Bob', 'Bob'),
    (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Emma', 'Emma'),
    (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'David', 'David');

DROP TABLE IF EXISTS public.users_chats CASCADE ;
CREATE TABLE public.users_chats (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    user_id INT NOT NULL,
                                    chat_id INT NOT NULL ,
                                    foreign key (user_id) references users(id),
                                    foreign key (chat_id) references chats(id)

);
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


