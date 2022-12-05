package com.ayildiz.citylist.service;

import com.ayildiz.citylist.model.City;
import com.ayildiz.citylist.model.CityDto;
import com.ayildiz.citylist.repo.CityRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;


/*
 * @author abdurrahman.yildiz
 * @created on 12/5/2022
 */
@ExtendWith(MockitoExtension.class)
class CityServiceTest {

    @Mock
    CityRepository cityRepository;

    @InjectMocks
    CityService underTest;

    public Pair<City, CityDto> createMockCity() {
        Long id = 1L;
        String name = "My City";
        String url = "https://myurl.com";

        CityDto cityDto = new CityDto().builder()
                .id(id)
                .name(name)
                .url(url)
                .build();
        City city = new City().builder()
                .id(id)
                .name(name)
                .url(url)
                .build();

        return Pair.of(city, cityDto);
    }

    @Test
    @DisplayName("Should get city by id")
    void getById() {
        //Given
        Pair<City, CityDto> expected = createMockCity();
        //When
        Mockito.when(cityRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(expected.getFirst()));
        //Then
        assertEquals(expected.getSecond(), underTest.getById(1L));
    }

    @Test
    @DisplayName("Should get all cities")
    void getAll() {
        //Given
        Pair<City, CityDto> expected = createMockCity();
        //When
        Mockito.when(cityRepository.findAll(any(PageRequest.class))).thenReturn(new PageImpl<>(List.of(expected.getFirst())));
        //Then
        assertEquals(List.of(expected.getSecond()), underTest.getAll(0, 10));
    }

    @Test
    @DisplayName("Should get city by name")
    void findByName() {
        //Given
        Pair<City, CityDto> expected = createMockCity();
        //When
        Mockito.when(cityRepository.findByNameContainingIgnoreCase(any(String.class))).thenReturn(List.of(expected.getFirst()));
        //Then
        assertEquals(List.of(expected.getSecond()), underTest.findByName("My City"));
    }

    @Test
    @DisplayName("Should update city")
    void update() {
        //Given
        Pair<City, CityDto> expected = createMockCity();
        City updateRequest = new City().builder()
                .id(expected.getFirst().getId())
                .name("My Other City")
                .url(expected.getFirst().getUrl())
                .build();
        CityDto updated = new CityDto().builder()
                .id(expected.getFirst().getId())
                .name("My Other City")
                .url(expected.getFirst().getUrl())
                .build();


        //When
        Mockito.when(cityRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(expected.getFirst()));
        Mockito.when(cityRepository.save(any(City.class))).thenReturn(updateRequest);

        //Then
        assertEquals(updated, underTest.update(updated));

    }
}