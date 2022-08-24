package tech.edyl.webfluxdemo.service;

import org.springframework.stereotype.Service;

@Service
public class SleepUtil {
    
    public static void sleepSeconds(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
