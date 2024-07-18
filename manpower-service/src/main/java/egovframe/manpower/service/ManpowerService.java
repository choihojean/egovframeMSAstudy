package egovframe.manpower.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import egovframe.manpower.entity.Manpower;
import egovframe.manpower.repository.ManpowerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ManpowerService {

    @Autowired
    private ManpowerRepository manpowerRepository;

    public Manpower createManpower(Manpower manpower) {
        return manpowerRepository.save(manpower);
    }

    public Optional<Manpower> getManpower(Long id) {
        return manpowerRepository.findById(id);
    }
    
    public List<Manpower> getManpowerByKoreanName(String koreanName) {
        return manpowerRepository.findByKoreanName(koreanName);
    }
    
    public List<Manpower> getManpowerByCompany(String company){
    	return manpowerRepository.findByCompany(company);
    }

    public List<Manpower> getAllManpower() {
        return manpowerRepository.findAll();
    }

    public Manpower updateManpower(Long id, Manpower manpowerDetails) {
        Manpower manpower = manpowerRepository.findById(id).orElseThrow(() -> new RuntimeException("Manpower not found"));
        
        manpower.setKoreanName(manpowerDetails.getKoreanName());
        manpower.setEnglishName(manpowerDetails.getEnglishName());
        manpower.setResidentNumberFront(manpowerDetails.getResidentNumberFront());
        manpower.setResidentNumberBack(manpowerDetails.getResidentNumberBack());
        manpower.setNationality(manpowerDetails.getNationality());
        manpower.setPhoneNumberFront(manpowerDetails.getPhoneNumberFront());
        manpower.setPhoneNumberMiddle(manpowerDetails.getPhoneNumberMiddle());
        manpower.setPhoneNumberBack(manpowerDetails.getPhoneNumberBack());
        manpower.setBirthDate(manpowerDetails.getBirthDate());
        manpower.setAddress(manpowerDetails.getAddress());
        manpower.setEmail(manpowerDetails.getEmail());
        manpower.setQualificationType(manpowerDetails.getQualificationType());
        manpower.setQualificationCode(manpowerDetails.getQualificationCode());
        manpower.setCompany(manpowerDetails.getCompany());
        manpower.setMajor(manpowerDetails.getMajor());
        manpower.setAdditionalSkills(manpowerDetails.getAdditionalSkills());
        manpower.setEvaluationCode(manpowerDetails.getEvaluationCode());
        manpower.setEvaluationContent(manpowerDetails.getEvaluationContent());
        manpower.setIsBlacklisted(manpowerDetails.getIsBlacklisted());
        manpower.setBlacklistReason(manpowerDetails.getBlacklistReason());
        manpower.setProfile(manpowerDetails.getProfile());

        return manpowerRepository.save(manpower);
    }

    public void deleteManpower(Long id) {
        Manpower manpower = manpowerRepository.findById(id).orElseThrow(() -> new RuntimeException("Manpower not found"));
        manpowerRepository.delete(manpower);
    }
}