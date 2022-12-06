package com.ayildiz.citylist.controller;

/*
 * @author abdurrahman.yildiz
 * @created on 11/30/2022
 */

import com.ayildiz.citylist.model.CityDto;
import com.ayildiz.citylist.model.CityPatchDto;
import com.ayildiz.citylist.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping("{id}")
    public ResponseEntity<CityDto> getById(@PathVariable("id") Long id) {
        CityDto result = cityService.getById(id);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("all/{page}/{size}")
    public ResponseEntity<List<CityDto>> getAll(@PathVariable("page") int page,
                                          @PathVariable("size") int size) {

        List<CityDto> result = cityService.getAll(page, size);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("search/{name}")
    public ResponseEntity<List<CityDto>> findByName(@PathVariable("name") String name) {

        List<CityDto> result = cityService.findByName(name);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PatchMapping("{id}")
    public ResponseEntity<CityDto> updateCity(@PathVariable("id") Long id, @RequestBody CityPatchDto updatedCity) {

        CityDto result = cityService.update(id, updatedCity);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
