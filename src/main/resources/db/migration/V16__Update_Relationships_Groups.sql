UPDATE adults a
SET group_id = (
    SELECT g.group_id
    FROM (
             SELECT adult_leader_id AS adult_id, group_id FROM group_leaders
             UNION
             SELECT adult_member_id AS adult_id, group_id FROM group_members
         ) g
    WHERE g.adult_id = a.id
    LIMIT 1
    );

UPDATE children c
SET group_id = (
    SELECT gc.group_id
    FROM group_children gc
    WHERE gc.child_id = c.id
    LIMIT 1
    );