package com.nosql.aws.dynamotest.controller;

import com.nosql.aws.dynamotest.model.dto.RobotConfigurationDTO;
import com.nosql.aws.dynamotest.model.entity.RobotConfiguration;
import com.nosql.aws.dynamotest.service.RobotConfigurationService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@Api("Robot Configuration")
@RestController
@RequestMapping("/robot-configuration")
public class RobotConfigurationController {

    public static final Type CONFIGURATION_LIST_TYPE = (new TypeToken<List<RobotConfigurationDTO>>() {
    }).getType();

    private final RobotConfigurationService service;
    private final ModelMapper mapper;

    public RobotConfigurationController(RobotConfigurationService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<RobotConfigurationDTO> getAll() {
        List<RobotConfiguration> all = service.getAll();
        return mapper.map(all, CONFIGURATION_LIST_TYPE);
    }

    @PostMapping("/save")
    public RobotConfigurationDTO insertIntoDynamoDB(@RequestBody RobotConfigurationDTO dto) {
        RobotConfiguration configuration = mapper.map(dto, RobotConfiguration.class);
        return  mapper.map(service.save(configuration), RobotConfigurationDTO.class);
    }
}
