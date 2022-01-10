package cc.minetale.practice.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import net.minestom.server.item.Material;

import java.io.IOException;

public class MaterialSerializer extends StdSerializer<Material> {

    public MaterialSerializer() {
        this(null);
    }

    public MaterialSerializer(Class<Material> material) {
        super(material);
    }

    @Override
    public void serialize(Material value, JsonGenerator jGen, SerializerProvider provider) throws IOException {
        jGen.writeString(value.namespace().asString());
    }

}
