CREATE TABLE IF NOT EXISTS crowdfunding(
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    users_id INTEGER NOT NULL,
    current_amount INTEGER NOT NULL,
    goal_amount NUMERIC NOT NULL,
    status VARCHAR(50) NOT NULL,
    FOREIGN KEY (users_id) REFERENCES users(id) ON DELETE CASCADE
)