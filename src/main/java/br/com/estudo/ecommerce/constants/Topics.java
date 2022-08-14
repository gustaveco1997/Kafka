package br.com.estudo.ecommerce.constants;

public enum Topics {
    PATTERN_LOG("NOVO_.*"),
    NOVO_PEDIDO("NOVO_NOVO_PEDIDO"),

    NOVO_PEDIDO_OLD("NOVO_PEDIDO"),

    SEND_EMAIL("NOVO_PEDIDO_SEND_EMAIL");

    private final String value;

    Topics(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
