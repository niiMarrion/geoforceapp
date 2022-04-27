package com.geoadapp.service.impl;

import com.geoadapp.model.Location;
import com.geoadapp.repository.LocationRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LocationServiceImplTest {

    @Test
    void save() {
    }

    @Test
    void delete() {
    }


    @Autowired
    private LocationRepository locationRepository;

    @org.junit.Test
    @Order(1)
    @Rollback(value = false)
    public void saveLocationTest(){
        Location location = Location.builder()
                .latitude(12.111134D)
                .longitude(14.55633D)
                .radius(12.55)
                .build();
        locationRepository.save(location);

        Assertions.assertThat(location.getId()).isNotZero();
    }

    @org.junit.Test
    @Order(2)
    public void getLocationTest(){

        Location location = locationRepository.findById(1L).get();

        Assertions.assertThat(location.getId()).isEqualTo(1L);

    }

    @org.junit.Test
    @Order(3)
    public void getListOfLocationsTest(){

        List<Location> locations = locationRepository.findAll();

        Assertions.assertThat(locations.size()).isGreaterThan(0);

    }

    @org.junit.Test
    @Order(4)
    @Rollback(value = false)
    public void updateLocationTest(){

        Location location = locationRepository.findById(1L).get();

        location.setLatitude(12.1111);
        location.setLongitude(12.1111);
        location.setRadius(12.34565);

        Location locationUpdated =  locationRepository.save(location);

        Assertions.assertThat(locationUpdated.getLatitude()).isEqualTo(12.1111);

    }

    @org.junit.Test
    @Order(5)
    @Rollback(value = false)
    public void deleteLocationTest(){

        Location location = locationRepository.findById(1L).get();

        locationRepository.delete(location);



        Location newLocation = null;

        Optional<Location> optionalEmployee = Optional.ofNullable(locationRepository.findByLatitudeAndLongitude(12.1111, 12.1111));

        if(optionalEmployee.isPresent()){
            newLocation = optionalEmployee.get();
        }

        Assertions.assertThat(newLocation).isNull();
    }
}