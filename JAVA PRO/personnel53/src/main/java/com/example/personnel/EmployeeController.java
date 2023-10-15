package com.example.personnel;

import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/employee")
    public Iterable<Employee> getAll(){
        return repository.findAll();
    }

    @DeleteMapping("/employee")
    public ResponseEntity deleteEmployee(
            @RequestBody Employee employee
    )
    {
        repository.delete(employee);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/employee")
    public Employee createOrUpdateEmployee(
            @RequestBody Employee employee
    )
    {
        return repository.save(employee);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, String> handleConstraintViolationException(
            ConstraintViolationException ex
    ){
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(
                violation -> {
                    errors.put(
                            violation.getPropertyPath().toString(),
                            violation.getMessage()
                    );
                }
        );
        return errors;
    }


}
