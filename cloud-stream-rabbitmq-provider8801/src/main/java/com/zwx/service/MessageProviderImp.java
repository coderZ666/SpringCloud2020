package com.zwx.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author coderZWX
 * @date 2020-12-23 16:07
 */
@EnableBinding(Source.class) //消息生产者消息驱动绑定，定义消息的推送管道
public class MessageProviderImp implements MessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("serial:"+serial);
        return "发送成功：流水号——"+serial;
    }

}
