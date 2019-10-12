package io.github.tubean.myspringcrud.service.impl;

import io.github.tubean.myspringcrud.model.Object;
import io.github.tubean.myspringcrud.repository.ObjectRepository;
import io.github.tubean.myspringcrud.repository.RoleRepository;
import io.github.tubean.myspringcrud.service.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ObjectServiceImpl implements ObjectService {
    @Autowired
    private ObjectRepository objectRepository;
    @Override
    public List<Object> findInfor() {
        return objectRepository.findInformation();
    }
}
