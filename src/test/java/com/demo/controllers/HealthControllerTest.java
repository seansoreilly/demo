package com.demo.controllers;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HealthController.class)
public class HealthControllerTest implements ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Override
    public MockMvc getMockMvc() {
        return mockMvc;
    }

    @TestFactory
    Stream<DynamicTest> dynamicHealthCheckTests() {
        return Stream.of("/api/health", "/api/healthcheck")
                .map(url -> DynamicTest.dynamicTest("Testing " + url, () -> {
                    mockMvc.perform(get(url))
                            .andExpect(status().isOk())
                            .andExpect(content().string("Service is running"));
                }));
    }

    @Nested
    class HealthCheckTests {

        @ParameterizedTest
        @ValueSource(strings = {"/api/health"})
        void healthCheck_ShouldReturnServiceIsRunning(String url) throws Exception {
            mockMvc.perform(get(url))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Service is running"));
        }
    }
}
