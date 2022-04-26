package com.geoadapp.controller;


import com.geoadapp.model.Location;
import com.geoadapp.repository.LocationRepository;
import com.geoadapp.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LocationController {

    @Autowired
    LocationService locationService;

    @GetMapping("/locations")
    public ResponseEntity<List<Location>> getAllLocations(){
        List<Location> locations = locationService.findAll();
        if (locations.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping("/locations/{id}")
    public ResponseEntity<Location> getTutorialById(@PathVariable("id") long id) {
        Location location = locationService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @PostMapping("/locations")
    public ResponseEntity<Location> createTutorial(@RequestBody Location location) {
        Location newLocation = new Location();
        newLocation.setLatitude(location.getLatitude());
        newLocation.setLongitude(location.getLongitude());
        newLocation.setRadius(location.getRadius());
        locationService.save(newLocation);
        return new ResponseEntity<>(newLocation, HttpStatus.CREATED);
    }

    @PutMapping("/locations/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable("id") long id, @RequestBody Location location) {
        Location _location = locationService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Location with id = " + id));
        _location.setLatitude(location.getLatitude());
        _location.setLongitude(location.getLongitude());
        _location.setRadius(location.getRadius());

        return new ResponseEntity<>(locationService.save(_location), HttpStatus.OK);
    }

    @DeleteMapping("/locations/{id}")
    public ResponseEntity<HttpStatus> deleteLocation(@PathVariable("id") long id) {
        locationService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/locations")
    public ResponseEntity<HttpStatus> deleteAllLocations() {
        locationService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
