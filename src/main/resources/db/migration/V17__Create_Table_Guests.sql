CREATE TABLE guest (
       id BIGINT NOT NULL AUTO_INCREMENT,
       name VARCHAR(255) NOT NULL,
       phone VARCHAR(13) NULL,
       visit_history JSON NULL,
       is_active TINYINT(1) NOT NULL DEFAULT 1,
       created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
       PRIMARY KEY (id)
);