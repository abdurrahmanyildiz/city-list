package com.ayildiz.citylist.repo;

/*
 * @author abdurrahman.yildiz
 * @created on 11/30/2022
 */

import com.ayildiz.citylist.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findByNameContainingIgnoreCase(String name);
}
