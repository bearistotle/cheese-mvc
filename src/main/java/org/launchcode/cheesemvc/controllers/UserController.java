package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.User;
import org.launchcode.cheesemvc.models.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddUserForm(Model model){
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify){
        boolean allAlphas = true;
        for (char c : user.getUserName().toCharArray()){
            if (!Character.isAlphabetic(c)){
                allAlphas = false;
            }
        }

        if (user.getUserName().isEmpty()){
            model.addAttribute("userName", user.getUserName());
            model.addAttribute("email", user.getUserEmail());
            model.addAttribute("error", "Username required.");
            return "user/add";
        }else if (user.getUserEmail().isEmpty()){
            model.addAttribute("userName", user.getUserName());
            model.addAttribute("email", user.getUserEmail());
            model.addAttribute("error", "Email required.");
            return "user/add";
        }else if(user.getUserName().length() < 5){
            model.addAttribute("userName", user.getUserName());
            model.addAttribute("email", user.getUserEmail());
            model.addAttribute("error", "Username must be greater than 5 characters.");
            return "user/add";
        }else if (user.getUserName().length() > 15){
            model.addAttribute("userName", user.getUserName());
            model.addAttribute("email", user.getUserEmail());
            model.addAttribute("error", "Username must be less than 15 characters.");
            return "user/add";
        }else if (allAlphas == false){
            model.addAttribute("userName", user.getUserName());
            model.addAttribute("email", user.getUserEmail());
            model.addAttribute("error", "Username cannot contain non-alphabetic characters.");
            return "user/add";
        }else if (!user.getUserPassword().equals(verify)){
            return "user/add";
        }else {
            model.addAttribute("user", user);
            UserData.add(user);
            return "redirect:";
        }
}
}
