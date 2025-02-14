package org.example.test;

import lombok.extern.log4j.Log4j2;
import org.example.response.ResponseResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Log4j2
public class MvcTests {

    @LocalServerPort
    private int port;

    @Test
    public void getName(@Autowired TestRestTemplate restTemplate) {
        log.info("port: {}", port);
        ParameterizedTypeReference<ResponseResult<String>> reference = new ParameterizedTypeReference<ResponseResult<String>>() {
        };
        String name = "ZhangSan";
        // String url = "http://localhost:" + port + "/controller/hello" + "?name={name}";
        String url = "/controller/hello" + "?name={name}";
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("name", name);
        ResponseEntity<ResponseResult<String>> response =
                // 使用get方法得到的错误值也是一个空的对象。
                restTemplate.exchange(url, HttpMethod.GET, null, reference, urlVariables);

        // 对于ResponseEntity，必须验证状态码。
        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
        ResponseResult<String> responseResult = response.getBody();
        log.info(response);
        assert responseResult != null;
        assertThat(responseResult.getCode()).isEqualTo(1);
        assertThat(responseResult.getMessage()).isEqualTo(name);
    }
}
