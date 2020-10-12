package com.nosql.aws.dynamotest.controller;

import com.nosql.aws.dynamotest.model.dto.RobotConfigurationDTO;
import com.nosql.aws.dynamotest.model.entity.RobotConfiguration;
import com.nosql.aws.dynamotest.service.RobotConfigurationService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("Robot Configuration")
@RestController
@RequestMapping("/robot-configuration")
public class RobotConfigurationController {

    private final RobotConfigurationService service;
    private final ModelMapper mapper;

    public RobotConfigurationController(RobotConfigurationService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/save")
    public RobotConfigurationDTO insertIntoDynamoDB(@RequestBody RobotConfigurationDTO dto) {
        RobotConfiguration configuration = mapper.map(dto, RobotConfiguration.class);
        return  mapper.map(service.save(configuration), RobotConfigurationDTO.class);
    }
}
