package egovframe.manpower.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import egovframe.manpower.entity.Manpower;

@Repository
public interface ManpowerRepository extends JpaRepository<Manpower, Long> {
}