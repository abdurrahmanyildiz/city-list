package com.ayildiz.citylist.utils;

/*
 * @author abdurrahman.yildiz
 * @created on 11/30/2022
 */

import com.ayildiz.citylist.model.City;
import com.ayildiz.citylist.model.CityDto;

import java.util.List;

public class CityMapper {

    public static City mapDtoToCity(CityDto dto){
        return new City().builder()
                .id(dto.getId())
                .name(dto.getName())
                .url(dto.getUrl())
                .build();
    }

    public static CityDto mapCityToDto(City city){
        return new CityDto().builder()
                .id(city.getId())
                .name(city.getName())
                .url(city.getUrl())
                .build();
    }

    public static List<City> mapCityDtoListToCityList(List<CityDto> dtoList){
        return dtoList.stream().map(CityMapper::mapDtoToCity).toList();
    }

    public static List<CityDto> mapCityListToDtoList(List<City> cityList){
        return cityList.stream().map(CityMapper::mapCityToDto).toList();
    }


}
