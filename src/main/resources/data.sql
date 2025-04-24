-- CameraColor
INSERT INTO camera_color (camera_color_id, camera_color_name) VALUES
(1, 'blue'),
(2, 'green'),
(3, 'pink'),
(4, 'purple'),
(5, 'red'),
(6, 'yellow');

-- CameraImage
INSERT INTO camera_image (camera_image_id, image_url, camera_color_id) VALUES
(1, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/1-blue.png', 1),
(2, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/1-yellow.png', 6),
(3, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/1-purple.png', 4),
(4, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/1-green.png', 2),
(5, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/1-red.png', 5),
(6, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/1-pink.png', 3),

(7, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/2-blue.png', 1),
(8, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/2-yellow.png', 6),
(9, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/2-purple.png', 4),
(10, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/2-green.png', 2),
(11, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/2-red.png', 5),
(12, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/2-pink.png', 3),

(13, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/3-blue.png', 1),
(14, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/3-yellow.png', 6),
(15, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/3-purple.png', 4),
(16, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/3-green.png', 2),
(17, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/3-red.png', 5),
(18, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/3-pink.png', 3),

(19, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/4-blue.png', 1),
(20, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/4-yellow.png', 6),
(21, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/4-purple.png', 4),
(22, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/4-green.png', 2),
(23, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/4-red.png', 5),
(24, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/4-pink.png', 3),

(25, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/5-blue.png', 1),
(26, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/5-yellow.png', 6),
(27, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/5-purple.png', 4),
(28, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/5-green.png', 2),
(29, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/5-red.png', 5),
(30, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/cameraImage/5-pink.png', 3);


-- ChallengeCategory (도전과제 카테고리) 더미 데이터
INSERT INTO challenge_category (challenge_category_name, created_at, modified_at) VALUES
( '한식', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
( '일식', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
( '중식', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
( '양식', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
( '도감', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Title (칭호) 더미 데이터
INSERT INTO title (title_id, title_name, description, color_code, created_at, modified_at) VALUES
(1, '한식 초보', '한식 레시피 5개 작성 시 획득', '#FFB6C1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, '중식 초보', '중식 레시피 5개 작성 시 획득', '#FFD700', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, '일식 초보', '일식 레시피 5개 작성 시 획득', '#ADD8E6', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, '양식 초보', '양식 레시피 5개 작성 시 획득', '#90EE90', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(5, '도감 초보', '레시피 10개 등록', '#90EE90', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Challenge (도전과제) 더미 데이터
INSERT INTO challenge (description, goal_count, challenge_level, title_id, challenge_category_id, created_at, modified_at) VALUES
('한식 레시피를 5개 작성하세요.', 5, 1, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('중식 레시피를 5개 작성하세요.', 5, 1, 2, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('일식 레시피를 5개 작성하세요.', 5, 1, 3, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('양식 레시피를 5개 작성하세요.', 5, 1, 4, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('도감에 레시피를 10개 등록하세요.', 5, 1, 5, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Member 더미 데이터 (member_id = 1)
--INSERT INTO member (
--    login_id, email, nick_name, password, phone_number,
--    profile, title, rice_point, member_status,
--    created_at, modified_at
--) VALUES (
--    'tjsk2222', 'tjsk2222@gmail.com', '택택',
--    '{bcrypt}$2a$10$n1ZYr9wraXA.1sJ4YRoIH./kfrVUKtgwAwPhyshUXK3xc32.Jvd6.',
--    '010-1111-2222', 'https://example.com/profile1.png', '요리왕', 300, 'MEMBER_ACTIVE',
--    CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
--);

INSERT INTO member (login_id, email, nick_name, password, phone_number, profile, title, rice_point, member_status, created_at, modified_at) VALUES
('tjsk2222', 'tjsk2222@gmail.com', '택택', '{bcrypt}$2a$10$n1ZYr9wraXA.1sJ4YRoIH./kfrVUKtgwAwPhyshUXK3xc32.Jvd6.', '010-1111-2222', 'https://example.com/profile1.png', '한식 초보', 300, 'MEMBER_ACTIVE',
     CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
( 'user2', 'user1@example.com', '정희', '{bcrypt}$2a$10$n1ZYr9wraXA.1sJ4YRoIH./kfrVUKtgwAwPhyshUXK3xc32.Jvd6.', '052-115-7815', 'https://example.com/profiles/user1.jpg', NULL, 49, 'MEMBER_ACTIVE', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 'user3', 'user3@example.com', '현우', '{bcrypt}$2a$10$n1ZYr9wraXA.1sJ4YRoIH./kfrVUKtgwAwPhyshUXK3xc32.Jvd6.', '052-232-0947', 'https://example.com/profiles/user3.jpg', NULL, 53, 'MEMBER_ACTIVE', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 'user4', 'user4@example.com', '민재', '{bcrypt}$2a$10$n1ZYr9wraXA.1sJ4YRoIH./kfrVUKtgwAwPhyshUXK3xc32.Jvd6.', '063-515-9179', 'https://example.com/profiles/user4.jpg', NULL, 5, 'MEMBER_ACTIVE', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 'user5', 'user5@example.com', '숙자', '{bcrypt}$2a$10$n1ZYr9wraXA.1sJ4YRoIH./kfrVUKtgwAwPhyshUXK3xc32.Jvd6.', '033-399-1615', 'https://example.com/profiles/user5.jpg', NULL, 33, 'MEMBER_ACTIVE', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 'user6', 'user6@example.com', '정순', '{bcrypt}$2a$10$n1ZYr9wraXA.1sJ4YRoIH./kfrVUKtgwAwPhyshUXK3xc32.Jvd6.', '061-208-7091', 'https://example.com/profiles/user6.jpg', NULL, 65, 'MEMBER_ACTIVE', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 'user7', 'user7@example.com', '영희', '{bcrypt}$2a$10$n1ZYr9wraXA.1sJ4YRoIH./kfrVUKtgwAwPhyshUXK3xc32.Jvd6.', '062-207-6984', 'https://example.com/profiles/user7.jpg', NULL, 62, 'MEMBER_ACTIVE', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 'user8', 'user8@example.com', '순자', '{bcrypt}$2a$10$n1ZYr9wraXA.1sJ4YRoIH./kfrVUKtgwAwPhyshUXK3xc32.Jvd6.', '070-6109-3523', 'https://example.com/profiles/user8.jpg', NULL, 51, 'MEMBER_ACTIVE', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 'user9', 'user9@example.com', '영수', '{bcrypt}$2a$10$n1ZYr9wraXA.1sJ4YRoIH./kfrVUKtgwAwPhyshUXK3xc32.Jvd6.', '031-754-7063', 'https://example.com/profiles/user9.jpg', NULL, 100, 'MEMBER_ACTIVE', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 'user10', 'user10@example.com', '민지', '{bcrypt}$2a$10$n1ZYr9wraXA.1sJ4YRoIH./kfrVUKtgwAwPhyshUXK3xc32.Jvd6.', '051-217-6104', 'https://example.com/profiles/user10.jpg', NULL, 38, 'MEMBER_ACTIVE', '2024-01-01 10:00:00', '2024-01-02 10:00:00');

INSERT INTO member_roles (member_member_id, roles) VALUES
(1, 'USER'),
(2, 'USER'),
(3, 'USER'),
(4, 'USER'),
(5, 'USER'),
(6, 'USER'),
(7, 'USER'),
(8, 'USER'),
(9, 'USER'),
(10, 'USER');

INSERT INTO member_challenge (member_id, challenge_id, challenge_status, created_at, modified_at) VALUES
( 8, 1, 'COMPLETE', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 6, 2, 'INCOMPLETE', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 6, 4, 'COMPLETE', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 2, 5, 'INCOMPLETE', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 10, 3, 'COMPLETE', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 4, 4, 'INCOMPLETE', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 1, 5, 'COMPLETE', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 2, 4, 'INCOMPLETE', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 6, 3, 'COMPLETE', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 6, 1, 'COMPLETE', '2024-01-01 10:00:00', '2024-01-02 10:00:00');

INSERT INTO member_title (member_id, title_id, created_at, modified_at) VALUES
( 3, 2, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 8, 4, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 1, 1, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 9, 3, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 10, 2, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 5, 2, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 4, 2, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 5, 4, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 7, 3, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 1, 5, '2024-01-01 10:00:00', '2024-01-02 10:00:00');

INSERT INTO payment (amount, rice_amount, requested_at, completed_at, refund_reason, payment_status, member_id, created_at, modified_at) VALUES
( 8653, 15, '2025-04-18 03:14:15', '2025-04-18 03:14:15', '사유1', 'COMPLETED', 10, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 2653, 99, '2025-04-18 03:14:15', '2025-04-18 03:14:15', '사유2', 'COMPLETED', 7, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 4266, 43, '2025-04-18 03:14:15', '2025-04-18 03:14:15', '사유3', 'COMPLETED', 6, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 8704, 82, '2025-04-18 03:14:15', '2025-04-18 03:14:15', '사유4', 'COMPLETED', 3, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 4332, 17, '2025-04-18 03:14:15', '2025-04-18 03:14:15', '사유5', 'COMPLETED', 3, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 3653, 53, '2025-04-18 03:14:15', '2025-04-18 03:14:15', '사유6', 'COMPLETED', 9, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 5107, 25, '2025-04-18 03:14:15', '2025-04-18 03:14:15', '사유7', 'COMPLETED', 10, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 8246, 95, '2025-04-18 03:14:15', '2025-04-18 03:14:15', '사유8', 'COMPLETED', 3, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 1216, 70, '2025-04-18 03:14:15', '2025-04-18 03:14:15', '사유9', 'COMPLETED', 7, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 9332, 49, '2025-04-18 03:14:15', '2025-04-18 03:14:15', '사유10', 'COMPLETED', 6, '2024-01-01 10:00:00', '2024-01-02 10:00:00');

INSERT INTO menu_category (menu_category_name, created_at, modified_at) VALUES
( '카테고리1', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '카테고리2', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '카테고리3', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '카테고리4', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '카테고리5', '2024-01-01 10:00:00', '2024-01-02 10:00:00');

INSERT INTO menu (menu_name, menu_category_id, created_at, modified_at) VALUES
( '메뉴1', 4, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '메뉴2', 3, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '메뉴3', 5, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '메뉴4', 2, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '메뉴5', 5, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '메뉴6', 2, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '메뉴7', 3, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '메뉴8', 2, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '메뉴9', 1, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '메뉴10', 5, '2024-01-01 10:00:00', '2024-01-02 10:00:00');

INSERT INTO recipe_board (title, image, recipe_status, recipe_board_status, member_id, menu_id, created_at, modified_at) VALUES
( '레시피1','https://example.com/recipes/recipe1.jpg',  'RECIPE_PRIVATE', 'RECIPE_BOARD_POST', 5, 9, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '레시피2','https://example.com/recipes/recipe2.jpg',  'RECIPE_PUBLIC', 'RECIPE_BOARD_POST', 10, 3, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '레시피3','https://example.com/recipes/recipe3.jpg',  'RECIPE_PRIVATE', 'RECIPE_BOARD_POST', 5, 2, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '레시피4','https://example.com/recipes/recipe4.jpg',  'RECIPE_PUBLIC', 'RECIPE_BOARD_POST', 2, 6, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '레시피5','https://example.com/recipes/recipe5.jpg',  'RECIPE_PRIVATE', 'RECIPE_BOARD_POST', 8, 9, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '레시피6','https://example.com/recipes/recipe6.jpg',  'RECIPE_PUBLIC', 'RECIPE_BOARD_POST', 2, 6, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '레시피7','https://example.com/recipes/recipe7.jpg',  'RECIPE_PRIVATE', 'RECIPE_BOARD_POST', 7, 6, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '레시피8','https://example.com/recipes/recipe8.jpg',  'RECIPE_PUBLIC', 'RECIPE_BOARD_POST', 10, 4, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '레시피9','https://example.com/recipes/recipe9.jpg',  'RECIPE_PRIVATE', 'RECIPE_BOARD_POST', 9, 8, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '레시피10','https://example.com/recipes/recipe10.jpg',  'RECIPE_PUBLIC', 'RECIPE_BOARD_POST', 8, 9, '2024-01-01 10:00:00', '2024-01-02 10:00:00');

INSERT INTO bookmark (member_id, recipe_board_id, created_at, modified_at) VALUES
( 5, 1, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 9, 1, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 2, 7, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 1, 10, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 8, 6, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 4, 6, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 2, 4, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 10, 4, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 4, 3, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 9, 8, '2024-01-01 10:00:00', '2024-01-02 10:00:00');

INSERT INTO ingredient (ingredient_name, image, sub_category, dtype) VALUES
( '주재료1', 'https://example.com/ingredients/main1.jpg', '잎채소', 'MAIN'),
( '주재료2', 'https://example.com/ingredients/main2.jpg', '잎채소', 'MAIN'),
( '주재료3', 'https://example.com/ingredients/main3.jpg', '잎채소', 'MAIN'),
( '주재료4', 'https://example.com/ingredients/main4.jpg', '잎채소', 'MAIN'),
( '주재료5', 'https://example.com/ingredients/main5.jpg', '잎채소', 'MAIN'),
( '조미료6', 'https://example.com/ingredients/season6.jpg', null, 'SEASONING'),
( '조미료7', 'https://example.com/ingredients/season7.jpg', null, 'SEASONING'),
( '조미료8', 'https://example.com/ingredients/season8.jpg',null, 'SEASONING'),
( '조미료9', 'https://example.com/ingredients/season9.jpg',null, 'SEASONING'),
( '조미료10', 'https://example.com/ingredients/season10.jpg',null, 'SEASONING');

INSERT INTO menu_ingredient (menu_id, ingredient_id, created_at, modified_at) VALUES
( 7, 5, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 3, 9, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 1, 8, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 2, 6, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 1, 9, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 5, 3, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 4, 8, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 6, 10, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 5, 6, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 10, 10, '2024-01-01 10:00:00', '2024-01-02 10:00:00');

INSERT INTO recipe_board_ingredient (recipe_board_id, ingredient_id, created_at, modified_at) VALUES
( 3, 5, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 7, 7, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 2, 1, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 10, 4, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 6, 3, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 4, 4, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 8, 7, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 10, 7, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 1, 7, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 10, 7, '2024-01-01 10:00:00', '2024-01-02 10:00:00');

INSERT INTO recipe_step (title, created_at, modified_at) VALUES
( '스텝제목1', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '스텝제목2', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '스텝제목3', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '스텝제목4', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '스텝제목5', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '스텝제목6', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '스텝제목7', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '스텝제목8', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '스텝제목9', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( '스텝제목10', '2024-01-01 10:00:00', '2024-01-02 10:00:00');

INSERT INTO recipe_board_step (step_order, recipe_board_id, recipe_step_id, created_at, modified_at) VALUES
( 1, 1, 1, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 2, 3, 2, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 3, 8, 3, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 4, 2, 4, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 5, 5, 5, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 6, 3, 6, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 7, 8, 7, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 8, 9, 8, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 9, 8, 9, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 10, 9, 10, '2024-01-01 10:00:00', '2024-01-02 10:00:00');

INSERT INTO recipe_step_detail (detail_order_number, description, image, recipe_board_step_id, created_at, modified_at) VALUES
( 1, '1번째 단계 설명', 'https://example.com/steps/detail1.jpg', 1, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 2, '2번째 단계 설명', 'https://example.com/steps/detail2.jpg', 2, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 3, '3번째 단계 설명', 'https://example.com/steps/detail3.jpg', 3, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 4, '4번째 단계 설명', 'https://example.com/steps/detail4.jpg', 4, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 5, '5번째 단계 설명', 'https://example.com/steps/detail5.jpg', 5, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 6, '6번째 단계 설명', 'https://example.com/steps/detail6.jpg', 6, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 7, '7번째 단계 설명', 'https://example.com/steps/detail7.jpg', 7, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 8, '8번째 단계 설명', 'https://example.com/steps/detail8.jpg', 8, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 9, '9번째 단계 설명', 'https://example.com/steps/detail9.jpg', 9, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 10, '10번째 단계 설명', 'https://example.com/steps/detail10.jpg', 10, '2024-01-01 10:00:00', '2024-01-02 10:00:00');


