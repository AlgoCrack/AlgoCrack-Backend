package com.api.gateway.vo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelloRequestVO {

    @NotEmpty(message = "language can not be empty")
    private String language;

    @NotNull(message = "repeatTimes can not be empty")
    private Integer repeatTimes;
}
