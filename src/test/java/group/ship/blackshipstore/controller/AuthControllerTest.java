package group.ship.blackshipstore.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import group.ship.blackshipstore.dto.security.LoginDTO;
import group.ship.blackshipstore.dto.security.RegisterDTO;
import group.ship.blackshipstore.sevices.security.AuthenticationService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = AuthController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AuthenticationService authenticationService;

    private RegisterDTO registerDTO;

    private LoginDTO loginDTO;

    private final String successRegistrationAnswer = "User registered success";

    private final String unsuccessfulRegistrationAnswer = "Username is taken";


    @BeforeEach
    void setUp() {
        registerDTO = new RegisterDTO();
        registerDTO.setName("MockName");
        registerDTO.setUsername("MockUsername");
        registerDTO.setPassword("MockPassword");

        loginDTO = new LoginDTO();
        loginDTO.setUsername("MockUsername");
        loginDTO.setPassword("MockPassword");
    }

    @Test
    void register() throws Exception {
        Mockito.when(authenticationService.checkExist(registerDTO.getUsername())).thenReturn(false);
        Mockito.when(authenticationService.register(registerDTO)).thenReturn(true);
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(registerDTO)));

        Mockito.verify(authenticationService, Mockito.times(1))
                .checkExist(Mockito.any(String.class));
        response.andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().string(successRegistrationAnswer));
    }

    @Test
    void login() {
    }
}