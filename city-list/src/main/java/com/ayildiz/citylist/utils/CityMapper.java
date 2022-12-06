package com.ayildiz.citylist.utils;

/*
 * @author abdurrahman.yildiz
 * @created on 11/30/2022
 */

import com.ayildiz.citylist.entity.City;
import com.ayildiz.citylist.model.CityDto;

import java.util.List;

public class CityMapper {

    public static City mapDtoToCity(CityDto dto){
        return new City().builder()
                .id(dto.id())
                .name(dto.name())
                .url(dto.url())
                .build();
    }

    public static CityDto mapCityToDto(City city){
        return new CityDto(city.getId(), city.getName(), city.getUrl());
    }

    public static List<City> mapCityDtoListToCityList(List<CityDto> dtoList){
        return dtoList.stream().map(CityMapper::mapDtoToCity).toList();
    }

    public static List<CityDto> mapCityListToDtoList(List<City> cityList){
        return cityList.stream().map(CityMapper::mapCityToDto).toList();
    }


}
