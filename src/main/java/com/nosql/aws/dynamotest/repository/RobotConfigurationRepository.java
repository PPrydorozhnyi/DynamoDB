package com.nosql.aws.dynamotest.repository;

import com.nosql.aws.dynamotest.model.entity.RobotConfiguration;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface RobotConfigurationRepository extends CrudRepository<RobotConfiguration, Integer> {
}
