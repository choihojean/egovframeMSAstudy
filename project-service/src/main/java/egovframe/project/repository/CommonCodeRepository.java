package egovframe.project.repository;

import egovframe.project.entity.CommonCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommonCodeRepository extends JpaRepository<CommonCode, Long> {
    List<CommonCode> findByCodeType(String codeType);
}
