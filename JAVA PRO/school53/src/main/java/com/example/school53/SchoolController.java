package com.example.school53;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class SchoolController {
    private List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1L, "Max", "Petrov", 19),
                    new Student(2L, "Dima", "Alexeev", 18),
                    new Student(3L, "Leonid", "Sergeev", 21),
                    new Student(4L, "Masha", "Samoilova", 18),
                    new Student(5L, "Dina", "Ivanova", 19)
            )
    );

    private Teacher teacher = new Teacher(10L, "Maria Ivanovna", true);

    // GET http://localhost:8080/students
    @GetMapping("/students")
    public String getAll(Model model){
        String time = "" + System.currentTimeMillis();
        // биндинг объектов в шаболон thymeleaf
        model.addAttribute("time", time);
        model.addAttribute("students", students);
        // добавьте учителя в шаблон
        // в шалоне выведите его в виде заголовка h3 id,name,working
        model.addAttribute("teacher", teacher);

        return "list"; // шаблон /templates/list.html
    }


    @GetMapping("/student/{id}")
    public String changeStudent(
            @PathVariable Long id,
            Model model
    )
    {
        Student student = students.stream()
                .filter(s -> s.getId().equals(id)).findFirst().get();
        model.addAttribute("student", student);
        return "change-student";
    }

    @PostMapping("/student/{id}")
    public String updateStudent(
            @PathVariable Long id,
            @Valid // student должен быть проверен на соответствие правилам валидации
            @ModelAttribute Student student,
            BindingResult result,
            Model model
    ) {
        if(result.hasErrors())
            return "change-student";

        for(int i = 0; i < students.size(); i++)
        {
            if(students.get(i).getId().equals(id)) {
                students.set(i, student);
                break;
            }
        }
        return "redirect:/students";
    }

    @GetMapping("/student/delete/{id}")
    public String delete(
            @PathVariable Long id
    )
    {
        for(int i = 0; i < students.size(); i++)
        {
            if(students.get(i).getId().equals(id))
            {
                students.remove(i);
                break;
            }
        }
        return "redirect:/students";
    }

    @GetMapping("/add")
    public String getAddTemplate(Student student)
    {
        return "add-student";
    }

    @PostMapping("/students")
    public String createStudent(
        @Valid @ModelAttribute Student student,
        BindingResult result,
        Model model
    ) {
        if(result.hasErrors())
            return "add-student";

        students.add(student);
        return "redirect:/students";
    }

}
