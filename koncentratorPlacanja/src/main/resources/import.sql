INSERT INTO klijent (ime_kompanije, email, password, success_url, error_url, failed_url, paypal_secret, bitcoin_secret, bank_id, bank_pass, paypal_enabled, bitcoin_enabled, bank_enabled) VALUES ('Naucne Centrala Marko', 'email@email', 'password', 'success.com', 'error.com', 'failed.com', 'Af6RrdeRgT1nP1NLcztzn0RoivQnFIBDii_C23gtxljFUuugYofl5Y0asUu8mtS6JA9Xg2_G0XncrJw9', 'BitcoinSecret', 'YdE5dCGu5Lcet3l3caXO', 'KXCxp5VBudhSEaoxprZ5', true, true ,true);

INSERT INTO transakcija (kolicina, klijent_id, prodavac_vreme_transakcije, token, bank_racun_prodavac) VALUES (12.4, 1, '2018-04-21 10:42:58', 'JU3NkyKQsKNgDcBcfPXB', '2111111212121');

INSERT INTO bank (id, kod_banke, naziv_banke, url_banke) VALUES (1, '11111', 'Banka A', 'http://localhost:8182');
INSERT INTO bank (id, kod_banke, naziv_banke, url_banke) VALUES (2, '22222', 'Banka B', 'http://localhost:8184');