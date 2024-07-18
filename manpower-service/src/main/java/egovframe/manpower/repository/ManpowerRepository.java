package egovframe.manpower.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import egovframe.manpower.entity.Manpower;

@Repository
public interface ManpowerRepository extends JpaRepository<Manpower, Long> {
	List<Manpower> findByKoreanName(String koreanName);
	List<Manpower> findByCompany(String company);
	void deleteByKoreanName(String koreanName);
}