package com.geoadapp.service.impl;

import com.geoadapp.model.Advertisement;
import com.geoadapp.model.Location;
import com.geoadapp.repository.AdvertisementRepository;
import com.geoadapp.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    AdvertisementRepository advertisementRepository;

    @Override
    public Optional<Advertisement> findById(long id) {
        Optional<Advertisement> advertisement = advertisementRepository.findById(id);
        if (advertisement.isPresent()){
        return advertisement;
        }
        return Optional.empty();
    }

    @Override
    public Advertisement save(Advertisement advertisement) {
        return advertisementRepository.save(advertisement);
    }

    @Override
    public void delete(Advertisement advertisement) {
         advertisementRepository.delete(advertisement);
    }

    @Override
    public List<Advertisement> findAll() {
        return advertisementRepository.findAll();
    }

    @Override
    public List<Advertisement> findByLatitudeAndLongitude(Double latitude, Double longitude) {
        return advertisementRepository.findAdvertisementByLocation_LatitudeAndLocation_Longitude(latitude, longitude);
    }

    @Override
    public Advertisement update(Advertisement advertisement) {
        return advertisementRepository.saveAndFlush(advertisement);
    }

    @Override
    public Optional<Advertisement> finAdvertisement(Location location) {
        return advertisementRepository.findById(location.getId());
    }

    @Override
    public void deleteById(long id) {
        advertisementRepository.deleteById(id);
    }

    @Override
    public void deleteByLocationId(Long locationId) {
            advertisementRepository.deleteByLocationId(locationId);
    }


}
