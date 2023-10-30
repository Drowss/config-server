package com.todocode.hotelsservice.service;

import com.todocode.hotelsservice.model.Hotel;

import java.util.List;

public interface IHotelService {
    List<Hotel> getHotelsByCityId(Long city_id);
}
