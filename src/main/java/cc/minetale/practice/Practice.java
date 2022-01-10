package cc.minetale.practice;

import cc.minetale.magma.MagmaLoader;
import cc.minetale.magma.MagmaUtils;
import cc.minetale.practice.command.KitCommand;
import cc.minetale.practice.json.deserializer.EnchantmentDeserializer;
import cc.minetale.practice.json.deserializer.MaterialDeserializer;
import cc.minetale.practice.json.serializer.EnchantmentSerializer;
import cc.minetale.practice.json.serializer.MaterialSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.GameMode;
import net.minestom.server.event.EventFilter;
import net.minestom.server.event.EventNode;
import net.minestom.server.event.player.PlayerLoginEvent;
import net.minestom.server.event.player.PlayerSpawnEvent;
import net.minestom.server.extensions.Extension;
import net.minestom.server.item.Enchantment;
import net.minestom.server.item.Material;

public class Practice extends Extension {

    public static ObjectMapper mapper;

    @Override
    public void initialize() {
        MinecraftServer.getCommandManager().register(new KitCommand());

        mapper = new ObjectMapper()
                .registerModule(new SimpleModule()
                        .addSerializer(Material.class, new MaterialSerializer())
                        .addDeserializer(Material.class, new MaterialDeserializer())
                        .addSerializer(Enchantment.class, new EnchantmentSerializer())
                        .addDeserializer(Enchantment.class, new EnchantmentDeserializer())
                )
                .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        var instance = MinecraftServer.getInstanceManager().createInstanceContainer();

        MagmaLoader.create(MagmaUtils.getDefaultLocation("Lobby"))
                .thenAccept(instance::setChunkLoader);

        MinecraftServer.getGlobalEventHandler().addChild(
                EventNode.type("practice", EventFilter.PLAYER)
                        .addListener(PlayerLoginEvent.class, event -> {
                            event.setSpawningInstance(instance);
                        })
                        .addListener(PlayerSpawnEvent.class, event -> {
                            var player = event.getPlayer();
                            player.setFlying(true);
                            player.teleport(new Pos(0, 100, 0));
                            player.setGameMode(GameMode.CREATIVE);
                        })
        );
    }

    @Override
    public void terminate() {}


    //        try {
//            var enchantMap = new HashMap<Enchantment, Short>();
//            enchantMap.put(Enchantment.SHARPNESS, (short) 5);
//            enchantMap.put(Enchantment.UNBREAKING, (short) 3);
//
//            var kitTest1 = new Kit(
//                    "Test",
//                    Arrays.asList(new KitItem(0, Material.DIAMOND_SWORD, 1, 0, enchantMap))
//            );
//
//            var kitTest2 = new Kit();
//
//            System.out.println(mapper.writeValueAsString(kitTest1));
//            System.out.println(mapper.writeValueAsString(kitTest2));
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }

}
