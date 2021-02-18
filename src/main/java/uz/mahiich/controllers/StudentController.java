package uz.mahiich.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/views")
public class StudentController {

    @GetMapping("/index.html")
    public String getStudents(){
        return "index";
    }
}
