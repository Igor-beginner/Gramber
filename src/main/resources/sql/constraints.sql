ALTER TABLE activity ADD CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id);
ALTER TABLE activity ADD CONSTRAINT fk_post FOREIGN KEY (post_id) REFERENCES post(id);

ALTER TABLE chat_members ADD CONSTRAINT fk_chat FOREIGN KEY (chat_id) REFERENCES chat(id);
ALTER TABLE chat_members ADD CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE chat ADD CONSTRAINT fk_owner FOREIGN KEY (owner_id) REFERENCES users(id);

ALTER TABLE post ADD CONSTRAINT fk_message FOREIGN KEY (message_id) REFERENCES message(id);
ALTER TABLE post ADD CONSTRAINT fk_owner FOREIGN KEY (owner_id) REFERENCES users(id);

ALTER TABLE message ADD CONSTRAINT fk_owner FOREIGN KEY (owner_id) REFERENCES users(id);
ALTER TABLE message ADD CONSTRAINT fk_resource FOREIGN KEY (resource_id) REFERENCES resource(id);

ALTER TABLE request_on_friend ADD CONSTRAINT fk_from_id FOREIGN KEY (from_id) REFERENCES users(id);
ALTER TABLE request_on_friend ADD CONSTRAINT fk_to_id FOREIGN KEY (to_id) REFERENCES users(id);

ALTER TABLE dialog ADD CONSTRAINT fk_chat FOREIGN KEY (chat_id) REFERENCES chat(id);
ALTER TABLE dialog ADD CONSTRAINT fk_message FOREIGN KEY (message_id) REFERENCES message(id);

ALTER TABLE comments ADD CONSTRAINT fk_post FOREIGN KEY (post_id) REFERENCES post(id);
ALTER TABLE comments ADD CONSTRAINT fk_message FOREIGN KEY (message_id) REFERENCES message(id);