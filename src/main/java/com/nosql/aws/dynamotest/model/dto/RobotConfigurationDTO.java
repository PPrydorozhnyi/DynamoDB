package com.nosql.aws.dynamotest.model.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class RobotConfigurationDTO {

    private UUID id;
    private String name;
    private String description;

}
