CREATE TABLE group_leaders (
       group_id BIGINT NOT NULL,
       adult_leader_id BIGINT NOT NULL,
       PRIMARY KEY (group_id, adult_leader_id),
       CONSTRAINT fk_leader_group_id FOREIGN KEY (group_id) REFERENCES cell_groups(id),
       CONSTRAINT fk_leader_adult_id FOREIGN KEY (adult_leader_id) REFERENCES adults(id)
);
