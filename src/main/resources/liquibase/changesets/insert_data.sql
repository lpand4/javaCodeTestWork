insert into wallets(id, amount)
values ('d81dcc75-1401-4291-b272-db0508e3a2d5', 2300),
       ('adf46056-d419-4d95-a811-08ddd59114c6', 1100)
ON CONFLICT DO NOTHING;