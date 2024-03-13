package kz.aksay.spring.bootspring.controller;

import kz.aksay.spring.bootspring.db.DBManager;
import kz.aksay.spring.bootspring.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping(value = "/home")
    public String indexPage(Model model){
        ArrayList<Student> students = DBManager.getAllItems();
        model.addAttribute("AllStudent",students);
        return "index";
    }

    @GetMapping(value = "/AddStudent")
    public String AddStudent(){
        return "addPage";
    }
    @PostMapping(value = "AddPage")
    public String AddPage(@RequestParam(name = "name") String NameStudent,
                          @RequestParam(name = "surname") String SurnStundent,
                          @RequestParam(name = "exam") int ExamStudent){
        Student students = new Student();
        students.setName(NameStudent);
        students.setSurname(SurnStundent);
        students.setExam(ExamStudent);
        DBManager.AddItems(students);
        return "redirect:/home";
    }


}
