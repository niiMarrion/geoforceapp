package com.geoadapp;

import com.geoadapp.model.Location;
import com.geoadapp.repository.LocationRepository;
import com.geoadapp.service.LocationService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LocationRepositoryTests {

    @Autowired
    private LocationRepository locationRepository;

    @Test
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

    @Test
    @Order(2)
    public void getLocationTest(){

        Location location = locationRepository.findById(1L).get();

        Assertions.assertThat(location.getId()).isEqualTo(1L);

    }

    @Test
    @Order(3)
    public void getListOfLocationsTest(){

        List<Location> locations = locationRepository.findAll();

        Assertions.assertThat(locations.size()).isGreaterThan(0);

    }

    @Test
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

    @Test
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
