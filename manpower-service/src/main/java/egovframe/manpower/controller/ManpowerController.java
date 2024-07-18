package egovframe.manpower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import egovframe.manpower.entity.Manpower;
import egovframe.manpower.service.ManpowerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manpower")
public class ManpowerController {

    @Autowired
    private ManpowerService manpowerService;

    @PostMapping
    public Manpower createManpower(@RequestBody Manpower manpower) {
        return manpowerService.createManpower(manpower);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manpower> getManpower(@PathVariable Long id) {
        Optional<Manpower> manpower = manpowerService.getManpower(id);
        return manpower.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/name/{koreanName}")
    public ResponseEntity<List<Manpower>> getManpowerByKoreanName(@PathVariable String koreanName) {
        List<Manpower> manpowerList = manpowerService.getManpowerByKoreanName(koreanName);
        return ResponseEntity.ok(manpowerList);
    }
    
    @GetMapping("/company/{company}")
    public ResponseEntity<List<Manpower>> getManpowerByCompany(@PathVariable String company) {
    	List<Manpower> manpowerList = manpowerService.getManpowerByCompany(company);
    	return ResponseEntity.ok(manpowerList);
    }
    
    @GetMapping("/name/{koreanName}/company/{company}")
    public ResponseEntity<List<Manpower>> getManpowerByKoreanNameAndCompany(@PathVariable String koreanName, @PathVariable String company) {
        List<Manpower> manpowerList = manpowerService.getManpowerByKoreanNameAndCompany(koreanName, company);
        return ResponseEntity.ok(manpowerList);
    }

    @GetMapping
    public List<Manpower> getAllManpower() {
        return manpowerService.getAllManpower();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manpower> updateManpower(@PathVariable Long id, @RequestBody Manpower manpowerDetails) {
        Manpower updatedManpower = manpowerService.updateManpower(id, manpowerDetails);
        return ResponseEntity.ok(updatedManpower);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManpower(@PathVariable Long id) {
        manpowerService.deleteManpower(id);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/name/{koreanName}")
    public ResponseEntity<Void> deleteManpowerByKoreanName(@PathVariable String koreanName) {
        manpowerService.deleteManpowerByKoreanName(koreanName);
        return ResponseEntity.noContent().build();
    }
}