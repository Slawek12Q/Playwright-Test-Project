package org.example.mofule_6_rest.dto.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    public String street;
    public String suite;
    public String city;
    public String zipcode;
    public Geo geo;
}