package egovframe.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import egovframe.company.entity.Company;
import egovframe.company.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    // 새로운 회사 레코드 생성
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    // ID로 회사 레코드 조회
    public Optional<Company> getCompany(Long id) {
        return companyRepository.findById(id);
    }

    // 소속사명으로 회사 레코드 조회
    public List<Company> getCompanyByCompanyName(String companyName) {
        return companyRepository.findByCompanyNameContaining(companyName);
    }

    // 소속사 ID로 회사 레코드 조회
    public List<Company> getCompanyByCompanyId(String companyId) {
        return companyRepository.findByCompanyIdContaining(companyId);
    }

    // 소속사명 또는 소속사 ID로 회사 레코드 조회
    public List<Company> getCompanyByNameOrId(String companyName, String companyId) {
        return companyRepository.findByCompanyNameContainingOrCompanyIdContaining(companyName, companyId);
    }

    // 모든 회사 레코드 조회
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    // 기존 회사 레코드 업데이트
    public Company updateCompany(Long id, Company companyDetails) {
        // 회사 ID로 기존의 회사 엔티티를 찾습니다.
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("회사를 찾을 수 없습니다"));

        // companyDetails 객체로부터 값을 가져와서 기존 엔티티의 필드를 업데이트합니다.
        company.setCompanyName(companyDetails.getCompanyName()); // 소속사명
        company.setRelation(companyDetails.getRelation()); // 관계
        company.setAddress(companyDetails.getAddress()); // 주소
        company.setBusinessNumber(companyDetails.getBusinessNumber()); // 사업자번호
        company.setRepresentative(companyDetails.getRepresentative()); // 대표자
        company.setPhoneNumber(companyDetails.getPhoneNumber()); // 전화번호
        company.setActive(companyDetails.isActive()); //사용여부

        // 업데이트된 엔티티를 저장합니다.
        return companyRepository.save(company);
    }


    // 회사 ID로 회사 레코드 삭제
    public void deleteCompany(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("회사를 찾을 수 없습니다"));
        companyRepository.delete(company);
    }

    // 회사명으로 회사 레코드 삭제
    public void deleteCompanyByCompanyName(String companyName) {
        List<Company> companyList = companyRepository.findByCompanyNameContaining(companyName);
        companyRepository.deleteAll(companyList);
    }
}
