package br.com.estudo.ecommerce.util;

import br.com.estudo.ecommerce.entities.Email;
import br.com.estudo.ecommerce.entities.Order;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class FakeData {
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
    private static final Random random = new Random();

    private FakeData(){
    }

    public static Email email() {
        var timeText = LocalDateTime.now().format(timeFormatter);
        var dateText = LocalDateTime.now().format(dateFormatter);

        var email = new Email();
        email.setDestinatario(timeText + "@email.com");
        email.setTitle("Título do email: " + timeText);
        email.setMessage(timeText + " -- " + dateText);
        return email;
    }

    public static Order order() {
        var order = new Order();
        order.setId(UUID.randomUUID());
        order.setTotal(getValue());
        order.setFormaPagamento(getRandomPayment());
        return order;
    }

    private static BigDecimal getValue() {
        var randomNumber = random.nextDouble() * 1000;
        var decimal = BigDecimal.valueOf(randomNumber);
        return decimal.setScale(2, RoundingMode.CEILING);
    }

    private static String getRandomPayment() {
        var pagamentos = List.of("Dinheiro, Cartão, Cheque, Pix, Transferência");
        return pagamentos.get(random.nextInt(pagamentos.size()));
    }
}
