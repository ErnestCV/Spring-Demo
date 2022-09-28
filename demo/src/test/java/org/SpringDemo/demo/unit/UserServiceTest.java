package org.SpringDemo.demo.unit;

import org.SpringDemo.demo.dto.response.UserDTO;
import org.SpringDemo.demo.model.User;
import org.SpringDemo.demo.repository.UserRepository;
import org.SpringDemo.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Spy
    ModelMapper modelMapper;

    private User user1;
    private User user2;

    @BeforeEach
    public void setup() {
        user1 = User.builder().username("Ernest").password("12345678").email("ernest@email.com").build();
        user2 = User.builder().username("Joan").password("12345678").email("joan@email.com").build();
    }

    @Test
    public void givenUserList_whenGetUsers_thenReturnUserList() {

        //given
        given(userRepository.findAll()).willReturn(Arrays.asList(user1, user2));

        //when
        List<UserDTO> result = userService.getAllUsers();

        //then
        assertThat(result).isNotNull();
        assertThat(result).hasSize(2);
        assertThat(result).usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(Arrays.asList(user1, user2));
        verify(userRepository).findAll();
    }
}