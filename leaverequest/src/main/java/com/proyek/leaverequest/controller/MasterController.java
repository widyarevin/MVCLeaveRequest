package com.proyek.leaverequest.controller;

import com.proyek.leaverequest.entities.Category;
import com.proyek.leaverequest.entities.Master;
import com.proyek.leaverequest.services.CategoryService;
import com.proyek.leaverequest.services.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("")
public class MasterController {
    @Autowired
    private MasterService masterService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String masterIndex(Model model) {
        model.addAttribute("masters", masterService.findAllMasters());
        return "master/master-index";
    }


    @GetMapping(value = {"form","form/{id}"})
    public String masterForm(@PathVariable(required = false) Integer id, Model model){
        if(id != null){
            model.addAttribute("category",masterService.findMasterById(id));
        } else {
//            model.addAttribute("master", new Master());
            model.addAttribute("categories", categoryService.findAllCategories());
        }
        return "master/request-leave";
    }

    @PostMapping("save")
    public String saveMaster(Master master){
        masterService.saveMaster(master);
        System.out.println(masterService.saveMaster(master));
        return "redirect:/";
    }

    @PostMapping("delete/{id}")
    public String deleteMaster(@PathVariable int id){
        masterService.deleteMasterById(id);
        return "redirect:/";
    }

}
