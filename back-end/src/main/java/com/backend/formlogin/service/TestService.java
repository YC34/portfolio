package com.backend.formlogin.service;

import com.backend.formlogin.dto.TestDto;
import com.backend.formlogin.repository.TestMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService implements TestMapper {


    private TestMapper mapper;

    public TestService(TestMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<TestDto> findAll() {
        return mapper.findAll();
    }
}
