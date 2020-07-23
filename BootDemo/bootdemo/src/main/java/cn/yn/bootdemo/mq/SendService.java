package cn.yn.bootdemo.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendService {
//    @Autowired
//    private AmqpTemplate amqpTemplate;

    public  void send(){
//        amqpTemplate.convertAndSend("bootq","xxx message");
    }

}
