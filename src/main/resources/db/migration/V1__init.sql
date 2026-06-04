CREATE TABLE users (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    telegram_id BIGINT NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100),
    username VARCHAR(100),
    avatar_url VARCHAR(255) NOT NULL,
    day_streak INT NOT NULL DEFAULT 0,
    daily_goal INT NOT NULL DEFAULT 5 CHECK ( daily_goal BETWEEN 5 AND 100),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE words (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    ru VARCHAR(100) NOT NULL,
    en VARCHAR(100) NOT NULL,
    en_transcription VARCHAR(100) NOT NULL
);

CREATE TABLE users_words (
    user_id BIGINT NOT NULL,
    word_id BIGINT NOT NULL,
    repetition_count INT NOT NULL DEFAULT 0,
    easy_factor NUMERIC(2,3) NOT NULL DEFAULT 2.5 CHECK ( easy_factor >= 1.3 ),
    interval_days INT NOT NULL DEFAULT 0 CHECK ( interval_days >= 0 ),
    next_review_date DATE NOT NULL DEFAULT CURRENT_DATE
)