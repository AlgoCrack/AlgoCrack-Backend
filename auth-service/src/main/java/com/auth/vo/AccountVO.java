package com.auth.vo;

import java.math.BigInteger;
import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountVO {

    @NotEmpty(message = "id can not be empty")
    private BigInteger id;

    @NotEmpty(message = "name can not be empty")
    private String name;

    @NotEmpty(message = "givenName can not be empty")
    private String givenName;

    @NotEmpty(message = "familyName can not be empty")
    private String familyName;

    @NotEmpty(message = "picture can not be empty")
    private String picture;

    @NotEmpty(message = "email can not be empty")
    private String email;

    @NotEmpty(message = "createdDate can not be empty")
    private Date createdDate;
}
