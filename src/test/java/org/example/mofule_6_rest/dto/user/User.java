package org.example.mofule_6_rest.dto.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    public Integer id;
    public String name;
    public String username;
    public String email;
    public Address address;
    public String phone;
    public String website;
    public Company company;

}