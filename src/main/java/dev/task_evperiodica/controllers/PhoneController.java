package dev.task_evperiodica.controllers;

import dev.task_evperiodica.models.Phone;
import dev.task_evperiodica.service.PhoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phones/")
public class PhoneController {
    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService){
        super();
        this.phoneService = phoneService;
    }

    @PostMapping("create/{id}")
    public ResponseEntity<Phone> create(@RequestBody Phone phone){
        return new ResponseEntity<Phone>(phoneService.create(phone), HttpStatus.CREATED);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Phone> get(@PathVariable("id") long id){
        return new ResponseEntity<Phone>(phoneService.read(id), HttpStatus.OK);
    }

    @GetMapping
    public List<Phone> get(){
        return phoneService.readAll();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Phone> update(@PathVariable ("id") long id, @RequestBody Phone phone) {
        return new ResponseEntity<Phone>(phoneService.update(id, phone), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public List<Phone> delete(@PathVariable ("id") long id) {
        return phoneService.delete(id);
    }
}
