package com.ayildiz.citylist.service;

/*
 * @author abdurrahman.yildiz
 * @created on 11/30/2022
 */

import com.ayildiz.citylist.model.City;
import com.ayildiz.citylist.model.CityDto;
import com.ayildiz.citylist.repo.CityRepository;
import com.ayildiz.citylist.utils.CityMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    public CityDto getById(Long id) {
        City result = cityRepository.findById(id).orElseThrow();
        return CityMapper.mapCityToDto(result);
    }

    public List<CityDto> getAll(int pageNumber, int pageSize) {
        PageRequest page = PageRequest.of(pageNumber, pageSize);
        return CityMapper.mapCityListToDtoList(cityRepository.findAll(page).toList());
    }

    public List<CityDto> findByName(String name) {
        return CityMapper.mapCityListToDtoList(cityRepository.findByNameContainingIgnoreCase(name));
    }

    public CityDto update(CityDto updated) {
        City current = cityRepository.findById(updated.getId()).orElseThrow(() -> new IllegalArgumentException());

        if (!current.getName().equals(updated.getName())) {
            current.setName(updated.getName());
        }
        if (!current.getUrl().equals(updated.getUrl())) {
            current.setUrl(updated.getUrl());
        }

        return CityMapper.mapCityToDto(cityRepository.save(current));
    }

    public List<City> saveAll(List<CityDto> cityDto) {
        List<City> newCityList = CityMapper.mapCityDtoListToCityList(cityDto);
        return cityRepository.saveAll(newCityList);
    }


}
