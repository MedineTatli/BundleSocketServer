package main.com.bundle.cron;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.com.bundle.service.SocketListenerService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class SocketListener {

    public SocketListenerService socketListenerService;

    @Scheduled(cron = "*/1 * * * * *")
    public void listenSocket() {
       // log.info("createRandomMessage() started...");
        socketListenerService.listenToSocket();
       // log.info("createRandomMessage() finished...");
    }

}
