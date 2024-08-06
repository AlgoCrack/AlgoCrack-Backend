package com.problem.vo;

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
public class TestCase {

    private String id;

    @NotEmpty(message = "testData can not be empty")
    private String testData;

    @Builder.Default
    private Date createdDate = new Date();

}
