package main.com.bundle.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Service
@Slf4j
@AllArgsConstructor
public class SocketListenerService {

    private RabbitTemplate rabbitTemplate;

    @Transactional
    public void listenToSocket() {
        ServerSocket serverSocket;
        Socket clientSocket;
        DataInputStream dataInputStream;
        String mesaj;
        try {
            serverSocket = new ServerSocket(1500);
            clientSocket = serverSocket.accept();
            dataInputStream = new DataInputStream(clientSocket.getInputStream());
            mesaj = dataInputStream.readUTF();
            String message = mesaj.substring(19, mesaj.length() - 2);
            if (Integer.parseInt(message) > 90) {
                rabbitTemplate.convertAndSend("bundleDataExchange", "ROUTING_KEY_BUNDLE_DATA", message);
            }

            serverSocket.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
