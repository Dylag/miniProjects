package com.sspamqe.websocket;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommandController {


    @MessageMapping("/command") //get from  /input/command
    @SendTo("/output/command") //send to channel /output/command
    public Command sendCommand(Command command){

        System.out.println("got command: " + command.getCommand());

        return new Command(command.getCommand());
    }
}