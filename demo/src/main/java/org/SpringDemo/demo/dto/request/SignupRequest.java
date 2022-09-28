package org.SpringDemo.demo.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class SignupRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    @NotBlank
    @Size(min = 8, max = 20)
    private String password;
    @NotBlank
    @Email
    @Size(min = 6, max = 50)
    private String email;
}
