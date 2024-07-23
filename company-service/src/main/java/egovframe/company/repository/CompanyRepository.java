package egovframe.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import egovframe.company.entity.Company;
import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    // 소속사명으로 부분 일치 검색
    List<Company> findByCompanyNameContaining(String companyName);

    // 소속사 ID로 부분 일치 검색
    List<Company> findByCompanyIdContaining(String companyId);

    // 소속사명 또는 소속사 ID로 부분 일치 검색
    List<Company> findByCompanyNameContainingOrCompanyIdContaining(String companyName, String companyId);

}