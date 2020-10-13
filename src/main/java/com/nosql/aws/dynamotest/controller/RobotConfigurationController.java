package com.nosql.aws.dynamotest.controller;

import com.nosql.aws.dynamotest.model.dto.RobotConfigurationDTO;
import com.nosql.aws.dynamotest.model.entity.RobotConfiguration;
import com.nosql.aws.dynamotest.service.impl.RobotConfigurationService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@Slf4j
@Api(tags = {"Robot Configuration"})
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
        log.info("Get all robot configurations");
        List<RobotConfiguration> all = service.getAll();
        return mapper.map(all, CONFIGURATION_LIST_TYPE);
    }

    @GetMapping("/{id}")
    public RobotConfigurationDTO getById(@PathVariable String id) {
        log.info("Get robot configuration with id {}", id);
        final RobotConfiguration configuration = service.getById(id);
        return mapper.map(configuration, RobotConfigurationDTO.class);
    }

    @PostMapping("/create")
    public RobotConfigurationDTO create(@RequestBody RobotConfigurationDTO dto) {
        log.info("Create robot configuration");
        log.debug("Payload: {}", dto);
        final RobotConfiguration configuration = mapper.map(dto, RobotConfiguration.class);
        return mapper.map(service.save(configuration), RobotConfigurationDTO.class);
    }

    @PutMapping("/update")
    public RobotConfigurationDTO update(@RequestBody RobotConfigurationDTO dto) {
        log.info("Update robot configuration");
        log.debug("Payload: {}", dto);
        final RobotConfiguration configuration = mapper.map(dto, RobotConfiguration.class);
        return mapper.map(service.save(configuration), RobotConfigurationDTO.class);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable String id) {
        log.info("Delete robot configuration by id {}", id);
        service.delete(id);
    }
}
