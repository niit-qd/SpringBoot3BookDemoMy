package org.example.test;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.assertj.core.matcher.AssertionMatcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
public class MyMockMvcTests {

    @Test
    public void testWithMockMvc(@Autowired MockMvc mvc) throws Exception {
        String uri = "/controller/hello" + "?name={name}";
        String name = "John";
        mvc.perform(get(uri, name))
                .andExpect(status().isOk())
                .andExpect(content().string(new AssertionMatcher<String>() {
                    @Override
                    public void assertion(String actual) throws AssertionError {
                        Assertions.assertThat(actual).contains("Hello " + name);
                    }
                }));
    }
}
