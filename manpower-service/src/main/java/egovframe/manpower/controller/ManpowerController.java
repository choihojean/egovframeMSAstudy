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
    public ResponseEntity<Manpower> getManpowerByKoreanName(@PathVariable String koreanName) {
        Optional<Manpower> manpower = manpowerService.getManpowerByKoreanName(koreanName);
        return manpower.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/company/{company}")
    public ResponseEntity<Manpower> getManpowerByCompany(@PathVariable String company) {
    	Optional<Manpower> manpower = manpowerService.getManpowerByCompany(company);
    	return manpower.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
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
}