package br.com.estudo.ecommerce.util;

import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;

public class Listener {
    public void createListener(KafkaConsumer<String, String> consumer, String serviceName) {
        Printer.print("Listener " + serviceName + " criado");

        while (true) {
            var records = consumer.poll(Duration.ofMillis(100));
            if (!records.isEmpty()) {
                Printer.print(serviceName + " encontrados");
            } else {
                continue;
            }

            for (var registro : records) {
                Printer.print("Processando " + serviceName, registro);
            }
        }
    }
}
