package egovframe.project.entity;

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
    private String essentialTech;
    private String projRemark;
    private String projEtc;

    public Project() {
        // Default constructor
    }

    private void generateProjNo() {
        this.projNo = this.projName + this.reqDate + "-" + UUID.randomUUID().toString().substring(0, 5);
    }

    // Getters and Setters

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
        generateProjNo();
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
        generateProjNo();
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
}
