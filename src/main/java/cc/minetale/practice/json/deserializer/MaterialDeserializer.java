package cc.minetale.practice.json.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import net.minestom.server.item.Material;

import java.io.IOException;

public class MaterialDeserializer extends StdDeserializer<Material> {

    public MaterialDeserializer() {
        this(null);
    }

    public MaterialDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Material deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        return Material.fromNamespaceId(jsonParser.getCodec().readValue(jsonParser, String.class));
    }

}
