package br.com.estudo.ecommerce.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class GsonDeserializer<T> implements Deserializer<T> {
    private final Gson gson = new GsonBuilder().create();
    public static final String TYPE_CONFIG = "DESERIALIZER_TYPE_CONFIG";
    private Class<T> type;

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        var typeName = String.valueOf(configs.get(TYPE_CONFIG));
        try {
            this.type = (Class<T>) Class.forName(typeName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Tipo de serializa��o inexistente");
        }
    }


    @Override
    public T deserialize(String s, byte[] bytes) {
        return gson.fromJson(new String(bytes), type);
    }
}
