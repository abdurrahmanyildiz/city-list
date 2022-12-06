package com.ayildiz.citylist.exception;

/*
 * @author abdurrahman.yildiz
 * @created on 12/6/2022
 */

import javax.persistence.EntityNotFoundException;

public class CityNotFoundException extends EntityNotFoundException {
    private String message = "There is no city with id: ";

    public CityNotFoundException(Long id) {
        this.message += id.toString();
    }

    public String getMessage(){
        return message;
    }

}
