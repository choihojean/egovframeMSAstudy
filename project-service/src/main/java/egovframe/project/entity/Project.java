package egovframe.project.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String projNo;

    @Column(nullable = false)
    private String projName;

    private String startDate;
    private String endDate;
    private String manager;
    private String phoneNo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "industry_code_id")
    private CommonCode industryCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "proj_code_id")
    private CommonCode projCode;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "proj_state_id")
    private CommonCode projState;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "work_area_id")
    private CommonCode workArea;
    
    private String reqDate;
    private String workLocation;
    private String workLocationDetail;
    private String essentialTech;
    private String projRemark;
    private String projEtc;
    
    //필요, 요구조건 변수
    private Long seq;
    private String techLevel;
    private String roleType;
    private String techType;
    private int requiredPersonnel;
    private double requiredBudget;

    // Getters and Setters
    
    public Project() {
    }
    
    //프로젝트 번호 생성 메소드
    private void generateProjNo() {
    	this.projNo = this.projName + "\n" + this.reqDate + " " + UUID.randomUUID().toString().substring(0, 5);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjNo() {
        return projNo;
    }

    public void setProjNo(String projNo) {
        this.projNo = projNo;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
        generateProjNo(); //프로젝트 명이 설정될 때마다 projNo를 갱신
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }


    public CommonCode getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(CommonCode industryCode) {
        this.industryCode = industryCode;
    }

    public CommonCode getProjCode() {
        return projCode;
    }

    public void setProjCode(CommonCode projCode) {
        this.projCode = projCode;
    }

    public CommonCode getProjState() {
        return projState;
    }

    public void setProjState(CommonCode projState) {
        this.projState = projState;
    }

    public String getReqDate() {
        return reqDate;
    }

    public void setReqDate(String reqDate) {
        this.reqDate = reqDate;
        generateProjNo(); //의뢰일자가 설정될 때마다 projNo를 갱신
    }

    public CommonCode getWorkArea() {
        return workArea;
    }

    public void setWorkArea(CommonCode workArea) {
        this.workArea = workArea;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }
    
    public String getWorkLocationDetail() {
    	return workLocationDetail;
    }
    
    public void setWorkLocationDetail(String workLocationDetail) {
    	this.workLocationDetail = workLocationDetail;
    }

    public String getEssentialTech() {
        return essentialTech;
    }

    public void setEssentialTech(String essentialTech) {
        this.essentialTech = essentialTech;
    }

    public String getProjRemark() {
        return projRemark;
    }

    public void setProjRemark(String projRemark) {
        this.projRemark = projRemark;
    }

    public String getProjEtc() {
        return projEtc;
    }

    public void setProjEtc(String projEtc) {
        this.projEtc = projEtc;
    }
    
    //필요, 요구조건 getter,setter
    
    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public String getTechLevel() {
        return techLevel;
    }

    public void setTechLevel(String techLevel) {
        this.techLevel = techLevel;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getTechType() {
        return techType;
    }

    public void setTechType(String techType) {
        this.techType = techType;
    }

    public int getRequiredPersonnel() {
        return requiredPersonnel;
    }

    public void setRequiredPersonnel(int requiredPersonnel) {
        this.requiredPersonnel = requiredPersonnel;
    }

    public double getRequiredBudget() {
        return requiredBudget;
    }

    public void setRequiredBudget(double requiredBudget) {
        this.requiredBudget = requiredBudget;
    }
}
