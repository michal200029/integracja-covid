INSERT INTO branch (id, name, api_key) VALUES (1, 'Waluty', 'e7030b0681415d2697a7f7b751476df0');
INSERT INTO branch (id, name, api_key) VALUES (2, 'Kryptowaluty', null);
INSERT INTO branch (id, name, api_key) VALUES (3, 'USA', null);

INSERT INTO sub_branch (id, name, branch_id) VALUES (1, 'USD', 1);
INSERT INTO sub_branch (id, name, branch_id) VALUES (2, 'EUR', 1);
INSERT INTO sub_branch (id, name, branch_id) VALUES (3, 'GBP', 2);

INSERT INTO sub_branch (id, name, branch_id) VALUES (4, 'BTC', 2);
INSERT INTO sub_branch (id, name, branch_id) VALUES (5, 'ETH', 2);
INSERT INTO sub_branch (id, name, branch_id) VALUES (6, 'SOL', 2);

INSERT INTO sub_branch (id, name, branch_id) VALUES (7, 'Przemysl - ilosc zatrudnionych', 3);
INSERT INTO sub_branch (id, name, branch_id) VALUES (8, 'Trnasport', 3);
INSERT INTO sub_branch (id, name, branch_id) VALUES (9, 'TBD', 3);
