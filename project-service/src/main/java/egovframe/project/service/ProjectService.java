package egovframe.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframe.project.entity.Project;
import egovframe.project.repository.CommonCodeRepository;
import egovframe.project.repository.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    
    @Autowired
    private CommonCodeRepository commonCodeRepository;

    public Project createProject(Project project) {
    	project.setIndustryCode(commonCodeRepository.findById(project.getIndustryCode().getId()).orElse(null));
        project.setProjCode(commonCodeRepository.findById(project.getProjCode().getId()).orElse(null));
        project.setProjState(commonCodeRepository.findById(project.getProjState().getId()).orElse(null));
        project.setWorkArea(commonCodeRepository.findById(project.getWorkArea().getId()).orElse(null));
        
        return projectRepository.save(project);
    }

    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }
    
    
    public List<Project> searchProjects(String projName, String startDate, String endDate) {
        if (projName != null && projName.isEmpty()) {
            projName = null;
        }
        if (startDate != null && startDate.isEmpty()) {
            startDate = null;
        }
        if (endDate != null && endDate.isEmpty()) {
            endDate = null;
        }
        return projectRepository.findByProjNameAndDates(projName, startDate, endDate);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project updateProject(Long id, Project projectDetails) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
        project.setProjName(projectDetails.getProjName());
        project.setStartDate(projectDetails.getStartDate());
        project.setEndDate(projectDetails.getEndDate());
        project.setManager(projectDetails.getManager());
        project.setPhoneNo(projectDetails.getPhoneNo());
        project.setIndustryCode(commonCodeRepository.findById(projectDetails.getIndustryCode().getId()).orElse(null));
        project.setProjCode(commonCodeRepository.findById(projectDetails.getProjCode().getId()).orElse(null));
        project.setProjState(commonCodeRepository.findById(projectDetails.getProjState().getId()).orElse(null));
        project.setWorkArea(commonCodeRepository.findById(projectDetails.getWorkArea().getId()).orElse(null));
        project.setReqDate(projectDetails.getReqDate());
        project.setWorkLocation(projectDetails.getWorkLocation());
        project.setEssentialTech(projectDetails.getEssentialTech());
        project.setProjRemark(projectDetails.getProjRemark());
        project.setProjEtc(projectDetails.getProjEtc());
        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
