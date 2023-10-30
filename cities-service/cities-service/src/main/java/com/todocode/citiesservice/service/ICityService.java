package com.todocode.citiesservice.service;

import com.todocode.citiesservice.dto.CityDTO;

public interface ICityService {

    CityDTO getCitiesHotels(String name, String country);
}
