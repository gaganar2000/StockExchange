insert into sector (brief,sector_name) values( 'Health products','Health Care');
insert into sector (brief,sector_name) values( 'Applications','Technology');
insert into sector (brief,sector_name) values( 'Banking','Finance');

insert into ipodetail (open_date_time,price_per_share,remarks,total_number_of_shares) values ('2000-01-10',5000,'best',5);
insert into ipodetail (open_date_time,price_per_share,remarks,total_number_of_shares) values ('2000-01-10',3000,'good',4);
insert into ipodetail (open_date_time,price_per_share,remarks,total_number_of_shares) values ('2000-01-10',6000,'good',4);
insert into ipodetail (open_date_time,price_per_share,remarks,total_number_of_shares) values ('2000-01-10',25000,'best',5);


insert into company(board_of_directors, ceo,company_brief,company_name,turnover,sector_id,ipodetail_id) values ('Meghana, Radha','Rajashekar','Product company','RRMG Groups',600000,1,1);
insert into company(board_of_directors, ceo,company_brief,company_name,turnover,sector_id,ipodetail_id) values ('Preetham Prathiksha','Ravi Kumar','Finance company','CG Groups',300000,1,2);
insert into company(board_of_directors, ceo,company_brief,company_name,turnover,sector_id,ipodetail_id) values ('Taanu, Pari','Satish','Service company','SS Groups',400000,2,3);
insert into company(board_of_directors, ceo,company_brief,company_name,turnover,sector_id,ipodetail_id) values ('Lekhana, Harshi','Keshava','Service company','KA Groups',600000,2,4);


insert into users (admin,confirmed,role,email,mobile,name,password) values (true,true,'admin','gaganar200010@gmail.com','9845040914','Gagana','password');
insert into users (admin,confirmed,role,email,mobile,name,password) values (false,true,'user','meghana@gmail.com','9845040914','Meghana','password');

insert into stock_exchange (name,address,city,country,remarks,brief) values ( 'BSE','G Hosahalli, Magadi road','Bombay','India','Good','Bombay Stock Exchange');
insert into stock_exchange (name,address,city,country,remarks,brief)values ( 'NSE','Tavarekere','Delhi','India','Good','National Stock Exchange');
insert into stock_exchange (name,address,city,country,remarks,brief) values ( 'CSE','Magadi road','Calcutta','India','Good','Calcutta Stock Exchange');

insert into ipodetail_stockexchange (ipodetail_id, stockexchange_id) values ( 1,1);
insert into ipodetail_stockexchange (ipodetail_id, stockexchange_id) values ( 1,2);
insert into ipodetail_stockexchange (ipodetail_id, stockexchange_id) values ( 2,2);
insert into ipodetail_stockexchange (ipodetail_id, stockexchange_id) values ( 2,3);
insert into ipodetail_stockexchange (ipodetail_id, stockexchange_id) values ( 1,3);
insert into ipodetail_stockexchange (ipodetail_id, stockexchange_id) values ( 3,1);
insert into ipodetail_stockexchange (ipodetail_id, stockexchange_id) values ( 3,3);

insert into company_stockexchange(company_id, stockexchange_id) values (1,1);
insert into company_stockexchange( company_id, stockexchange_id) values (1,2);
insert into company_stockexchange( company_id, stockexchange_id) values (2,2);
insert into company_stockexchange( company_id, stockexchange_id) values (3,2);

insert into stock_price (companycode, datee, shareprice, time, company_id, stockexchange_id) values (1,'2020-01-09',5000,'13:15',1,1);
insert into stock_price (companycode, datee, shareprice, time, company_id, stockexchange_id) values (1,'2020-01-17',4000,'18:15',1,2);
insert into stock_price (companycode, datee, shareprice, time, company_id, stockexchange_id) values (2,'2019-12-09',5000,'10:30',2,3);
insert into stock_price (companycode, datee, shareprice, time, company_id, stockexchange_id) values (3,'2020-01-09',5000,'14:45',3,1);