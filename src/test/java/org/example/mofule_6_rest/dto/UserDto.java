package org.example.mofule_6_rest.dto;


import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private int id;
    private String name;
    private String email;

    @SerializedName("username")
    private String userName;
}
