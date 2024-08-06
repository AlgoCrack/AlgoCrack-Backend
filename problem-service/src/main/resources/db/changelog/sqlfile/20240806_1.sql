CREATE TABLE IF NOT EXISTS  problem.problem (
    id SERIAL PRIMARY KEY,
    created_user_id numeric NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS problem.test_case (
    id SERIAL PRIMARY KEY,
    problem_id INTEGER NOT NULL,
    test_data TEXT NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (problem_id) REFERENCES problem.problem(id) ON DELETE CASCADE
);

