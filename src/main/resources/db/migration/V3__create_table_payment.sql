CREATE TABLE payment(
id SERIAL PRIMARY KEY,
amount INTEGER NOT NULL,
type TEXT NOT NULL,
crowdfunding_id INTEGER NOT NULL,
url_payment TEXT NOT NULL,
id_payment TEXT NOT NULL,
FOREIGN KEY (crowdfunding_id) REFERENCES crowdfunding(id) ON DELETE CASCADE
)