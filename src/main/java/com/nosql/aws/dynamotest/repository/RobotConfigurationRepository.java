package com.nosql.aws.dynamotest.repository;

import com.nosql.aws.dynamotest.model.entity.RobotConfiguration;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface RobotConfigurationRepository extends CrudRepository<RobotConfiguration, String> {

    List<RobotConfiguration> findAll();
}
