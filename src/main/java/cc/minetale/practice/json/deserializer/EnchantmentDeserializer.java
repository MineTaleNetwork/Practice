package cc.minetale.practice.json.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import net.minestom.server.item.Enchantment;

import java.io.IOException;

public class EnchantmentDeserializer extends StdDeserializer<Enchantment> {

    public EnchantmentDeserializer() {
        this(null);
    }

    public EnchantmentDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Enchantment deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        return Enchantment.fromNamespaceId(jsonParser.getCodec().readValue(jsonParser, String.class));
    }

}