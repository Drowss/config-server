package com.todocode.hotelsservice.service;

import com.todocode.hotelsservice.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService implements IHotelService{

    List<Hotel> hotelsList = new ArrayList<>();

    @Override
    public List<Hotel> getHotelsByCityId(Long city_id) {

        List<Hotel> hotelCityList = new ArrayList<>();

        this.loadHotels();

        for(Hotel hotel : hotelsList){
            if (hotel.getCity_id() == city_id){
                hotelCityList.add(hotel);
            }
        }

        return hotelCityList;
    }

    public void loadHotels(){
        hotelsList.add(new Hotel(1L, "Paradise", 5, 1L));
        hotelsList.add(new Hotel(2L, "Venezuela", 5, 2L));
        hotelsList.add(new Hotel(3L, "LOCOMBIA", 5, 3L));
        hotelsList.add(new Hotel(4L, "GOKU EL MEJOR", 5, 1L));
        hotelsList.add(new Hotel(5L, "HOSPEDAJE GRATIS", 5, 2L));
        hotelsList.add(new Hotel(6L, "XD", 5, 3L));
        hotelsList.add(new Hotel(7L, "LOL", 5, 1L));
        hotelsList.add(new Hotel(8L, "WATAFOK", 5, 2L));

    }
}
