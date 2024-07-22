package egovframe.project.controller;

import egovframe.project.entity.CommonCode;
import egovframe.project.service.CommonCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/common-codes")
public class CommonCodeController {

    @Autowired
    private CommonCodeService commonCodeService;

    @GetMapping("/{codeType}")
    public ResponseEntity<List<CommonCode>> getCommonCodesByType(@PathVariable String codeType) {
        List<CommonCode> commonCodes = commonCodeService.getCommonCodesByType(codeType);
        return ResponseEntity.ok(commonCodes);
    }
}
