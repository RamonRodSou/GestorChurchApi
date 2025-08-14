UPDATE adults a
SET main_child_id = (
    SELECT cp.child_id
    FROM child_parents cp
    WHERE cp.parent_id = a.id
    ORDER BY cp.child_id
    LIMIT 1
    );

UPDATE children c
SET main_parent_id = (
    SELECT cp.parent_id
    FROM child_parents cp
    WHERE cp.child_id = c.id
    ORDER BY cp.parent_id
    LIMIT 1
    );