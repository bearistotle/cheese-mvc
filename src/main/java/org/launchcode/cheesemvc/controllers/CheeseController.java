package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.CheeseData;
import org.launchcode.cheesemvc.models.CheeseType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Errors;


import org.launchcode.cheesemvc.models.Cheese;

import javax.validation.Valid;


import static org.launchcode.cheesemvc.models.CheeseData.getByID;

@Controller
@RequestMapping(value = "cheese")
public class CheeseController {


    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "My Cheeses");
        model.addAttribute("tab", "list");
        return "cheese/index"; /* return index template; thymeleaf looks in templates file for name automatically */
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "Add Cheese");
        model.addAttribute("tab", "add");
        //add empty cheese obj to help render form properly (equivalent to "cheese", new Cheese())
        model.addAttribute("cheese", new Cheese());
        //add cheeseType enum array
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese cheese, Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("title", "Add Cheese");
            model.addAttribute("tab", "add");
            return "cheese/add";
        }
        CheeseData.add(cheese);
        return "redirect:"; //redirect to cheese/ (redirect is relative to the handler it's in)
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model){
        model.addAttribute("title", "Remove Cheese(s)");
        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("tab", "remove");
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds){
        for (int cheeseId: cheeseIds){
            CheeseData.remove(cheeseId);
        }
        return "redirect:";
    }
//TODO: Fix issue with ids (not going up 1 by 1--something wrong with model binding creating extra objects)
    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId){
        Cheese cheeseToEdit = getByID(cheeseId);
        model.addAttribute("cheese", cheeseToEdit);
        model.addAttribute("title", String.format("Edit Cheese %s (id=%d)", cheeseToEdit.getName(),
                            cheeseToEdit.getCheeseId()));
        model.addAttribute("cheeseTypes", CheeseType.values());
        model.addAttribute("tab", "list");

        return "cheese/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute @Valid Cheese cheese, Errors errors, Model model){
        if (errors.hasErrors()){

            model.addAttribute("cheese", cheese);
            model.addAttribute("title", String.format("Edit Cheese %s (id=%d)", cheese.getName(),
                    cheese.getCheeseId()));
            model.addAttribute("cheeseTypes", CheeseType.values());
            model.addAttribute("tab", "list");

            return "cheese/edit";
        }
        Cheese oldCheese = CheeseData.getByID(cheese.getCheeseId());
        oldCheese.setName(cheese.getName());
        oldCheese.setDescription(cheese.getDescription());
        oldCheese.setType(cheese.getType());
        oldCheese.setRating(cheese.getRating());
        return "redirect:";
    }
}
