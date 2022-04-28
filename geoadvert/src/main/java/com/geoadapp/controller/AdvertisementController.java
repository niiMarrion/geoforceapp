package com.geoadapp.controller;

import com.geoadapp.model.Advertisement;
import com.geoadapp.service.AdvertisementService;
import com.geoadapp.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;


    @Autowired
    private LocationService locationService;

    @GetMapping("/advertisement/{latitude}/{longitude}")
    public ResponseEntity<List<Advertisement>> getAllAdvertisementByLatitudeAndLongitude(@PathVariable(value = "latitude")Double latitude, @PathVariable(value = "longitude")Double longitude){
        List<Advertisement> _advertisments = advertisementService.findByLatitudeAndLongitude(latitude, longitude);
        if (_advertisments.isEmpty()){
            throw new ResourceNotFoundException("No advertisements found ");
        }
        return new ResponseEntity<>(_advertisments, HttpStatus.OK);
    }

    @GetMapping("/advertisement/{id}")
    public ResponseEntity<HttpStatus> findAdvertisement(@PathVariable("id") long id) {
        advertisementService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping("/advertisement/{id}")
    public ResponseEntity<HttpStatus> deleteAdvertisement(@PathVariable("id") long id) {
        advertisementService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/location/{locationId}/advertisement")
    public ResponseEntity<List<Advertisement>> deleteAllAdvertisementOfLocation(@PathVariable(value = "locationId") Long locationId) {
        if (!locationService.existsById(locationId)) {
            throw new ResourceNotFoundException("Location not found  with id = " + locationId);
        }
        advertisementService.deleteByLocationId(locationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/advertisement/{id}")
    public ResponseEntity<Advertisement> updateComment(@PathVariable("id") long id, @RequestBody Advertisement advertisement) {
        Advertisement _advertisement1 = advertisementService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Advertisement with  " + id + "not found"));
        advertisement.setHref(advertisement.getHref());
        return new ResponseEntity<>(advertisementService.save(_advertisement1), HttpStatus.OK);
    }

    @PostMapping("/location/{locationId}/advertisement")
    public ResponseEntity<Advertisement> createAdvertisement(@PathVariable(value = "locationId") Long locationId,
                                                 @RequestBody Advertisement advertisement) {
        Advertisement _advert = locationService.findById(locationId).map(location -> {
            advertisement.setLocation(location);

            // calculate distance
            double lat = Math.toRadians(location.getLatitude());
           double lon = Math.toRadians(location.getLongitude());

            double a = Math.pow(Math.sin(lat / 2), 2) + Math.pow(Math.sin(lon / 2), 2) * Math.cos(lat) * Math.cos(lon);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            double dist = 6371 * c;
            advertisement.setDistance(dist);
            advertisement.setActivated(false);
            return advertisementService.save(advertisement);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found Advert with id = " + locationId));
        return new ResponseEntity<>(_advert, HttpStatus.CREATED);
    }

}
