package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaskForm {
    
    @NotBlank
    @Size(max=256)
    private String title;
    
    @NotBlank
    @Size(max=256)
    private String description;
}
