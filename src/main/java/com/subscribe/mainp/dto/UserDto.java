package com.subscribe.mainp.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDto {
    @NotNull(message = "Age is required")
    @Range(min = 1, max = 100)
    private int age;

    @NotEmpty
    @Size(min = 3,message="Name must be min of 3 characters")
    private String name;

    @NotEmpty
    @Size(min = 4,message="Username must be min of 4 characters")
    private String username;

    @Email(message="Email address is not valid")
    private String email;

    @NotEmpty
    @Size(min=3, max=10, message="Password must be in specified range")
    private String password;
}
