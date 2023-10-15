package com.example.school53;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Student {
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String first;
    @NotBlank(message = "Last name is mandatory")
    private String last;
    @NotNull(message = "Age should be used")
    @Min(value = 16, message = "Minimum age is 16")
    private Integer age;

    public Student(Long id, String first, String last, Integer age) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
