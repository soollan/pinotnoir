package com.wine.pinotnoir.controller;

import com.wine.pinotnoir.dto.Wine;
import com.wine.pinotnoir.entity.WineEntity;
import com.wine.pinotnoir.service.WineService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WineController {

    @Autowired
    WineService wineService;

    @GetMapping("/wines")
    public ModelAndView wines() {
        ModelAndView model = new ModelAndView();
        model.addObject("list", wineService.getWines());
        model.setViewName("wine");
        return model;
    }

    @PostMapping("/wine")
    public String addWine(@ModelAttribute Wine wine) throws NotFoundException {
        wineService.add(wine);
        return "redirect:/wines";
    }

}
