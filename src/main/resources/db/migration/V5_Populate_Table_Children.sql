-- Maria é filha do John Doe (id 1)
INSERT INTO children (
    first_name, last_name, birth_date, gender, is_active, is_image_authorized, adult_id
) VALUES (
             'Maria', 'Doe', '2015-06-20', 'Female', TRUE, TRUE, 1
         );

-- Pedro é filho da Jane Smith (id 2)
INSERT INTO children (
    first_name, last_name, birth_date, gender, is_active, is_image_authorized, adult_id
) VALUES (
             'Pedro', 'Smith', '2018-09-05', 'Male', TRUE, TRUE, 2
         );

-- Lucas é filho da Maria Oliveira (id 3)
INSERT INTO children (
    first_name, last_name, birth_date, gender, is_active, is_image_authorized, adult_id
) VALUES (
             'Lucas', 'Oliveira', '2020-02-10', 'Male', TRUE, TRUE, 3
         );
