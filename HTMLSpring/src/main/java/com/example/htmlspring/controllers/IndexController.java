package com.example.htmlspring.controllers;
import com.example.htmlspring.services.Database;
import com.example.htmlspring.services.ValidateEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;



@Controller
public class IndexController {
    private Database db = new Database("jdbc:mysql://localhost:3306/WebScam","root","Uvnx3gxc");
    private ValidateEmailService emailValidationService = new ValidateEmailService();


    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @PostMapping("/post")
    public String post(WebRequest dataFromForm){
        boolean validEmail =emailValidationService.isEmailValid(dataFromForm.getParameter("email"));
        if(validEmail){
            db.insertTableData(dataFromForm.getParameter("email"));
        }
        return "redirect:/";
    }
}
