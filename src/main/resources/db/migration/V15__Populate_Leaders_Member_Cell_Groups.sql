INSERT INTO group_leaders (group_id, adult_leader_id) VALUES
          ((SELECT id FROM cell_groups WHERE name = 'Grupo Esperança'), 1),
          ((SELECT id FROM cell_groups WHERE name = 'Grupo Esperança'), 2);

INSERT INTO group_members (group_id, adult_member_id) VALUES
    ((SELECT id FROM cell_groups WHERE name = 'Grupo Esperança'), 3);

INSERT INTO group_children (group_id, child_id) VALUES
    ((SELECT id FROM cell_groups WHERE name = 'Grupo Esperança'), 1);