package br.com.technosou.gestor.member.adult;

import br.com.technosou.gestor.member.child.ChildSummaryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdultRepository extends JpaRepository<Adult, Long> {

    @Query(value = """
    SELECT 
        c.id AS childId,
        c.first_name AS childFirstName,
        c.last_name AS childLastName,
        c.phone AS childAgeGroup
    FROM gestor_db.adults a
    LEFT JOIN gestor_db.child_parents cp ON cp.parent_id = a.id
    LEFT JOIN gestor_db.children c ON c.id = cp.child_id
    WHERE a.id = :adultId
    """, nativeQuery = true)
    List<ChildSummaryDTO> findChildrenByAdultId(@Param("adultId") Long adultId);
}
