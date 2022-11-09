package com.apiunit.resources;

import com.apiunit.domain.User;
import com.apiunit.domain.dto.UserDTO;
import com.apiunit.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    private UserService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){
        User user = service.findById(id);
        return ResponseEntity.ok().body(mapper.map(user, UserDTO.class));
    }
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return ResponseEntity.ok()
                .body(service.findAll().stream().map(u -> mapper.map(u, UserDTO.class)).collect(Collectors.toList()));
    }
}
