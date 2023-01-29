package com.ayildiz.citylist.entity;

/*
 * @author abdurrahman.yildiz
 * @created on 11/30/2022
 */

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="city")
public class City {
    @Id
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "url", length = 1000)
    private String url;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
