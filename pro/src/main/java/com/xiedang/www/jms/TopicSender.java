package com.xiedang.www.jms;

import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @author : 谢当
 * @date : 2018/11/6 16:52
 */
@Component
public class TopicSender {

    /*@Autowired
    private JmsTemplate jmsTemplate;*/

    /**
     * 发送信息
     * @param message
     */
    public void send(String message){
        /*jmsTemplate.send(session -> session.createTextMessage(message));*/
    }
}
