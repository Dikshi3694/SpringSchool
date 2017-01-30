
use schooltest;

set FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE students;
TRUNCATE TABLE klasses;
TRUNCATE TABLE teachers;
set FOREIGN_KEY_CHECKS = 1;

INSERT INTO students (email) VALUES("sameer@gmail.com");
INSERT INTO students (email) VALUES("dikshita@gmail.com");
INSERT INTO klasses (name, semester, credits, department, fee) VALUES ("sameer", '2016-06-06', 1, 'SCIENCE', 2000);
INSERT INTO teachers (name, age, email,klass_id, gender) VALUES ("sameer", 23, "s@a.com",1, 'MALE');

























































































