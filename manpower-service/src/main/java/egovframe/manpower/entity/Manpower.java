package egovframe.manpower.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Manpower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String koreanName;

    private String englishName;

    private String residentNumberFront;

    private String residentNumberBack;

    private String nationality;

    private String phoneNumberFront;

    private String phoneNumberMiddle;

    private String phoneNumberBack;

    private String birthDate;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String qualificationType;

    private String qualificationCode;

    @Column(nullable = false)
    private String company;

    private String major;

    private String additionalSkills;

    @Column(nullable = false)
    private String evaluationCode;

    private String evaluationContent;

    private String isBlacklisted;

    private String blacklistReason;

    private String profile;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKoreanName() {
        return koreanName;
    }

    public void setKoreanName(String koreanName) {
        this.koreanName = koreanName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getResidentNumberFront() {
        return residentNumberFront;
    }

    public void setResidentNumberFront(String residentNumberFront) {
        this.residentNumberFront = residentNumberFront;
    }

    public String getResidentNumberBack() {
        return residentNumberBack;
    }

    public void setResidentNumberBack(String residentNumberBack) {
        this.residentNumberBack = residentNumberBack;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhoneNumberFront() {
        return phoneNumberFront;
    }

    public void setPhoneNumberFront(String phoneNumberFront) {
        this.phoneNumberFront = phoneNumberFront;
    }

    public String getPhoneNumberMiddle() {
        return phoneNumberMiddle;
    }

    public void setPhoneNumberMiddle(String phoneNumberMiddle) {
        this.phoneNumberMiddle = phoneNumberMiddle;
    }

    public String getPhoneNumberBack() {
        return phoneNumberBack;
    }

    public void setPhoneNumberBack(String phoneNumberBack) {
        this.phoneNumberBack = phoneNumberBack;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQualificationType() {
        return qualificationType;
    }

    public void setQualificationType(String qualificationType) {
        this.qualificationType = qualificationType;
    }

    public String getQualificationCode() {
        return qualificationCode;
    }

    public void setQualificationCode(String qualificationCode) {
        this.qualificationCode = qualificationCode;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getAdditionalSkills() {
        return additionalSkills;
    }

    public void setAdditionalSkills(String additionalSkills) {
        this.additionalSkills = additionalSkills;
    }

    public String getEvaluationCode() {
        return evaluationCode;
    }

    public void setEvaluationCode(String evaluationCode) {
        this.evaluationCode = evaluationCode;
    }

    public String getEvaluationContent() {
        return evaluationContent;
    }

    public void setEvaluationContent(String evaluationContent) {
        this.evaluationContent = evaluationContent;
    }

    public String getIsBlacklisted() {
        return isBlacklisted;
    }

    public void setIsBlacklisted(String isBlacklisted) {
        this.isBlacklisted = isBlacklisted;
    }

    public String getBlacklistReason() {
        return blacklistReason;
    }

    public void setBlacklistReason(String blacklistReason) {
        this.blacklistReason = blacklistReason;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}