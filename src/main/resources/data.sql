--accounts
insert into account (account_number, account_name, account_type, balance_date, currency, opening_available_balance)
values('585309209','SGSavings726', 'Savings', to_date('08/11/2018','MM-dd-yyyy'), 'SGD', 84327.51);

insert into account (account_number, account_name, account_type, balance_date, currency, opening_available_balance)
values('791066619','AUSavings933', 'Savings', to_date('08/11/2018','MM-dd-yyyy'), 'AUD', 88005.93);

insert into account (account_number, account_name, account_type, balance_date, currency, opening_available_balance)
values('321143048','AUCurrent433', 'Current', to_date('08/11/2018','MM-dd-yyyy'), 'AUD', 38010.62);


--account transactions
insert into transaction (account_number, value_date, debit_amount, credit_amount, debit_credit, transaction_narrative)
values('585309209', to_date('01/12/2012','MM-dd-yyyy'), null, 9540.98, 'Credit', null);

insert into transaction (account_number, value_date, debit_amount, credit_amount, debit_credit, transaction_narrative)
values('585309209', to_date('01/12/2012','MM-dd-yyyy'), null, 7497.82, 'Credit', null);

insert into transaction (account_number, value_date, debit_amount, credit_amount, debit_credit, transaction_narrative)
values('585309209', to_date('01/12/2012','MM-dd-yyyy'), null, 5564.79, 'Credit', null);

