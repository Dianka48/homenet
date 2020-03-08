insert into shopping_item (`name`, `quantity`, `scale`) values ('banana', 3, 'pcs');
insert into shopping_item (`name`, `quantity`, `scale`) values ('chicken', 1, 'kg');
insert into shopping_item (`name`, `quantity`, `scale`) values ('chocolate', 2, 'pcs');

insert into finance_category (`id`, `label`) values (1, 'Groceries');
insert into finance_category (`id`, `label`) values (2, 'Mortgage');
insert into finance_category (`id`, `label`) values (3, 'Utilities');
insert into finance_category (`id`, `label`) values (4, 'Dining out');
insert into finance_category (`id`, `label`) values (5, 'Pay');
insert into finance_category (`id`, `label`) values (6, 'Vouchers');

insert into recipe_category (`id`, `label`) values (1, 'Chicken');
insert into recipe_category (`id`, `label`) values (2, 'Pork');
insert into recipe_category (`id`, `label`) values (3, 'Beef');
insert into recipe_category (`id`, `label`) values (4, 'Other meat dishes');
insert into recipe_category (`id`, `label`) values (5, 'Vegetables');
insert into recipe_category (`id`, `label`) values (6, 'Soups');
insert into recipe_category (`id`, `label`) values (7, 'Side dishes');
insert into recipe_category (`id`, `label`) values (8, 'Desserts');
insert into recipe_category (`id`, `label`) values (9, 'Savoury');


insert into recipe (`name`, `category`, `ingredients`, `instructions`) values ('Bread', 9, 'salt, pepper, flour', 'Mix all the ingredients and add to the bowl and bake');
insert into recipe (`name`, `category`, `ingredients`, `instructions`) values ('Chicken Tika Masala', 1, 'chicken, tomatoes, ginger, salt, pepper', 'Mix all the ingredients and cook the chicken');
insert into recipe (`name`, `category`, `ingredients`, `instructions`) values ('Muffins', 8, 'sugar, milk, chocolate', 'Mix all the ingredients and bake. Add sugar on top of the muffins');
insert into recipe (`name`, `category`, `ingredients`, `instructions`) values ('Chicken broth', 6, 'salt, pepper, chicken, parsley, carrots, onions', 'Cut all the vegetables. Boil chicken and vegetables for 2 hours');
insert into recipe (`name`, `category`, `ingredients`, `instructions`) values ('Strawberry Cake', 8, 'sugar, strawberries, mascarpone, butter', 'Mix all the ingredients and bake a cake batter. Decorate with strawberries and mascarpone.');
insert into recipe (`name`, `category`, `ingredients`, `instructions`) values ('Pancakes', 8, 'sugar, strawberries, mascarpone, butter', 'Mix all the ingredients and bake a cake batter. Decorate with strawberries and mascarpone.');
insert into recipe (`name`, `category`, `ingredients`, `instructions`) values ('Deep Fried Oreo', 8, 'sugar, strawberries, mascarpone, butter', 'Mix all the ingredients and bake a cake batter. Decorate with strawberries and mascarpone.');
insert into recipe (`name`, `category`, `ingredients`, `instructions`) values ('Waffles', 8, 'sugar, strawberries, mascarpone, butter', 'Mix all the ingredients and bake a cake batter. Decorate with strawberries and mascarpone.');
insert into recipe (`name`, `category`, `ingredients`, `instructions`) values ('Crepes', 8, 'sugar, strawberries, mascarpone, butter', 'Mix all the ingredients and bake a cake batter. Decorate with strawberries and mascarpone.');
insert into recipe (`name`, `category`, `ingredients`, `instructions`) values ('Hot Chocolate', 8, 'sugar, strawberries, mascarpone, butter', 'Mix all the ingredients and bake a cake batter. Decorate with strawberries and mascarpone.');
insert into recipe (`name`, `category`, `ingredients`, `instructions`) values ('Blueberry Pancakes', 8, 'sugar, strawberries, mascarpone, butter', 'Mix all the ingredients and bake a cake batter. Decorate with strawberries and mascarpone.');
insert into recipe (`name`, `category`, `ingredients`, `instructions`) values ('Ice cream', 8, 'sugar, strawberries, mascarpone, butter', 'Mix all the ingredients and bake a cake batter. Decorate with strawberries and mascarpone.');



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