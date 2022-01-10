package cc.minetale.practice.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import net.minestom.server.item.Enchantment;

import java.io.IOException;

public class EnchantmentSerializer extends StdSerializer<Enchantment> {

    public EnchantmentSerializer() {
        this(null);
    }

    public EnchantmentSerializer(Class<Enchantment> enchantment) {
        super(enchantment);
    }

    @Override
    public void serialize(Enchantment value, JsonGenerator jGen, SerializerProvider provider) throws IOException {
        jGen.writeString(value.namespace().asString());
    }

}
