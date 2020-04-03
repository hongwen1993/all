package com.github.hongwen1993.zeromq.demo;

import org.zeromq.SocketType;
import org.zeromq.ZMQ;

import java.io.UnsupportedEncodingException;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2020/4/2
 * @since 1.0.0
 */
public class Server {

    public static void main(String[] args) throws UnsupportedEncodingException {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket responder = context.socket(SocketType.REP);
        responder.bind("tcp://*:5555");
        while (!Thread.currentThread().isInterrupted()) {
            byte[] request = responder.recv(0);
            System.out.println("Received" + new String(request, "UTF-8"));
            //Thread.sleep(1000);
            String reply = "10";
            responder.send(reply.getBytes(),0);
        }
        responder.close();
        context.term();
    }

}
