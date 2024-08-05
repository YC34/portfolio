package com.backend.formlogin.repository;

import com.backend.formlogin.dto.TestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    List<TestDto> findAll();
}
