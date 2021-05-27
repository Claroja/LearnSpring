package demo8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ViewController {
    @GetMapping("/forword")
    public String forword(HttpServletRequest request){
        request.setAttribute("msg1","在goto页写入msg1");
        request.setAttribute("msg2","在goto页写入msg2");
        return "forward:/success";  //转发到
    }

    @GetMapping("/success")
    public String success(Model model) {
        //model中的数据会被放在请求域中 request.setAttribute("a",aa)
        model.addAttribute("msg","wang");
        return "success";

    }

    @GetMapping("/redirect")
    public String redirect(){
        return "redirect:/success";
    }
}
