package egovframe.company.controller;

import egovframe.company.entity.Company;
import egovframe.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    // 새 소속사 생성
    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        Company createdCompany = companyService.createCompany(company);
        return ResponseEntity.ok(createdCompany);
    }

    // 고유 ID로 소속사 조회
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable String id) { // 파라미터 타입 변경
        Optional<Company> company = companyService.getCompany(id);
        return company.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    // 소속사명 또는 소속사 ID로 검색
    @GetMapping("/search")
    public ResponseEntity<List<Company>> searchCompanies(
            @RequestParam(required = false) String companyName,
            @RequestParam(required = false) String companyId) {
        List<Company> companies = companyService.getCompaniesByNameOrId(companyName, companyId);
        return ResponseEntity.ok(companies);
    }

    // 소속사 ID로 소속사 업데이트
    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable String id, @RequestBody Company companyDetails) { // 파라미터 타입 변경
        Company updatedCompany = companyService.updateCompany(id, companyDetails);
        return ResponseEntity.ok(updatedCompany);
    }

    // 소속사 ID로 소속사 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable String id) { // 파라미터 타입 변경
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }

    // 소속사명으로 소속사 삭제 
    // 소속사 고유 ID로 삭제할 예정
    /*
    @DeleteMapping("/search/companyName")
    public ResponseEntity<Void> deleteCompanyByCompanyName(@RequestParam String companyName) {
        companyService.deleteCompanyByCompanyName(companyName);
        return ResponseEntity.noContent().build();
    }
    */
}
