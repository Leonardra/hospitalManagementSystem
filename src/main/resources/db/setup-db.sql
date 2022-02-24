create database hospitalDb;
create user 'hospital_user'@'localhost' identified by 'hospitalPassword123';
grant all privileges on hospitalDb.* to 'hospital_user'@'localhost';

flush privileges;