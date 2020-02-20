insert into shopping_item (`name`, `quantity`, `scale`) values ('banana', 3, 'pcs');
insert into shopping_item (`name`, `quantity`, `scale`) values ('chicken', 1, 'kg');
insert into shopping_item (`name`, `quantity`, `scale`) values ('chocolate', 2, 'pcs');

insert into finance_category (`id`, `label`) values (1, 'Groceries');
insert into finance_category (`id`, `label`) values (2, 'Mortgage');
insert into finance_category (`id`, `label`) values (3, 'Utilities');
insert into finance_category (`id`, `label`) values (4, 'Dining out');
insert into finance_category (`id`, `label`) values (5, 'Pay');
insert into finance_category (`id`, `label`) values (6, 'Vouchers');



insert into finance (`category`, `date`, `cost`, `description`) values (3, '2019-01-01', -1000, 'Electricity bill');
insert into finance (`category`, `date`, `cost`, `description`) values (4, '2019-02-10', -1260, 'Annapurna dinner');
insert into finance (`category`, `date`, `cost`, `description`) values (1, '2019-02-14', -500, 'Tesco groceries');
insert into finance (`category`, `date`, `cost`, `description`) values (2, '2019-01-14', -16000, 'Mortgage');
insert into finance (`category`, `date`, `cost`, `description`) values (3, '2020-01-01', -1000, 'Electricity bill');
insert into finance (`category`, `date`, `cost`, `description`) values (4, '2020-02-10', -1260, 'Annapurna dinner');
insert into finance (`category`, `date`, `cost`, `description`) values (1, '2020-02-14', -500, 'Tesco groceries');
insert into finance (`category`, `date`, `cost`, `description`) values (2, '2020-01-14', -16000, 'Mortgage');
insert into finance (`category`, `date`, `cost`, `description`) values (2, '2019-04-14', -16000, 'Mortgage');
insert into finance (`category`, `date`, `cost`, `description`) values (3, '2020-08-01', -1000, 'Pension fund');
insert into finance (`category`, `date`, `cost`, `description`) values (4, '2020-04-10', -1260, 'Mix Grill dinner');
insert into finance (`category`, `date`, `cost`, `description`) values (1, '2020-09-14', -500, 'Lidl groceries');
insert into finance (`category`, `date`, `cost`, `description`) values (2, '2020-08-14', -16000, 'Car Loan');
insert into finance (`category`, `date`, `cost`, `description`) values (5, '2020-01-14', 43000, 'Pay Peter');
insert into finance (`category`, `date`, `cost`, `description`) values (5, '2020-01-10', 24000, 'Pay Dianka');
insert into finance (`category`, `date`, `cost`, `description`) values (6, '2020-01-14', 1300, 'Vouchers Peter');
insert into finance (`category`, `date`, `cost`, `description`) values (6, '2020-01-07', 2000, 'Vouchers Dianka');