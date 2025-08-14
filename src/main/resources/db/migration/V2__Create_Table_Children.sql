CREATE TABLE children (
      id BIGINT AUTO_INCREMENT PRIMARY KEY,
      first_name VARCHAR(100) NOT NULL,
      last_name VARCHAR(100) NOT NULL,
      birth_date DATE,
      gender VARCHAR(6),
      is_active BOOLEAN DEFAULT TRUE,
      is_image_authorized BOOLEAN DEFAULT TRUE,
      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

      phone VARCHAR(13),
      group_id VARCHAR(255),
      role VARCHAR(255),
      age_group VARCHAR(255),
      medication VARCHAR(300),
      special_need VARCHAR(300),
      allergy VARCHAR(300),

      church_name VARCHAR(255),
      our_church BOOLEAN,
      leader_name VARCHAR(255),
      baptism_date DATE
);