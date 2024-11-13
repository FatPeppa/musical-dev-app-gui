package org.olesya.musicaldevapp.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Analytics {
    private UUID requirementId;
    private UUID projectId;
    private UUID requirementTypeId;
    private File requirementContent;
    private LocalDate createDate;
    private LocalDate lastChangeDate;
    private String fileExtension;
}
