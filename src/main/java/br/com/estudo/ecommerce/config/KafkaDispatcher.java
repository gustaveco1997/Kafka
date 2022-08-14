package br.com.estudo.ecommerce.config;

import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Properties;

public class KafkaDispatcher<T> extends KafkaProducer<String, T>{

    public KafkaDispatcher(Properties properties) {
        super(properties);
    }

}
