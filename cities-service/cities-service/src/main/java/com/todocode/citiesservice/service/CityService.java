package com.todocode.citiesservice.service;

import com.todocode.citiesservice.dto.CityDTO;
import com.todocode.citiesservice.model.City;
import com.todocode.citiesservice.repository.IHotelsAPI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService implements ICityService{

    @Autowired
    private IHotelsAPI iHotelsAPI;

    List<City> cities = new ArrayList<>();

    @Override
    @CircuitBreaker(name="hotels-service", fallbackMethod = "fallbackGetCitiesHotel")
    @Retry(name="hotels-service")
    public CityDTO getCitiesHotels(String name, String country) {

        City city = this.findCity(name, country);
        return new CityDTO(city.getCity_id(), city.getName(), city.getCountry(), city.getContinent(), city.getState(), iHotelsAPI.getHotelsByCityId(city.getCity_id()));
    }

    public City findCity(String name, String country){
        this.loadCities();
        for (City city : cities){
            if (city.getName().equals(name) && city.getCountry().equals(country)){
                return city;
            }
        }
        return null;
    }

    public CityDTO fallbackGetCitiesHotel(Throwable throwable){
        return new CityDTO(99999999L, "Fallido", "Fallido", "Fallido", "Fallido", null);
    }

    public void createException(){
        throw new IllegalArgumentException("Prueba Resilience y Circuit Breaker");
    }

    public void loadCities(){
        cities.add(new City(1L, "New York", "North America", "United States", "New York"));
        cities.add(new City(2L, "Paris", "Europe", "France", "Ile-de-France"));
        cities.add(new City(3L, "Tokyo", "Asia", "Japan", "Tokyo"));
        cities.add(new City(4L, "Sydney", "Australia", "Australia", "New South Wales"));
        cities.add(new City(5L, "Rio de Janeiro", "South America", "Brazil", "Rio de Janeiro"));
        cities.add(new City(6L, "Cairo", "Africa", "Egypt", "Cairo Governorate"));
        cities.add(new City(7L, "Moscow", "Europe", "Russia", "Moscow"));
        cities.add(new City(8L, "Dubai", "Asia", "United Arab Emirates", "Dubai"));
        cities.add(new City(9L, "Vancouver", "North America", "Canada", "British Columbia"));
        cities.add(new City(10L, "Cape Town", "Africa", "South Africa", "Western Cape"));
    }
}
