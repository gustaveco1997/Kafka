package br.com.estudo.ecommerce.models;

import java.math.BigDecimal;
import java.util.UUID;

public class Order {
    private UUID id;
    private BigDecimal total;
    private String formaPagamento;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", total=" + total +
                ", formaPagamento='" + formaPagamento + '\'' +
                '}';
    }
}
