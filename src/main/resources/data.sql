insert into FIZZ_BUZZ (FIZZ_BUZZ_KEY, counter, replacement, ordinal) values
(1, 3, 'Fizz', 1),
(2, 5, 'Buzz', 2);

insert into Session(SESSION_KEY, SESSION_ID, expiration_Date) values
(1, 'default', DATE'9999-12-31');


insert into SESSION_ENTRY(SESSION_ENTRY_KEY, SESSION_SESSION_KEY, FIZZ_BUZZ_FIZZ_BUZZ_KEY) values
(1, 1, 1),
(2, 1, 2);

insert into SESSION_SESSION_ENTRIES(SESSION_SESSION_KEY, SESSION_ENTRIES_SESSION_ENTRY_KEY) values
(1, 1),
(1, 2);
