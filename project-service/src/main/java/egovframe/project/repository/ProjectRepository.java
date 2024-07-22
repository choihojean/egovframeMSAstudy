package egovframe.project.repository;

import egovframe.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import egovframe.project.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
