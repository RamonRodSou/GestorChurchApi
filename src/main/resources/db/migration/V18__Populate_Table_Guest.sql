
INSERT INTO guest (name, phone, visit_history, is_active) VALUES
          (
              'Ana Silva',
              '21987654321',
              JSON_ARRAY('2025-08-15', '2025-09-01', '2025-10-12'),
              1
          ),
          (
              'Bruno Costa',
              '21912345678',
              JSON_ARRAY('2025-10-19'),
              1
          ),
          (
              'Carla Dias',
              '21912345672',
              JSON_ARRAY('2025-10-01'),
              1
          ),
          (
              'Daniel Oliveira',
              '21999998888',
              JSON_ARRAY('2024-11-20', '2024-12-25'),
              0
          ),
          (
              'Eduarda Lima',
              '21988776655',
              JSON_ARRAY('2025-10-19'),
              1
          );