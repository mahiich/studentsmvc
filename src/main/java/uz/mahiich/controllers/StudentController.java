package uz.mahiich.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {

    @GetMapping("/getstudents")
    public String getStudents(){
        return "/students/getstudents";
    }

    @GetMapping("/addstudent")
    public String addStudent(){
        return "/students/addEditSaveStudent";
    }



}
