package org.launchcode.controllers;

/**
 * Created by Timothy on 9/16/2017.
 */

import org.launchcode.models.Cheese;
import org.launchcode.models.CheeseData;
import org.launchcode.models.CheeseType;
import org.launchcode.models.data.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;


    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("category", categoryDao.findAll());
        model.addAttribute("title", "Categories");


        return "category/index";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCategoryForm(Model model) {
        model.addAttribute("title", "Add Category");
        model.addAttribute(new Category());
        //model.addAttribute("cheeseTypes", CheeseType.values());
        return "category/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute @Valid Category category, Errors errors) {

    //public String processAddCategoryForm(@ModelAttribute @Valid Category newCategory,
    //                                   Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Category");
            return "category/add";
        }

        //CategoryDao.add(newCategory);
        categoryDao.save(category);
        return "redirect:";
    }

}
