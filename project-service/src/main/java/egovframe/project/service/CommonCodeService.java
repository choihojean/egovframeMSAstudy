package egovframe.project.service;

import egovframe.project.entity.CommonCode;
import egovframe.project.repository.CommonCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonCodeService {

    @Autowired
    private CommonCodeRepository commonCodeRepository;

    public List<CommonCode> getCommonCodesByType(String codeType) {
        return commonCodeRepository.findByCodeType(codeType);
    }
}
