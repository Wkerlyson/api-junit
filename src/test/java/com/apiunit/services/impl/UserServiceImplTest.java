package com.apiunit.services.impl;

import com.apiunit.domain.User;
import com.apiunit.domain.dto.UserDTO;
import com.apiunit.repositories.UserRepository;
import com.apiunit.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    public static final Integer ID      = 1;
    public static final String NAME     = "Wk";
    public static final String EMAIL    = "wk@gmail.com";
    public static final String PASSWORD = "123";
    public static final String OBJECT_NOT_FOUND = "Object not found";

    @InjectMocks
    private UserServiceImpl service;
    @Mock
    private UserRepository repository;
    @Mock
    private ModelMapper mapper;

    private User user;
    private UserDTO userDTO;
    private Optional<User> optionalUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.startUser();
    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() {
        when(repository.findById(anyInt())).thenReturn(optionalUser);

        User response = service.findById(ID);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
    }

    @Test
    void whenFindByIdThenReturnAnObjectNotFoundException(){
        when(repository.findById(anyInt())).thenThrow(new ObjectNotFoundException(OBJECT_NOT_FOUND));

        ObjectNotFoundException exception = assertThrows(ObjectNotFoundException.class, () -> service.findById(ID));
        assertEquals(OBJECT_NOT_FOUND, exception.getMessage());
    }

    @Test
    void findAll() {
    }

    private void startUser(){
        this.user = new User(ID, NAME, EMAIL, PASSWORD);
        this.userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
        this.optionalUser = Optional.of(new User(ID, NAME, EMAIL, PASSWORD));
    }
}