package com.ayildiz.citylist.service;

/*
 * @author abdurrahman.yildiz
 * @created on 11/30/2022
 */

import com.ayildiz.citylist.entity.City;
import com.ayildiz.citylist.exception.CityNotFoundException;
import com.ayildiz.citylist.mapper.CityMapper;
import com.ayildiz.citylist.model.CityDto;
import com.ayildiz.citylist.model.CityPatchDto;
import com.ayildiz.citylist.repo.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public CityDto getById(Long id) {
        City result = cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException(id));
        return CityMapper.INSTANCE.cityToCityDto(result);
    }

    public List<CityDto> getAll(int pageNumber, int pageSize) {
        PageRequest page = PageRequest.of(pageNumber, pageSize);
        return CityMapper.INSTANCE.cityListToCityDtoList(cityRepository.findAll(page).toList());
    }

    public List<CityDto> findByName(String name) {
        return CityMapper.INSTANCE.cityListToCityDtoList(cityRepository.findByNameContainingIgnoreCase(name));
    }

    public CityDto update(Long id, CityPatchDto updated) {
        City current = cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException(id));

        if (updated.name() != null && !current.getName().equals(updated.name())) {
            current.setName(updated.name());
        }
        if (!current.getUrl().equals(updated.url())) {
            current.setUrl(updated.url());
        }

        return CityMapper.INSTANCE.cityToCityDto(cityRepository.save(current));
    }

    public List<City> saveAll(List<CityDto> cityDtoList) {
        List<City> newCityList = CityMapper.INSTANCE.cityDtoListToCityList(cityDtoList);
        return cityRepository.saveAll(newCityList);
    }


}
