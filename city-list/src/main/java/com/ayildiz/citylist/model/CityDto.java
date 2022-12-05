package com.ayildiz.citylist.model;

import lombok.*;

/*
 * @author abdurrahman.yildiz
 * @created on 11/30/2022
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class CityDto {
    private Long id;
    private String name;
    private String url;

}

