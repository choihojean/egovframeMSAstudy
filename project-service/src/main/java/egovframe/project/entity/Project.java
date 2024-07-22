package egovframe.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import java.util.UUID;

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
    private String phoneNoFront;
    private String phoneNoMiddle;
    private String phoneNoBack;
    private String industryCode;
    private String projCode;
    private String projState;
    private String reqDate;
    private String workArea;
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

    public String getPhoneNoFront() {
        return phoneNoFront;
    }

    public void setPhoneNoFront(String phoneNoFront) {
        this.phoneNoFront = phoneNoFront;
    }

    public String getPhoneNoMiddle() {
        return phoneNoMiddle;
    }

    public void setPhoneNoMiddle(String phoneNoMiddle) {
        this.phoneNoMiddle = phoneNoMiddle;
    }

    public String getPhoneNoBack() {
        return phoneNoBack;
    }

    public void setPhoneNoBack(String phoneNoBack) {
        this.phoneNoBack = phoneNoBack;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public String getProjCode() {
        return projCode;
    }

    public void setProjCode(String projCode) {
        this.projCode = projCode;
    }

    public String getProjState() {
        return projState;
    }

    public void setProjState(String projState) {
        this.projState = projState;
    }

    public String getReqDate() {
        return reqDate;
    }

    public void setReqDate(String reqDate) {
        this.reqDate = reqDate;
        generateProjNo();
    }

    public String getWorkArea() {
        return workArea;
    }

    public void setWorkArea(String workArea) {
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
