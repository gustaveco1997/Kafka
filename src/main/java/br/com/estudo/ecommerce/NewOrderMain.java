package br.com.estudo.ecommerce;

import br.com.estudo.ecommerce.config.KafkaDispatcher;
import br.com.estudo.ecommerce.constants.Topics;
import br.com.estudo.ecommerce.entities.Email;
import br.com.estudo.ecommerce.entities.Order;
import br.com.estudo.ecommerce.util.FakeData;
import br.com.estudo.ecommerce.util.Printer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Objects;
import java.util.concurrent.ExecutionException;

import static br.com.estudo.ecommerce.config.ProducerKafkaConfig.properties;

public class NewOrderMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var pedidoProducer = new KafkaDispatcher<Order>(properties());
        var emailProducer = new KafkaDispatcher<Email>(properties());

//        for (var i = 0; i < 30; i++) {
            var order = FakeData.order();
            var key = order.getId().toString();

            var emailRecord = new ProducerRecord<>(Topics.SEND_EMAIL.getValue(), key, FakeData.email());
            var pedidoRecord = new ProducerRecord<>(Topics.NOVO_PEDIDO.getValue(), key, order);

            emailProducer.send(emailRecord, getCallback()).get();
            pedidoProducer.send(pedidoRecord, getCallback()).get();
//        }
    }

    private static Callback getCallback() {
        return (data, ex) -> {
            boolean isSuccess = Objects.isNull(ex);
            if (!isSuccess) {
                ex.printStackTrace();
                return;
            }
            Printer.print(data.topic() + " - " + data.partition() + " - " + data.offset() + " - " + data.timestamp());
        };
    }
}
