package dev.patika.datatransferobject;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    @ApiModelProperty(hidden = true)
    private Integer id;

    @ApiModelProperty(example = "CALCULUS")
    @NotBlank(message = "Name is mandatory")
    private String name;

    @ApiModelProperty(example = "MATH101")
    @NotBlank
    private String code;

    @ApiModelProperty(example = "5.5")
    @NotNull
    private Float creditScore;
}