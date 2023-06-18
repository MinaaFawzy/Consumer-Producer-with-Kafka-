package com.example.project.SA2.springboot.services;

import com.example.project.SA2.springboot.model.Offer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServices {

    private final String topicName = "${topic.name}";
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerServices.class);

    @Autowired
    private DatabaseServices databaseServices;

    public ConsumerServices(DatabaseServices databaseServices) {
        this.databaseServices = databaseServices;
    }

    @KafkaListener(topics = topicName, groupId = "offersGroup")
    public void consumerOffer(Offer offer) {
        if (offer.getOperationType().equals("post")) {
            databaseServices.insertOffer(offer);
            LOGGER.info(String.format("New offer is received successfully from the kafka topic! -> %s", offer.toString()));
        } else if (offer.getOperationType().equals("delete")) {
            databaseServices.deleteAnOffer(offer.getId());
            LOGGER.info(String.format("Deleted offer is received successfully from the kafka topic! -> %s", offer.toString()));
        } else if (offer.getOperationType().equals("update")) {
            databaseServices.updateAnOffer(offer);
            LOGGER.info(String.format("Updated offer is received successfully from the kafka topic! -> %s", offer.toString()));
        }
    }
}
