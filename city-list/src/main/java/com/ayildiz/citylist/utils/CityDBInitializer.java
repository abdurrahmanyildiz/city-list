package com.ayildiz.citylist.utils;

/*
 * @author abdurrahman.yildiz
 * @created on 11/30/2022
 */

import com.ayildiz.citylist.model.CityDto;
import com.ayildiz.citylist.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

@Component
public class CityDBInitializer {

    Logger logger = LoggerFactory.getLogger(CityDBInitializer.class);
    private final Charset CHARSET_UTF8 = Charset.forName("UTF-8");

    private final CityService cityService;
    ResourceLoader resourceLoader;

    public CityDBInitializer(ResourceLoader resourceLoader, CityService cityService) {
        this.resourceLoader = resourceLoader;
        this.cityService = cityService;
    }


    @PostConstruct
    public void getCityDataFromResource() {
        Resource resource = resourceLoader.getResource("classpath:static/cities.csv");
        if (resource.exists()) {
            try {
                BufferedReader buffer = new BufferedReader(new InputStreamReader(resource.getInputStream(), CHARSET_UTF8));
                String[] cityListStream = readAll(buffer);

                List<CityDto> importCityList = Arrays.stream(cityListStream)
                        .skip(1)
                        .map(CityDBInitializer::parseStreamToDto).toList();

                cityService.saveAll(importCityList);

                System.out.println(importCityList);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            logger.info("Cities are loaded from static file.");
        } else {
            logger.info("Could not find City Data.");
        }
    }

    public static CityDto parseStreamToDto(String lineOfCityStream) {
        String[] params = lineOfCityStream.split(",");
        return new CityDto(Long.parseLong(params[0]), params[1], params[2]);
    }

    private String[] readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString().split("\r\n");
    }
}
