CREATE TABLE child_parents (
       child_id BIGINT NOT NULL,
       parent_id BIGINT NOT NULL,
       PRIMARY KEY (child_id, parent_id),
       CONSTRAINT fk_childparents_to_child FOREIGN KEY (child_id) REFERENCES children(id) ON DELETE CASCADE,
       CONSTRAINT fk_childparents_to_adult FOREIGN KEY (parent_id) REFERENCES adults(id) ON DELETE CASCADE
);