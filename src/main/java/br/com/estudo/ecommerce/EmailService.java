package br.com.estudo.ecommerce;

import br.com.estudo.ecommerce.config.ConsumerKafkaConfig;
import br.com.estudo.ecommerce.constants.Topics;
import br.com.estudo.ecommerce.entities.Email;
import br.com.estudo.ecommerce.util.Listener;
import br.com.estudo.ecommerce.util.Printer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class EmailService {
    public static void main(String[] args) {
        var consumer = new KafkaConsumer<String, String>(ConsumerKafkaConfig.properties(EmailService.class.getName(), Email.class));
        consumer.subscribe(Collections.singletonList(Topics.SEND_EMAIL.getValue()));

        Printer.waitLogs();
        new Listener().createListener(consumer, "Email");
    }
}
