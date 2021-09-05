package dev.patika.datatransferobject;

import dev.patika.entity.Course;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDTO {
    @ApiModelProperty(hidden = true)
    private Integer id;

    @ApiModelProperty(example = "Kemal")
    @NotBlank(message = "Name is mandatory")
    private String name;

    @ApiModelProperty(example = "pendik/İstanbul")
    @NotBlank
    private String address;

    @ApiModelProperty(example = "05314094411")
    @NotBlank
    private String phoneNumber;

    @ApiModelProperty(example = "[1,2]")
    @NotBlank
    private List<Integer> courseIdList;

}
