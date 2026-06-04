ALTER TABLE users_words ADD PRIMARY KEY (user_id, word_id);
ALTER TABLE users_words ADD FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE;
ALTER TABLE users_words ADD FOREIGN KEY (word_id) REFERENCES words(id) ON DELETE CASCADE;