package com.geoadapp.service;

import com.geoadapp.model.Advertisement;
import com.geoadapp.model.Location;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface AdvertisementService {

     Optional<Advertisement> findById(long id);

    Advertisement save(Advertisement advertisement);

    void delete(Advertisement advertisement);

    List<Advertisement> findAll();

    List<Advertisement> findByLatitudeAndLongitude(Double latitude, Double longitude);

    Advertisement update(Advertisement advertisement);

    Optional<Advertisement> finAdvertisement(Location location);


    void deleteById(long id);

    void deleteByLocationId(Long locationId);
}
