package controllers;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.validation.Valid;
import javax.xml.ws.Action;

@Controller
public class FormController {
    @Autowired
    private UserService userService;
    @GetMapping("")
    public String showForm(Model model)
    {
        model.addAttribute("user",new User());
        return "index";
    }
    @PostMapping("/reg")
    public ModelAndView check(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("index");
            modelAndView.addObject("user",new User());
        }else {
            userService.save(user);
            ModelAndView modelAndView = new ModelAndView("result");
            return modelAndView;
        }
        return new ModelAndView("index");
    }
}
