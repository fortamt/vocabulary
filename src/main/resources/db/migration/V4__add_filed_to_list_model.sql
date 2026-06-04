ALTER TABLE lists_of_words
ADD COLUMN word_count INTEGER NOT NULL DEFAULT 0 CHECK ( word_count >= 0 );