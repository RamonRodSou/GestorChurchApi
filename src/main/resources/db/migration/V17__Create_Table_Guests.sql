CREATE TABLE guests (
       id BIGINT NOT NULL AUTO_INCREMENT,
       name VARCHAR(255) NOT NULL,
       phone VARCHAR(13) NOT NULL,
       visit_history JSON NOT NULL,
       is_active BOOLEAN DEFAULT TRUE,
       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       PRIMARY KEY (id)
);