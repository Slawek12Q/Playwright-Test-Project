package org.example.mofule_6_rest.dto.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Company {

    public String name;
    public String catchPhrase;
    public String bs;
}
