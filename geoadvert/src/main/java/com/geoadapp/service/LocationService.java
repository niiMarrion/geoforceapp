package com.geoadapp.service;

import com.geoadapp.model.Location;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface LocationService {

    Location save(Location location);

    void delete(Location location);

    Location update(Location location);

    Optional<Location> findById(Long id);

    Location findByLatitudeAndLongitude(Double Latitude, Double Longitude);

    List<Location> findAll();

    void deleteById(long id);

    void deleteAll();

    boolean existsById(Long locationId);
}
