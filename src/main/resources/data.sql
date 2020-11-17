insert into FIZZ_BUZZ (FIZZ_BUZZ_KEY, counter, replacement, ordinal) values
(1, 3, 'Fizz', 1),
(2, 5, 'Buzz', 2);

insert into SESSION(SESSION_KEY, SESSION_ID, EXPIRATION_DATE) values
(1, 'default', DATE'9999-12-31');

insert into SESSION_FIZZ_BUZZES(SESSION_SESSION_KEY, FIZZ_BUZZES_FIZZ_BUZZ_KEY) values
(1, 1),
(1, 2);

