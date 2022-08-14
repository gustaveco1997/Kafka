package br.com.estudo.ecommerce;

import br.com.estudo.ecommerce.config.ConsumerKafkaConfig;
import br.com.estudo.ecommerce.constants.Topics;
import br.com.estudo.ecommerce.models.Email;
import br.com.estudo.ecommerce.util.Listener;
import br.com.estudo.ecommerce.util.Printer;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;

public class EmailService {
    public static void main(String[] args) {
        var consumer = new KafkaConsumer<String, String>(ConsumerKafkaConfig.properties(EmailService.class.getName(), Email.class));
        consumer.subscribe(Collections.singletonList(Topics.SEND_EMAIL.getValue()));

        Printer.waitLogs();
        new Listener().createListener(consumer, "Email");
    }
}
