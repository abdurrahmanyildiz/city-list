package com.ayildiz.citylist.mapper;

import com.ayildiz.citylist.entity.City;
import com.ayildiz.citylist.model.CityDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/*
 * @author abdurrahman.yildiz
 * @created on 1/29/2023
 */

@Mapper
public interface CityMapper {

    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    CityDto cityToCityDto(City city);
    City cityDtoToCity(CityDto cityDto);
    List<CityDto> cityListToCityDtoList(List<City> cityList);
    List<City> cityDtoListToCityList(List<CityDto> cityDtoList);
}
