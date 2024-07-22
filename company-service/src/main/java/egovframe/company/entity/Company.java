package egovframe.company.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Company {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long companyId;  // 소속사ID

	  
	    private String companyName;  // 소속사명

	    private String relation;  // 관계

	    private String address;  // 주소

	    private String businessNumber;  // 사업자번호

	    private String representative;  // 대표자

	    private String phoneNumber;  // 전화번호

	    private String modifier;  // 수정자

	    private String modifiedDate;  // 수정일

	    private String active;  // 사용여부

	    // Getters and Setters

	    public Long getCompanyId() {
	        return companyId;
	    }

	    public void setCompanyId(Long companyId) {
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

	    public String getModifier() {
	        return modifier;
	    }

	    public void setModifier(String modifier) {
	        this.modifier = modifier;
	    }

	    public String getModifiedDate() {
	        return modifiedDate;
	    }

	    public void setModifiedDate(String modifiedDate) {
	        this.modifiedDate = modifiedDate;
	    }

	    public String getActive() {
	        return active;
	    }

	    public void setActive(String active) {
	        this.active = active;
	    }
	}


