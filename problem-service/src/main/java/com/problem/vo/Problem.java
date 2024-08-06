package com.problem.vo;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Problem {

    private Integer id;

    @NotEmpty(message = "title can not be empty")
    private String title;

    @NotEmpty(message = "description can not be empty")
    private String description;

    @Builder.Default
    private Date createdDate = new Date();

    private BigInteger createdUserId;

    private List<TestCase> testCase;
}
