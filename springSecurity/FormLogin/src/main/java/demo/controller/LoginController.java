package demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String showLogin(){
        return "login";
    }
    @ResponseBody
    @RequestMapping("/success")
    public String successLogin(){
        return "success";
    }
    @ResponseBody
    @RequestMapping("/failure")
    public String failureLogin(){
        return "failure";
    }
}
