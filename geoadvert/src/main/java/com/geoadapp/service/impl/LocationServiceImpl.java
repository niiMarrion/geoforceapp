package com.geoadapp.service.impl;

import com.geoadapp.model.Location;
import com.geoadapp.repository.LocationRepository;
import com.geoadapp.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void delete(Location location) {
        locationRepository.delete(location);
    }

    @Override
    public Location update(Location location) {
        return locationRepository.saveAndFlush(location);
    }

    @Override
    public Optional<Location> findById(Long id) {
        return locationRepository.findById(id);
    }

    @Override
    public Location findByLatitudeAndLongitude(Double Latitude, Double Longitude) {
        return locationRepository.findByLatitudeAndLongitude(Latitude, Longitude);
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        locationRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        locationRepository.deleteAll();
    }

    @Override
    public boolean existsById(Long locationId) {
        return locationRepository.findById(locationId).isPresent();
    }
}
