package egovframe.project.controller;

import egovframe.project.entity.CommonCode;
import egovframe.project.service.CommonCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommonCodeController {

    @Autowired
    private CommonCodeService commonCodeService;

    @GetMapping("/common-codes")
    public List<CommonCode> getCommonCodesByType(@RequestParam String codeType) {
        return commonCodeService.getCommonCodesByType(codeType);
    }
}
