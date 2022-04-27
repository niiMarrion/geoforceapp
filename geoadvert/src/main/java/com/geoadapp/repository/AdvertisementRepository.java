package com.geoadapp.repository;

import com.geoadapp.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    List<Advertisement> findAdvertisementByLocation_LatitudeAndLocation_Longitude(Double Latitude, Double Longitude);


    void deleteByLocationId(Long locationId);

    List<Advertisement> findByLocationId(Long locationId);
}
