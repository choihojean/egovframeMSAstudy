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
        company.generateCompanyId(); // companyId 생성
        return companyRepository.save(company);
    }

    // ID로 회사 레코드 조회
    public Optional<Company> getCompany(String id) {
        return companyRepository.findById(Long.valueOf(id));
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
    public Company updateCompany(String id, Company companyDetails) {
        Company company = companyRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new RuntimeException("회사를 찾을 수 없습니다"));

        company.setCompanyName(companyDetails.getCompanyName());
        company.setRelation(companyDetails.getRelation());
        company.setAddress(companyDetails.getAddress());
        company.setBusinessNumber(companyDetails.getBusinessNumber());
        company.setRepresentative(companyDetails.getRepresentative());
        company.setPhoneNumber(companyDetails.getPhoneNumber());
        company.setActive(companyDetails.isActive());

        return companyRepository.save(company);
    }

    // 회사 ID로 회사 레코드 삭제
    public void deleteCompany(String id) {
        Company company = companyRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new RuntimeException("회사를 찾을 수 없습니다"));
        companyRepository.delete(company);
    }

    // 회사명으로 회사 레코드 삭제
    public void deleteCompanyByCompanyName(String companyName) {
        List<Company> companyList = companyRepository.findByCompanyNameContaining(companyName);
        companyRepository.deleteAll(companyList);
    }
}
