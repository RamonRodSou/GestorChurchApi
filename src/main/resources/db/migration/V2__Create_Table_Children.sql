CREATE TABLE children (
      id BIGINT AUTO_INCREMENT PRIMARY KEY,
      first_name VARCHAR(100) NOT NULL,
      last_name VARCHAR(100) NOT NULL,
      birth_date DATE,
      gender VARCHAR(6),
      email VARCHAR(255),
      is_active BOOLEAN DEFAULT TRUE,
      is_image_authorized BOOLEAN DEFAULT TRUE,
      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
      phone VARCHAR(13),
      child_role ENUM('EMPTY','MEMBER','VOLUNTEER') NOT NULL,
      age_group ENUM('CHILD','TEENAGER','YOUTH') NOT NULL,
      medication VARCHAR(300),
      special_need VARCHAR(300),
      allergy VARCHAR(300),
      church_name VARCHAR(255),
      leader_name VARCHAR(255),
      baptism_date DATE

);