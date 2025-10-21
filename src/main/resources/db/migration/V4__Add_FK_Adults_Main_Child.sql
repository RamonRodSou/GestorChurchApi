ALTER TABLE adults
    ADD COLUMN main_child_id BIGINT,
    ADD CONSTRAINT fk_adult_to_main_child
        FOREIGN KEY (main_child_id) REFERENCES children(id) ON DELETE SET NULL;