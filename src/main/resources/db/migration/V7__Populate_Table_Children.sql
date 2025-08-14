INSERT INTO children
(id, first_name, last_name, birth_date, gender, group_id, child_role, age_group, allergy, phone, main_parent_id)
VALUES
    (1, 'Lucas', 'da Silva', '2018-08-12', 'MALE', 'KIDS1', 'MEMBER', 'CHILD', 'Amendoim', NULL, '1');

INSERT INTO children
(id, first_name, last_name, birth_date, gender, group_id, child_role, age_group, allergy, medication, special_need, phone, main_parent_id)
VALUES
    (2, 'Sofia', 'Pereira', '2021-02-20', 'FEMALE', 'KIDS2', 'VOLUNTEER', 'CHILD', NULL, 'Antialérgico em caso de crise', NULL, NULL, '1');

INSERT INTO children
(id, first_name, last_name, birth_date, gender, group_id, child_role, age_group, phone, church_name, leader_name, baptism_date, main_parent_id)
VALUES
    (3, 'Tiago', 'Gomes', '2010-09-01', 'MALE', 'TEENS1', 'MEMBER', 'TEENAGER', '21999998888', 'Nossa Comunidade', 'Pastor Carlos Souza', '2024-03-15', '2');
