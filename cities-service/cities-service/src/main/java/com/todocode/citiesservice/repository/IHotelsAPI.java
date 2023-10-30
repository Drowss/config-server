package com.todocode.citiesservice.repository;

import com.todocode.citiesservice.dto.HotelDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "hotels-service")
public interface IHotelsAPI {

    @GetMapping("/hotels/{city_id}")
    List<HotelDTO> getHotelsByCityId(@PathVariable Long city_id);
}
