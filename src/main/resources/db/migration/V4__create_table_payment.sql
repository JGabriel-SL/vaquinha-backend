--CREATE TYPE type_payment AS ENUM('card', 'pix');

CREATE TABLE IF NOT EXISTS payment(
id SERIAL PRIMARY KEY,
amount INTEGER NOT NULL,
type VARCHAR(255) NOT NULL,
crowdfunding_id INTEGER NOT NULL,
url_payment TEXT NOT NULL,
id_payment TEXT NOT NULL,
FOREIGN KEY (crowdfunding_id) REFERENCES crowdfunding(id) ON DELETE CASCADE
)   