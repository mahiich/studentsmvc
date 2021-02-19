package uz.mahiich.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.mahiich.dao.StudentDAO;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentDAO studentDAO;

    @Autowired
    public StudentController(StudentDAO studentDAO) {
        this.studentDAO=studentDAO;
    }

    @GetMapping("/getstudents")
    public String getStudents(Model model){
        model.addAttribute("students", studentDAO.getStudents());
        return "students/getstudents";
    }

    @GetMapping("/{id}")
    public String addStudent(){
        return "students/addEditSaveStudent";
    }



}
