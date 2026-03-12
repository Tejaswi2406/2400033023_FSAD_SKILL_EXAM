package com.klef.fsad.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringBootHqlDemoApplication implements CommandLineRunner {

    @Autowired
    private TransportRepository transportRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHqlDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        transportRepository.save(new Transport("Bus", new Date(), "Available"));
        transportRepository.save(new Transport("Train", new Date(), "Delayed"));
        transportRepository.save(new Transport("Flight", new Date(), "Scheduled"));

        List<Transport> list = transportRepository.findAll();

        System.out.println("Transport Records:");

        for (Transport t : list) {
            System.out.println(t.getId() + " " + t.getName() + " " + t.getDate() + " " + t.getStatus());
        }
    }
}