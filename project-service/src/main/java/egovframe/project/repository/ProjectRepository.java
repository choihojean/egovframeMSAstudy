package egovframe.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import egovframe.project.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    
    @Query("SELECT p FROM Project p WHERE "
            + "(:projName IS NULL OR p.projName LIKE %:projName%) AND "
            + "(:startDate IS NULL OR p.startDate >= :startDate) AND "
            + "(:endDate IS NULL OR p.endDate <= :endDate)")
       List<Project> findByProjNameAndDates(@Param("projName") String projName,
                                            @Param("startDate") String startDate,
                                            @Param("endDate") String endDate);
}

//@Query를 사용하여 Project entity에서 조건에 맞는 프로젝트 검색
//List<Project>... 로 조건에 맞는 프로젝트 리스트 반환
//Param을 통해 쿼리에서 사용되는 파라미터를 메소드 인자로 매핑