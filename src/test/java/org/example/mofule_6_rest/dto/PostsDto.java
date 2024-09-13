package org.example.mofule_6_rest.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PostsDto {

    int userID;
    int id;
    String title;
    String body;
}
