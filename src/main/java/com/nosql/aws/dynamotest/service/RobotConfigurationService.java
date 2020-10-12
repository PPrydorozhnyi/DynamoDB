package com.nosql.aws.dynamotest.service;

import com.nosql.aws.dynamotest.model.entity.RobotConfiguration;
import com.nosql.aws.dynamotest.repository.RobotConfigurationRepository;
import org.springframework.stereotype.Service;

@Service
public class RobotConfigurationService {

    private final RobotConfigurationRepository repository;

    public RobotConfigurationService(RobotConfigurationRepository repository) {
        this.repository = repository;
    }

    public RobotConfiguration save(RobotConfiguration configuration) {
        return repository.save(configuration);
    }
}
