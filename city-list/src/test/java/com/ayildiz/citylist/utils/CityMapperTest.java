package com.ayildiz.citylist.utils;

import com.ayildiz.citylist.entity.City;
import com.ayildiz.citylist.model.CityDto;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;


/*
 * @author abdurrahman.yildiz
 * @created on 12/5/2022
 */
class CityMapperTest {

    @InjectMocks
    CityMapper underTest;

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
        CityDto result = CityMapper.mapCityToDto(city);

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
        City result = CityMapper.mapDtoToCity(dto);

        assertEquals(result.getId(), city.getId());
        assertEquals(result.getName(), city.getName());
        assertEquals(result.getUrl(), city.getUrl());
    }
}