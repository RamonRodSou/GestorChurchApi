CREATE TABLE cell_groups (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    week_day ENUM('SUNDAY','MONDAY','TUESDAY','WEDNESDAY','THURSDAY','FRIDAY','SATURDAY') NOT NULL,
    zip_code VARCHAR(9) NOT NULL,
    street VARCHAR(255) NOT NULL,
    house_number VARCHAR(20) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(2) NOT NULL,
    neighborhood VARCHAR(100),
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE adults
    ADD COLUMN group_id BIGINT,
ADD CONSTRAINT fk_adult_group
    FOREIGN KEY (group_id) REFERENCES cell_groups(id);

ALTER TABLE children
    ADD COLUMN group_id BIGINT,
ADD CONSTRAINT fk_child_group
    FOREIGN KEY (group_id) REFERENCES cell_groups(id);

