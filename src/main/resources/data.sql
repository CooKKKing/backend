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


-- 1. 도전과제 카테고리
INSERT INTO challenge_category (name, description, category, created_at, modified_at) VALUES
('한식', '한식 요리 관련 도전과제', '한식', NOW(), NOW()),
('일식', '일식 요리 관련 도전과제', '일식', NOW(), NOW()),
('중식', '중식 요리 관련 도전과제', '중식', NOW(), NOW()),
('양식', '양식 요리 관련 도전과제', '양식', NOW(), NOW()),
('좋아요', '좋아요 요리 관련 도전과제', '좋아요', NOW(), NOW()),
('북마크', '북마크 요리 관련 도전과제', '북마크', NOW(), NOW()),
('밥풀', '밥풀 요리 관련 도전과제', '밥풀', NOW(), NOW()),
('도감', '도감 요리 관련 도전과제', '도감', NOW(), NOW()),
('웰컴', '회원가입 도전과제', '뉴비', NOW(), NOW());

-- 2. 도전과제 레벨 (각 카테고리당 레벨별 목표 수치)
INSERT INTO challenge_level (level, goal_count, challenge_category_id, description, image_path) VALUES
(1, 10, 1, '한식 10가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/korean/1.png'),
(2, 20, 1, '한식 20가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/korean/2.png'),
(3, 30, 1, '한식 30가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/korean/3.png'),
(1, 10, 2, '일식 10가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/japanese/1.png'),
(2, 20, 2, '일식 20가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/japanese/2.png'),
(3, 30, 2, '일식 30가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/japanese/3.png'),
(1, 10, 3, '중식 10가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/chinese/1.png'),
(2, 20, 3, '중식 20가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/chinese/2.png'),
(3, 30, 3, '중식 30가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/chinese/3.png'),
(1, 10, 4, '양식 10가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/western/1.png'),
(2, 20, 4, '양식 20가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/western/2.png'),
(3, 30, 4, '양식 30가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/western/3.png'),
(1, 10, 5, '좋아요 10가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/like/1.png'),
(2, 20, 5, '좋아요 20가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/like/2.png'),
(3, 30, 5, '좋아요 30가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/like/3.png'),
(1, 10, 6, '북마크 10가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/bookmark/1.png'),
(2, 20, 6, '북마크 20가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/bookmark/2.png'),
(3, 30, 6, '북마크 30가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/bookmark/3.png'),
(1, 10, 7, '빕풀 10가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/rice/1.png'),
(2, 20, 7, '빕풀 20가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/rice/2.png'),
(3, 30, 7, '빕풀 30가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/rice/3.png'),
(4, 40, 7, '빕풀 40가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/rice/4.png'),
(5, 50, 7, '빕풀 50가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/rice/5.png'),
(1, 10, 8, '도감 10가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/recipe/1.png'),
(2, 20, 8, '도감 20가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/recipe/2.png'),
(3, 30, 8, '도감 30가지', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/recipe/3.png'),
(0, 0, 9, '회원 가입시', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/basic/basic.png');

-- 3. 칭호 (도전과제별 레벨 달성 시 부여)
INSERT INTO title (name, level, image_path, type, challenge_category_id, created_at, modified_at) VALUES
('한식 초보', 1, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/korean/1.png', '한식', 1, NOW(), NOW()),
('한식 중수', 2, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/korean/2.png', '한식', 1, NOW(), NOW()),
('한식 고수', 3, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/korean/3.png', '한식', 1, NOW(), NOW()),
('일식 초보', 1, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/japanese/1.png', '일식', 2, NOW(), NOW()),
('일식 중수', 2, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/japanese/2.png', '일식', 2, NOW(), NOW()),
('일식 고수', 3, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/japanese/3.png', '일식', 2, NOW(), NOW()),
('중식 초보', 1, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/chinese/1.png', '중식', 3, NOW(), NOW()),
('중식 초보', 2, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/chinese/2.png', '중식', 3, NOW(), NOW()),
('중식 초보', 3, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/chinese/3.png', '중식', 3, NOW(), NOW()),
('양식 초보', 1, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/western/1.png', '양식', 4, NOW(), NOW()),
('양식 중수', 2, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/western/2.png', '양식', 4, NOW(), NOW()),
('양식 고수', 3, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/western/3.png', '양식', 4, NOW(), NOW()),
('좋아요 초보', 1, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/like/1.png', '좋아요', 5, NOW(), NOW()),
('좋아요 중수', 2, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/like/2.png', '좋아요', 5, NOW(), NOW()),
('좋아요 고수', 3, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/like/3.png', '좋아요', 5, NOW(), NOW()),
('북마크 초보', 1, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/bookmark/1.png', '북마크', 6, NOW(), NOW()),
('북마크 중수', 2, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/bookmark/2.png', '북마크', 6, NOW(), NOW()),
('북마크 고수', 3, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/bookmark/3.png', '북마크', 6, NOW(), NOW()),
('도감 초보', 1, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/recipe/1.png', '도감', 8, NOW(), NOW()),
('도감 중수', 2, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/recipe/2.png', '도감', 8, NOW(), NOW()),
('도감 고수', 3, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/recipe/3.png', '도감', 8, NOW(), NOW()),
('밥풀 초보', 1, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/rice/1.png', '밥풀', 7, NOW(), NOW()),
('밥풀 중수', 2, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/rice/2.png', '밥풀', 7, NOW(), NOW()),
('밥풀 고수', 3, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/rice/3.png', '밥풀', 7, NOW(), NOW()),
('밥풀 초고수', 4, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/rice/4.png', '밥풀', 7, NOW(), NOW()),
('밥풀 초초고수', 5, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/rice/5.png', '밥풀', 7, NOW(), NOW()),
('늅늅하고 우는 뉴비', 0, 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/challenge/basic/basic.png', '밥풀', 7, NOW(), NOW());

INSERT INTO member (login_id, email, nick_name, password, phone_number, profile, active_title_id, rice_point, member_status, created_at, modified_at, active_image_id) VALUES
('tjsk2222', 'tjsk2222@gmail.com', '택택', '{bcrypt}$2a$10$n1ZYr9wraXA.1sJ4YRoIH./kfrVUKtgwAwPhyshUXK3xc32.Jvd6.', '010-1111-2222', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/m_default.png', '9', 300, 'MEMBER_ACTIVE',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
( 'user2', 'user1@example.com', '정희', '{bcrypt}$2a$10$n1ZYr9wraXA.1sJ4YRoIH./kfrVUKtgwAwPhyshUXK3xc32.Jvd6.', '052-115-7815', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/m_default.png', 9, 49, 'MEMBER_ACTIVE', '2024-01-01 10:00:00', '2024-01-02 10:00:00', 1),
( 'user3', 'user3@example.com', '현우', '{bcrypt}$2a$10$n1ZYr9wraXA.1sJ4YRoIH./kfrVUKtgwAwPhyshUXK3xc32.Jvd6.', '052-232-0947', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/m_default.png', 9, 53, 'MEMBER_ACTIVE', '2024-01-01 10:00:00', '2024-01-02 10:00:00', 1),
( 'user4', 'user4@example.com', '민재', '{bcrypt}$2a$10$n1ZYr9wraXA.1sJ4YRoIH./kfrVUKtgwAwPhyshUXK3xc32.Jvd6.', '063-515-9179', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/m_default.png', 9, 5, 'MEMBER_ACTIVE', '2024-01-01 10:00:00', '2024-01-02 10:00:00', 1),
( 'user5', 'user5@example.com', '숙자', '{bcrypt}$2a$10$n1ZYr9wraXA.1sJ4YRoIH./kfrVUKtgwAwPhyshUXK3xc32.Jvd6.', '033-399-1615', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/m_default.png', 9, 33, 'MEMBER_ACTIVE', '2024-01-01 10:00:00', '2024-01-02 10:00:00', 1),
( 'user6', 'user6@example.com', '정순', '{bcrypt}$2a$10$n1ZYr9wraXA.1sJ4YRoIH./kfrVUKtgwAwPhyshUXK3xc32.Jvd6.', '061-208-7091', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/w_default.png', 9, 65, 'MEMBER_ACTIVE', '2024-01-01 10:00:00', '2024-01-02 10:00:00', 2),
( 'user7', 'user7@example.com', '영희', '{bcrypt}$2a$10$n1ZYr9wraXA.1sJ4YRoIH./kfrVUKtgwAwPhyshUXK3xc32.Jvd6.', '062-207-6984', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/w_default.png', 9, 62, 'MEMBER_ACTIVE', '2024-01-01 10:00:00', '2024-01-02 10:00:00', 2),
( 'user8', 'user8@example.com', '순자', '{bcrypt}$2a$10$n1ZYr9wraXA.1sJ4YRoIH./kfrVUKtgwAwPhyshUXK3xc32.Jvd6.', '070-6109-3523', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/w_default.png', 9, 51, 'MEMBER_ACTIVE', '2024-01-01 10:00:00', '2024-01-02 10:00:00', 2),
( 'user9', 'user9@example.com', '영수', '{bcrypt}$2a$10$n1ZYr9wraXA.1sJ4YRoIH./kfrVUKtgwAwPhyshUXK3xc32.Jvd6.', '031-754-7063', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/w_default.png', 9, 100, 'MEMBER_ACTIVE', '2024-01-01 10:00:00', '2024-01-02 10:00:00', 2),
( 'user10', 'user10@example.com', '민지', '{bcrypt}$2a$10$n1ZYr9wraXA.1sJ4YRoIH./kfrVUKtgwAwPhyshUXK3xc32.Jvd6.', '051-217-6104', 'https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/w_default.png', 9, 38, 'MEMBER_ACTIVE', '2024-01-01 10:00:00', '2024-01-02 10:00:00',2);

-- 5. 회원별 도전과제 진행 상태
INSERT INTO member_challenge (member_id, challenge_category_id, current_level, current_count, created_at, modified_at) VALUES
(1, 1, 2, 5, NOW(), NOW()),
(1, 2, 1, 3, NOW(), NOW()),
(1, 3, 1, 3, NOW(), NOW()),
(1, 4, 1, 3, NOW(), NOW()),
(1, 5, 1, 3, NOW(), NOW()),
(1, 6, 1, 3, NOW(), NOW()),
(1, 7, 1, 3, NOW(), NOW()),
(1, 8, 1, 3, NOW(), NOW()),
(2, 1, 1, 9, NOW(), NOW());

-- 6. 회원별 칭호 보유 내역
INSERT INTO member_title (member_id, title_id, created_at, modified_at) VALUES
(1, 1, NOW(), NOW()),
(1, 4, NOW(), NOW()),
(2, 1, NOW(), NOW()),
(2, 3, NOW(), NOW()),
(2, 9, NOW(), NOW()),
(4, 1, NOW(), NOW()),
(6, 1, NOW(), NOW()),
(6, 7, NOW(), NOW()),
(6, 10, NOW(), NOW()),
(6, 11, NOW(), NOW()),
(7, 1, NOW(), NOW()),
(7, 2, NOW(), NOW()),
(7, 3, NOW(), NOW());


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

INSERT INTO payment
(amount, rice_amount, refund_reason, payment_status, member_id, payment_key, order_id, requested_at, completed_at, created_at, modified_at)
VALUES
(8653, 15, '사유1', 'COMPLETED', 10, 'payment_key_1', 'order_id_1', '2025-04-18 03:14:15', '2025-04-18 03:14:15', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
(2653, 99, '사유2', 'COMPLETED', 7,  'payment_key_2', 'order_id_2', '2025-04-18 03:14:15', '2025-04-18 03:14:15', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
(4266, 43, '사유3', 'COMPLETED', 6,  'payment_key_3', 'order_id_3', '2025-04-18 03:14:15', '2025-04-18 03:14:15', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
(8704, 82, '사유4', 'COMPLETED', 3,  'payment_key_4', 'order_id_4', '2025-04-18 03:14:15', '2025-04-18 03:14:15', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
(4332, 17, '사유5', 'COMPLETED', 3,  'payment_key_5', 'order_id_5', '2025-04-18 03:14:15', '2025-04-18 03:14:15', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
(3653, 53, '사유6', 'COMPLETED', 9,  'payment_key_6', 'order_id_6', '2025-04-18 03:14:15', '2025-04-18 03:14:15', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
(5107, 25, '사유7', 'COMPLETED', 10, 'payment_key_7', 'order_id_7', '2025-04-18 03:14:15', '2025-04-18 03:14:15', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
(8246, 95, '사유8', 'COMPLETED', 3,  'payment_key_8', 'order_id_8', '2025-04-18 03:14:15', '2025-04-18 03:14:15', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
(1216, 70, '사유9', 'COMPLETED', 7,  'payment_key_9', 'order_id_9', '2025-04-18 03:14:15', '2025-04-18 03:14:15', '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
(9332, 49, '사유10', 'COMPLETED', 6, 'payment_key_10', 'order_id_10', '2025-04-18 03:14:15', '2025-04-18 03:14:15', '2024-01-01 10:00:00', '2024-01-02 10:00:00');

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

-- ProfileImage 더미 데이터
INSERT INTO profile_image (image_path) VALUES
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/m_default.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/w_default.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/1.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/2.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/3.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/4.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/5.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/6.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/7.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/8.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/9.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/10.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/11.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/12.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/13.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/14.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/15.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/16.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/17.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/18.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/19.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/20.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/21.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/22.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/23.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/24.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/25.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/26.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/27.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/28.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/29.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/30.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/31.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/32.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/33.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/34.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/35.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/36.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/37.png'),
('https://aws-cookking-bucket.s3.ap-northeast-2.amazonaws.com/profile/38.png');

-- MemberProfileImage 더미 데이터 (member_id는 이미 존재한다고 가정)
INSERT INTO member_profile_image (member_id, profile_image_id) VALUES (1, 1);
INSERT INTO member_profile_image (member_id, profile_image_id) VALUES (2, 1);
INSERT INTO member_profile_image (member_id, profile_image_id) VALUES (3, 1);
INSERT INTO member_profile_image (member_id, profile_image_id) VALUES (4, 1);
INSERT INTO member_profile_image (member_id, profile_image_id) VALUES (5, 1);
INSERT INTO member_profile_image (member_id, profile_image_id) VALUES (6, 1);
INSERT INTO member_profile_image (member_id, profile_image_id) VALUES (7, 1);
INSERT INTO member_profile_image (member_id, profile_image_id) VALUES (8, 1);
INSERT INTO member_profile_image (member_id, profile_image_id) VALUES (9, 1);
INSERT INTO member_profile_image (member_id, profile_image_id) VALUES (10, 1);
INSERT INTO member_profile_image (member_id, profile_image_id) VALUES (1, 2);
INSERT INTO member_profile_image (member_id, profile_image_id) VALUES (2, 2);
INSERT INTO member_profile_image (member_id, profile_image_id) VALUES (3, 2);
INSERT INTO member_profile_image (member_id, profile_image_id) VALUES (4, 2);
INSERT INTO member_profile_image (member_id, profile_image_id) VALUES (5, 2);
INSERT INTO member_profile_image (member_id, profile_image_id) VALUES (6, 2);
INSERT INTO member_profile_image (member_id, profile_image_id) VALUES (7, 2);
INSERT INTO member_profile_image (member_id, profile_image_id) VALUES (8, 2);
INSERT INTO member_profile_image (member_id, profile_image_id) VALUES (9, 2);
INSERT INTO member_profile_image (member_id, profile_image_id) VALUES (10, 2);

INSERT INTO likes (member_id, recipe_board_id, created_at, modified_at) VALUES
( 1, 1, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 1, 2, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 3, 3, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 4, 4, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 5, 5, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 6, 6, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 1, 7, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 8, 1, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
( 9, 1, '2024-01-01 10:00:00', '2024-01-02 10:00:00'),
(10,1,'2024-01-01 10:00:00','2024-01-02 10:00:00');