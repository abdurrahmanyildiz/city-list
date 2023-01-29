package com.ayildiz.citylist.mapper;

import com.ayildiz.citylist.entity.City;
import com.ayildiz.citylist.model.CityDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/*
 * @author abdurrahman.yildiz
 * @created on 1/29/2023
 */
class CityMapperTest {

    @Test
    void mapDtoToCity() {
        Long id = 1L;
        String name = "My City";
        String url = "https://myurl.com";

        City city = new City().builder()
                .id(id)
                .name(name)
                .url(url)
                .build();

        CityDto dto = new CityDto(id, name, url);
        CityDto result = CityMapper.INSTANCE.cityToCityDto(city);

        assertEquals(dto.id(), result.id());
        assertEquals(dto.name(), result.name());
        assertEquals(dto.url(), result.url());
    }

    @Test
    void mapCityToDto() {
        Long id = 1L;
        String name = "My City";
        String url = "https://myurl.com";

        City city = new City().builder()
                .id(id)
                .name(name)
                .url(url)
                .build();

        CityDto dto = new CityDto(id, name, url);
        City result = CityMapper.INSTANCE.cityDtoToCity(dto);

        assertEquals(result.getId(), city.getId());
        assertEquals(result.getName(), city.getName());
        assertEquals(result.getUrl(), city.getUrl());
    }
}