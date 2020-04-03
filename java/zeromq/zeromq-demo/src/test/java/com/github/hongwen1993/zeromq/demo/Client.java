package com.github.hongwen1993.zeromq.demo;

import org.zeromq.SocketType;
import org.zeromq.ZMQ;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2020/4/2
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket requester = context.socket(SocketType.REP);
        requester.connect("tcp://localhost:5555");
        String request = "cat";
        System.out.println("to cat");
        requester.send(request.getBytes(),0);
        requester.close();
        context.term();
    }

}
