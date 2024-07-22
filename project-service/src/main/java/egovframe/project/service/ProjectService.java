package egovframe.project.service;

import egovframe.project.entity.Project;
import egovframe.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Optional<Project> getProject(Long id) {
        return projectRepository.findById(id);
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
        project.setPhoneNoFront(projectDetails.getPhoneNoFront());
        project.setPhoneNoMiddle(projectDetails.getPhoneNoMiddle());
        project.setPhoneNoBack(projectDetails.getPhoneNoBack());
        project.setIndustryCode(projectDetails.getIndustryCode());
        project.setProjCode(projectDetails.getProjCode());
        project.setProjState(projectDetails.getProjState());
        project.setReqDate(projectDetails.getReqDate());
        project.setWorkArea(projectDetails.getWorkArea());
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
