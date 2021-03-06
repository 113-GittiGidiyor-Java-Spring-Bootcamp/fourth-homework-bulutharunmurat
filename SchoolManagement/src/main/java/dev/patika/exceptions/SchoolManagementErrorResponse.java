package dev.patika.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolManagementErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}
