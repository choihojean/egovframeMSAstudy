package egovframe.manpower.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import egovframe.manpower.entity.Manpower;

@Repository
public interface ManpowerRepository extends JpaRepository<Manpower, Long> {
	List<Manpower> findByKoreanName(String koreanName);
	List<Manpower> findByCompany(String company);
	List<Manpower> findByKoreanNameAndCompany(String koreanName, String company);
	
	@Modifying
    @Transactional
    @Query("DELETE FROM Manpower m WHERE m.id IN :ids")
    void deleteAllById(@Param("ids") List<Long> ids);
}