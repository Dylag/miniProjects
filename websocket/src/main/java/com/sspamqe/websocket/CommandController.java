package com.sspamqe.websocket;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommandController {

    @SendTo("/commandThread")
    public Command sendCommand(@RequestParam String command){
        return new Command(command);
    }


}
