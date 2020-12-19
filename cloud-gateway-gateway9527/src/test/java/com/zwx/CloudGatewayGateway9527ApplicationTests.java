package com.zwx;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

@SpringBootTest
class CloudGatewayGateway9527ApplicationTests {

    @Test
    void contextLoads() {

        ZonedDateTime zbj = ZonedDateTime.now();//默认时区
        System.out.println(zbj);

        // 2020-12-14T16:33:14.331+08:00[Asia/Shanghai]

    }

}
