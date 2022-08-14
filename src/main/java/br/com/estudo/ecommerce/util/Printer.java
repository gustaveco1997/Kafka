package br.com.estudo.ecommerce.util;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class Printer {
    public static void waitLogs() {
        System.out.println("Esperando por registros: ");
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void print(String title, ConsumerRecord record) {
        System.out.println("\n------------");
        System.out.println(title);
        System.out.println(" * Key: " + record.key());
        System.out.println(" * Value: " + record.value());
        System.out.println(" * Partition: " + record.partition());
        System.out.println(" * Offset: " + record.offset());
    }
}
