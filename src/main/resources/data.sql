
-- users テーブルにデータを挿入するクエリ
INSERT INTO users (email, name, password)
VALUES
('tanaka@aaa.com', '田中太郎', 'test123'),
('suzuki@aaa.com', '鈴木一郎', 'test456'),
('yamad425@gmail.com', '山田麻衣', '0101-IIKO');

-- tasks テーブルにデータを挿入するクエリ
INSERT INTO tasks (category_id, user_id, title, closing_date, progress, memo)
VALUES
(1, 1, '見積もり', '2025-12-31', 1, '案件に適した見積もりを取る'),
(2, 1, 'ゲームの作り方', '2025-11-30', 2, 'ゲームの作成手順'),
(3, 1, 'コーヒー豆の煎り方', '2025-11-30', 3, 'ゲームの作成手順'),
(1, 2, '見積もり', '2025-12-31', 1, '案件に適した見積もりを取る'),
(2, 2, 'ゲームの作り方', '2025-11-30', 2, 'ゲームの作成手順'),
(3, 2, 'コーヒー豆の煎り方', '2025-11-30', 3, 'ゲームの作成手順');

INSERT INTO categories(name) VALUES('仕事');
INSERT INTO categories(name) VALUES('個人');
INSERT INTO categories(name) VALUES('その他');