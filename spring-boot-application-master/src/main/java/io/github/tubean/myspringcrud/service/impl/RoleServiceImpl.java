package io.github.tubean.myspringcrud.service.impl;

import io.github.tubean.myspringcrud.entity.Role;
import io.github.tubean.myspringcrud.repository.RoleRepository;
import io.github.tubean.myspringcrud.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> getAllRole() {
        return (List<Role>) roleRepository.findAll();
    }
}
