CREATE TABLE child_parents (
       child_id BIGINT NOT NULL,
       parent_id BIGINT NOT NULL,
       PRIMARY KEY (child_id, parent_id),
       CONSTRAINT fk_cp_child FOREIGN KEY (child_id) REFERENCES child(id),
       CONSTRAINT fk_cp_parent FOREIGN KEY (parent_id) REFERENCES members(id)
);