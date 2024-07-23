package egovframe.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import egovframe.project.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    
    @Query("SELECT p FROM Project p WHERE "
            + "(:projName IS NULL OR p.projName = :projName) AND "
            + "(:startDate IS NULL OR p.startDate >= :startDate) AND "
            + "(:endDate IS NULL OR p.endDate <= :endDate)")
       List<Project> findByProjNameAndDates(@Param("projName") String projName,
                                            @Param("startDate") String startDate,
                                            @Param("endDate") String endDate);
}
