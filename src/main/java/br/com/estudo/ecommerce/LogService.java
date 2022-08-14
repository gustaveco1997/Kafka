package br.com.estudo.ecommerce;

import br.com.estudo.ecommerce.config.ConsumerKafkaConfig;
import br.com.estudo.ecommerce.config.GsonDeserializer;
import br.com.estudo.ecommerce.constants.Topics;
import br.com.estudo.ecommerce.util.Listener;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.regex.Pattern;

public class LogService {
    public static void main(String[] args) {
        var properties = ConsumerKafkaConfig.properties(LogService.class.getName(), String.class);
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        var consumer = new KafkaConsumer<String, String>(properties);
        consumer.subscribe(Pattern.compile(Topics.PATTERN_LOG.getValue()));

        new Listener().createListener(consumer, "LOGS");
    }
}
