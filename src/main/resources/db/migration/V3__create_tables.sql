CREATE TABLE lists_of_words (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    icon VARCHAR(100) NOT NULL,
    background VARCHAR(100) NOT NULL
);

CREATE TABLE words_lists (
    word_id BIGINT NOT NULL REFERENCES words(id) ON DELETE CASCADE,
    list_id BIGINT NOT NULL REFERENCES lists_of_words(id) ON DELETE CASCADE,
    PRIMARY KEY (word_id, list_id)
);