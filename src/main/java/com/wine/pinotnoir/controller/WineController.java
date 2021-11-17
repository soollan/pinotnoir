package com.wine.pinotnoir.controller;

import com.wine.pinotnoir.dto.Wine;
import com.wine.pinotnoir.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WineController {

    private final WineService wineService;

    @Autowired
    public WineController(WineService wineService) {
        this.wineService = wineService;
    }

    @GetMapping("/wine")
    public ModelAndView winePage() {
        ModelAndView model = new ModelAndView();
//        model.addObject("list", wineService.getWines());
        model.setViewName("/wine");
        return model;
    }

    @GetMapping("/wines")
    @ResponseBody
    public Map<String, List<Wine>> wines() {
        Map<String, List<Wine>> map = new HashMap<>();
        List<Wine> wines = wineService.getWines();
        map.put("data", wines);

        return map;
    }

    @PostMapping("/wine")
    public String addWine(@ModelAttribute Wine wine) {
        wineService.add(wine);
        return "wine";
    }

}
