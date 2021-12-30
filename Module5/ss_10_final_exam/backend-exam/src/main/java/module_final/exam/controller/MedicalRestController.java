package module_final.exam.controller;

import module_final.exam.model.Medical;
import module_final.exam.model.Patient;
import module_final.exam.service.IMedicalService;
import module_final.exam.service.IPatientService;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MedicalRestController {
    @Autowired
    private IMedicalService medicalService;
    @Autowired
    private IPatientService patientService;

    @GetMapping("api/medical")
    public ResponseEntity< Page< Medical > > getAllMedical(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 3, Sort.by("id"));
        Page< Medical > medicalPage = medicalService.findAll(pageable);
        if (medicalPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicalPage, HttpStatus.OK);
    }

    @GetMapping("api/medical/{id}")
    public ResponseEntity< Medical > findMedicalById(@PathVariable Integer id) {
        Optional< Medical > medical = medicalService.findById(id);
        if (medical.isPresent()) {
            return new ResponseEntity<>(medical.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("api/medical/{id}")
    public void  deleteMedical(@PathVariable Integer id) {
            medicalService.remove(id);
        }

    @GetMapping("api/patient")
    public ResponseEntity< Iterable< Patient > > getAllPatient() {
        List< Patient > patientPage = (List< Patient >) patientService.findAll();
        if (patientPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(patientPage, HttpStatus.OK);
    }

}
