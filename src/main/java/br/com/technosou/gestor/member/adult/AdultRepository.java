package br.com.technosou.gestor.member.adult;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AdultRepository extends JpaRepository<Adult, Long> {

    @Query("SELECT a FROM Adult a LEFT JOIN FETCH a.children")
    List<Adult> findAllWithChildren();

}
