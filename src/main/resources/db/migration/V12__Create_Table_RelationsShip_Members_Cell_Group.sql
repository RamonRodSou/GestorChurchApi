CREATE TABLE group_members (
        group_id BIGINT NOT NULL,
        adult_member_id BIGINT NOT NULL,
        PRIMARY KEY (group_id, adult_member_id),
        CONSTRAINT fk_member_group_id FOREIGN KEY (group_id) REFERENCES cell_groups(id),
        CONSTRAINT fk_member_adult_id FOREIGN KEY (adult_member_id) REFERENCES adults(id)
);