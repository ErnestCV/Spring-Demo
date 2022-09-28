package org.SpringDemo.demo.integration;

import org.SpringDemo.demo.config.Mapper;
import org.SpringDemo.demo.controller.UserController;
import org.SpringDemo.demo.model.User;
import org.SpringDemo.demo.repository.UserRepository;
import org.SpringDemo.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {UserService.class, Mapper.class, UserController.class})
@AutoConfigureMockMvc
public class UserControllerTest {

    @MockBean
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ModelMapper modelMapper;

    private User user1;
    private User user2;

    private static final String API_URL = "/api/v1/users";

    @BeforeEach
    public void setup() {
        user1 = User.builder().id("1").username("Ernest").password("12345678").email("ernest@email.com").build();
        user2 = User.builder().id("2").username("Joan").password("12345678").email("joan@email.com").build();
    }

    @Test
    public void shouldReturnUserList() throws Exception {

        //given
        given(userRepository.findAll()).willReturn(Arrays.asList(user1, user2));

        //then
        mockMvc.perform(get(API_URL + "/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andDo(print());
    }
}
