CREATE TYPE status_analisys AS ENUM('open', 'closed', 'waiting');
CREATE TABLE analisys(
    id SERIAL PRIMARY KEY,
    crowdfunding_id INTEGER NOT NULL,
    users_id INTEGER NOT NULL,
    refuse_motive VARCHAR(255),
    status status_analisys,
    FOREIGN KEY (users_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (crowdfunding_id) REFERENCES crowdfunding(id) ON DELETE CASCADE
)