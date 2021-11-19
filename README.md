# pinotnoir

insert into wine (name, vintage, drink_between_begin, drink_between_end, region, vivino, ranking_world, ranking_region,
                  pairing, image,count) values
('퀘르체토 치날레', 2015, 2020, 2025, '이탈리아', 4.3, 1, 1, 'beef, lamb, veal, poultry, and cured meat', '/test.png',0),
('파머스 립 페서웨이 쉬라즈', 2016, 2022, 2025, '호주', 3.7, 10, 9, 'beef, lamb, game(deer, venison), and Poultry',
'/test.png',1),
('풋볼트 쉬라즈', 2018, 2022, 2025, '호주', 3.6, 12, 15, 'beef, lamb, game(deer, venison), and Poultry', '/test.png',0);

insert into BUY (BUY_DATE, BUY_PLACE, BUY_PRICE, REGISTRATION_DATE, UPDATE_DATE, WINE_ID) values
('2021-05-05', '이마트', 25000,now(),now(), 1);
