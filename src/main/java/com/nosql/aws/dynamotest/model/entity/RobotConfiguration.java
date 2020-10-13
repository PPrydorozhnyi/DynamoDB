package com.nosql.aws.dynamotest.model.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.UUID;

@DynamoDBTable(tableName = "robot_configurations")
public class RobotConfiguration {

    private UUID id;
    private String name;
    private String description;

    @DynamoDBHashKey
    @DynamoDBGeneratedUuid(DynamoDBAutoGenerateStrategy.CREATE)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @DynamoDBAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
