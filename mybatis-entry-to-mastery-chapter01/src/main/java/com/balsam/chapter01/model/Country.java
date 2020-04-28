package com.balsam.chapter01.model;

import lombok.Data;

@Data
public class Country {
    private Integer id;
    private String countryName;
    private String countryCode;
}
