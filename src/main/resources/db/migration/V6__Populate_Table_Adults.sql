INSERT INTO adults (
    first_name, last_name, birth_date, gender, cpf, email, phone,
    zip_code, street, house_number, city, state, neighborhood, civil_status,
    role, is_active, is_image_authorized, church_name, leader_name,
    baptism_date
) VALUES (
             'John', 'Doe', '1985-03-10', 'MALE', '12345678901', 'john@example.com', '5511999999999',
             '12345-678', 'Main Street', '100', 'Springfield', 'SP', 'Downtown', 'MARRIED',
             'LEADER', TRUE, TRUE, 'First Baptist Church', 'Pastor John Doe', '2010-05-15'
         );

INSERT INTO adults (
    first_name, last_name, birth_date, gender, cpf, email, phone,
    zip_code, street, house_number, city, state, neighborhood, civil_status, spouse_id,
    role, is_active, is_image_authorized, church_name, leader_name, baptism_date
) VALUES (
             'Jane', 'Smith', '1990-07-21', 'FEMALE', '98765432100', 'jane@example.com', '5511888888888',
             '87654-321', 'Oak Avenue', '200', 'Riverside', 'RJ', 'Westside', 'MARRIED', 1,
             'MEMBER', TRUE, TRUE, 'Community Church', 'Rev. Michael Smith', '2012-09-10'
         );

UPDATE adults SET spouse_id = 2 WHERE id = 1;

INSERT INTO adults (
    first_name, last_name, birth_date, gender, cpf, email, phone,
    zip_code, street, house_number, city, state, neighborhood, civil_status,
    role, is_active, is_image_authorized
) VALUES (
             'Maria', 'Oliveira', '1995-01-15', 'FEMALE', '55544433322', 'maria@example.com', '5511777777777',
             '54321-000', 'Pine Street', '300', 'Lakeside', 'MG', 'Central', 'SINGLE',
             'MEMBER', TRUE, TRUE
         );
