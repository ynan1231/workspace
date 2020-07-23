package cn.yn.bootdemo.mq;

import org.springframework.stereotype.Component;

@Component
//@RabbitListener(queues = "bootq")
public class CousmerService {
//    @RabbitHandler
    public void recive(String msg){
        System.out.println("------------"+msg);
    }
}
