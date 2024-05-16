package org.example.module_3;

import com.microsoft.playwright.Locator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Users {
    private String lastName;
    private String firstName;
    private String email;
    private String due;
    private String webSite;
    Locator action;
}
