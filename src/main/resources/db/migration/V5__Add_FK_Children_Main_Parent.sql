ALTER TABLE children
    ADD COLUMN main_parent_id BIGINT,
    ADD CONSTRAINT fk_child_to_main_parent
        FOREIGN KEY (main_parent_id) REFERENCES adults(id) ON DELETE SET NULL;
