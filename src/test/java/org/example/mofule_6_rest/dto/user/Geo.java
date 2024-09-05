package org.example.mofule_6_rest.dto.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Geo {

    public String lat;
    public String lng;

}