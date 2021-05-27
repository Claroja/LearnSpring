package demo9.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ViewController {
    /**
     * 来登录页
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }


    @PostMapping("/login")
    public String login(@RequestParam Map<String,String> params, HttpSession session, Model model){ //RedirectAttributes

        if(StringUtils.hasLength(params.get("username")) && "123456".equals(params.get("password"))){
            //把登陆成功的用户保存起来
            session.setAttribute("loginUser",params.get("username"));
            //登录成功重定向到main.html;  重定向防止表单重复提交
            return "redirect:/success";
        }else {
            model.addAttribute("msg","账号密码错误");
            //回到登录页面
            return "login";
        }

    }



    @GetMapping("/success")
    public String success(Model model) {
        //model中的数据会被放在请求域中 request.setAttribute("a",aa)
        model.addAttribute("msg","wang");
        return "success";

    }

}
