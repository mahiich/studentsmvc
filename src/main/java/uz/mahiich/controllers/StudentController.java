package uz.mahiich.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.mahiich.dao.StudentDAO;
import uz.mahiich.model.Student;

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

//    @GetMapping("/search")
//    public String searchStudent(@PathVariable("searchvalue") String searchvalue, Model model){
//
//        return
//    }

    @GetMapping("/addstudent")
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
        return "students/addstudent";
    }

    @GetMapping("/{id}/delete")
    public String deleteStudent(@PathVariable("id") int id,Model model){
        model.addAttribute("id",studentDAO.deleteStudent(id));
        return "redirect: /students/getstudents";
    }

    @PostMapping("/{id}/edit")
    public String editStudent(@PathVariable("id") int id,Model model){
        model.addAttribute("id",studentDAO.editStudent(id));
        return "redirect: /students/getstudents";
    }


}
