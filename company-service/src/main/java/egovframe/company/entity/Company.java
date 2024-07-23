package egovframe.company.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;

@Entity
@JsonPropertyOrder({ "id", "companyId", "companyName", "relation", "address", "businessNumber", "representative", "phoneNumber", "active" })
public class Company {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private Long id;
    
    private String companyId;  // 소속사ID 변경: Long에서 String으로

    private String companyName;  // 소속사명

    private String relation;  // 관계

    private String address;  // 주소

    private String businessNumber;  // 사업자번호

    private String representative;  // 대표자

    private String phoneNumber;  // 전화번호

    @Column(nullable = false)
    private boolean active;  // 사용여부

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    public void generateCompanyId() {
        String uuidPart = UUID.randomUUID().toString().substring(0, 5);
        String currentDate = LocalDate.now().toString(); // 현재 날짜를 문자열로 변환
        this.companyId = companyName + currentDate + "-" + uuidPart;
    }
}
