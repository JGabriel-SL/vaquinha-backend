CREATE TYPE type_payment AS ENUM('card', 'pix');
CREATE TABLE payment(
id SERIAL PRIMARY KEY,
amount INTEGER NOT NULL,
type type_payment,
crowdfunding_id INTEGER NOT NULL,
url_payment TEXT NOT NULL,
id_payment TEXT NOT NULL,
FOREIGN KEY (crowdfunding_id) REFERENCES crowdfunding(id) ON DELETE CASCADE
)