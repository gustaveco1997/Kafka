package br.com.estudo.ecommerce.util;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Printer {
    private static final Logger log = LoggerFactory.getLogger(Printer.class);

    private Printer(){
    }

    public static void waitLogs() {
        log.info("Esperando por registros: ");
    }

    public static void print(String message) {
        log.info(message);
    }

    public static void print(String title, ConsumerRecord<?, ?> record) {
        log.info("\n------------");
        log.info(title);
        log.info(" * Tópico: {}", record.topic());
        log.info(" * Key: {}", record.key());
        log.info(" * Value: {}", record.value());
        log.info(" * Partition: {}", record.partition());
        log.info(" * Offset: {}", record.offset());
    }
}
