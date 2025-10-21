CREATE TABLE group_children (
    group_id BIGINT NOT NULL,
    child_id BIGINT NOT NULL,
    PRIMARY KEY (group_id, child_id),
    CONSTRAINT fk_member_child_group FOREIGN KEY (group_id) REFERENCES cell_groups(id),
    CONSTRAINT fk_child_id FOREIGN KEY (child_id) REFERENCES children(id)
);
