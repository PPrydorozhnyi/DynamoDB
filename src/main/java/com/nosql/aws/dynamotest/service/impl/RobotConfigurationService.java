package com.nosql.aws.dynamotest.service.impl;

import com.nosql.aws.dynamotest.model.entity.RobotConfiguration;
import com.nosql.aws.dynamotest.repository.RobotConfigurationRepository;
import com.nosql.aws.dynamotest.service.AbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class RobotConfigurationService extends AbstractCrudService<RobotConfiguration, String> {

    public RobotConfigurationService(RobotConfigurationRepository repository) {
        super(repository);
    }
}
