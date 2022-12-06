package com.ayildiz.citylist.service;

/*
 * @author abdurrahman.yildiz
 * @created on 11/30/2022
 */

import com.ayildiz.citylist.entity.City;
import com.ayildiz.citylist.model.CityDto;
import com.ayildiz.citylist.model.CityPatchDto;
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

    public CityDto update(Long id, CityPatchDto updated) {
        City current = cityRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());

        if (!current.getName().equals(updated.name())) {
            current.setName(updated.name());
        }
        if (!current.getUrl().equals(updated.url())) {
            current.setUrl(updated.url());
        }

        return CityMapper.mapCityToDto(cityRepository.save(current));
    }

    public List<City> saveAll(List<CityDto> cityDto) {
        List<City> newCityList = CityMapper.mapCityDtoListToCityList(cityDto);
        return cityRepository.saveAll(newCityList);
    }


}
