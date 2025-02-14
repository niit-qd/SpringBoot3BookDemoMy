package org.example.test;

import lombok.extern.slf4j.Slf4j;
import org.example.jopo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@Slf4j
public class JsonTests {

    @Autowired
    private JacksonTester<User> userJacksonTester;

    @Test
    public void serialize() throws IOException {
        User user = new User();
        user.setId(100);
        user.setName("John");
        user.setPassword("123456");
        user.setActive(true);
        log.info(userJacksonTester.write(user).getJson());

        assertThat(userJacksonTester.write(user)).isEqualToJson("/user.json");


        assertThat(userJacksonTester.write(user)).extractingJsonPathNumberValue("@.id").isEqualTo(100);
        assertThat(userJacksonTester.write(user)).extractingJsonPathStringValue("@.name").isEqualTo("John");
        assertThat(userJacksonTester.write(user)).extractingJsonPathStringValue("@.password").isEqualTo("123456");
        assertThat(userJacksonTester.write(user)).extractingJsonPathBooleanValue("@.active").isEqualTo(true);
    }

    @Test
    public void deserialize() throws IOException {
        String json = "{\"id\":100,\"name\":\"John\",\"password\":\"123456\",\"active\":true}";
        User user = new User();
        user.setId(100);
        user.setName("John");
        user.setPassword("123456");
        user.setActive(true);
        log.info(userJacksonTester.write(user).getJson());

        assertThat(userJacksonTester.parseObject(json)).isEqualTo(user);
        assertThat(userJacksonTester.parseObject(json).getId()).isEqualTo(100);
        assertThat(userJacksonTester.parseObject(json).getName()).isEqualTo("John");
        assertThat(userJacksonTester.parseObject(json).getPassword()).isEqualTo("123456");
        assertThat(userJacksonTester.parseObject(json).getActive()).isEqualTo(true);
    }
}
