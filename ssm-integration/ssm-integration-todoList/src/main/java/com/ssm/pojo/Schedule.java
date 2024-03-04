package com.ssm.pojo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * ClassName:Schedule
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/3 20:00
 * @Version 1.0
 */
@Data
public class Schedule {

    private Integer id;
    @NotBlank
    private String title;
    @NotNull
    private Boolean completed;
}
