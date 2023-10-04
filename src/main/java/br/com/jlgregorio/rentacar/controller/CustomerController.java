package br.com.jlgregorio.rentacar.controller;

import br.com.jlgregorio.rentacar.dto.CustomerDTO;
import br.com.jlgregorio.rentacar.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @PostMapping
    public CustomerDTO create(@RequestBody CustomerDTO dto){
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public CustomerDTO findById(@PathVariable("id") int id){
        return service.findById(id);
    }

    @PutMapping
    public CustomerDTO update(@RequestBody CustomerDTO dto){
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
        CustomerDTO dto = service.findById(id);
        service.delete(dto);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
