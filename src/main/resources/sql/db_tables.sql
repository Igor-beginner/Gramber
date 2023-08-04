DROP TABLE IF EXISTS chat_members CASCADE;
DROP TABLE IF EXISTS message CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS request_on_friend CASCADE;
DROP TABLE IF EXISTS resource CASCADE;
DROP TABLE IF EXISTS activity CASCADE;
DROP TABLE IF EXISTS chat CASCADE;
DROP TABLE IF EXISTS role CASCADE;
DROP TABLE IF EXISTS dialog CASCADE;
DROP TABLE IF EXISTS post CASCADE;
DROP TABLE IF EXISTS comments CASCADE;

CREATE TABLE users ( 
  id SERIAL, 
  name VARCHAR(30), 
  surname VARCHAR(30), 
  age INTEGER, 
  phone_number VARCHAR(50), 
  password VARCHAR(100), 
  photo_link VARCHAR(100), 
  bio VARCHAR(255), 
  PRIMARY KEY (id) 
); 
 
CREATE TABLE post ( 
  id SERIAL, 
  topic VARCHAR(30), 
  description VARCHAR(500), 
  message_id INTEGER, 
  owner_id INTEGER, 
  PRIMARY KEY (id)
); 
 
 CREATE TABLE message ( 
  id SERIAL, 
  resource_id INTEGER, 
  text VARCHAR(512), 
  sent_date TIMESTAMP, 
  owner_id INTEGER, 
  PRIMARY KEY (id)
); 

CREATE TABLE chat ( 
  id SERIAL, 
  owner_id  INTEGER, 
  photo_link VARCHAR(100),
  PRIMARY KEY (id)
); 

CREATE TABLE chat_members ( 
  chat_id INTEGER, 
  user_id INTEGER, 
  role VARCHAR(30)
); 
 
CREATE TABLE resource ( 
  id SERIAL, 
  link VARCHAR(100), 
  content_type VARCHAR(30), 
  PRIMARY KEY (id)
); 
 
CREATE TABLE request_on_friend ( 
  id SERIAL, 
  from_id INTEGER, 
  to_id INTEGER, 
  is_accept BOOLEAN, 
  PRIMARY KEY (id)
); 
 
CREATE TABLE activity ( 
  post_id INTEGER, 
  user_id INTEGER, 
  activity_type VARCHAR(30) 
); 

CREATE TABLE comments(
  message_id INTEGER,
  post_id INTEGER
);

CREATE TABLE dialog(
  message_id INTEGER,
  chat_id INTEGER
);