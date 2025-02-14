package org.example.test;

import org.assertj.core.api.Assertions;
import org.example.service.MyService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;


@SpringBootTest
public class MockBeanTests {

    @MockBean
    MyService service1;

    @MockitoBean
    MyService service2;

    @MockitoSpyBean
    MyService service3;

    @Test
    public void testMockBean1() {
        String name = "John";
        BDDMockito.given(service1.sayHello(name)).willReturn("Hello " + name);
        Assertions.assertThat(service1.sayHello(name)).isEqualTo("Hello " + name);
    }

    @Test
    public void testMockBean2() {
        String name = "John";
        BDDMockito.given(service2.sayHello(name)).willReturn("Hello " + name);
        Assertions.assertThat(service2.sayHello(name)).isEqualTo("Hello " + name);
    }

    @Test
    public void testMockBean3() {
        String name = "John";
        BDDMockito.given(service3.sayHello(name)).willReturn("Hello " + name);
        Assertions.assertThat(service3.sayHello(name)).isEqualTo("Hello " + name);
    }
}
