package com.todocode.hotelsservice.controller;

import com.todocode.hotelsservice.model.Hotel;
import com.todocode.hotelsservice.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelsController {

    @Autowired
    private IHotelService iHotelService;

    @GetMapping("/{city_id}")
    public List<Hotel> getHotelsByCityId(@PathVariable Long city_id){
        return iHotelService.getHotelsByCityId(city_id);
    }

    @GetMapping("/andra")
    public String andra(){
        return "Hola andreitakun xd";
    }
}
