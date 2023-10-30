package com.todocode.citiesservice.controller;

import com.todocode.citiesservice.dto.CityDTO;
import com.todocode.citiesservice.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CitiesController {

    @Autowired
    private ICityService iCityService;

    @GetMapping("/hotels")
    public CityDTO getCityAndHotels(@RequestParam String name,
                                    @RequestParam String country){
        return iCityService.getCitiesHotels(name, country);
    }
}
