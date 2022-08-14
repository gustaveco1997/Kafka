package br.com.estudo.ecommerce;

import br.com.estudo.ecommerce.config.ConsumerKafkaConfig;
import br.com.estudo.ecommerce.constants.Topics;
import br.com.estudo.ecommerce.entities.Order;
import br.com.estudo.ecommerce.util.Listener;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;

public class FraudeDetectorService {
    public static void main(String[] args) {
        var consumer = new KafkaConsumer<String, String>(ConsumerKafkaConfig.properties(FraudeDetectorService.class.getName(), Order.class));
        consumer.subscribe(Collections.singletonList(Topics.NOVO_PEDIDO.getValue()));

        new Listener().createListener(consumer, "Fraude");
    }
}
