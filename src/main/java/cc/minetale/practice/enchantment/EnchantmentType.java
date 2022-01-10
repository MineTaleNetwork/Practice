package cc.minetale.practice.enchantment;

import net.minestom.server.item.Enchantment;
import net.minestom.server.item.Material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnchantmentType {

    private static final List<Enchantment> BASE_ENCHANTMENTS = Arrays.asList(
       Enchantment.UNBREAKING,
       Enchantment.VANISHING_CURSE,
       Enchantment.MENDING
    );

    private static final List<Enchantment> ARMOR_ENCHANTMENTS = Arrays.asList(
            Enchantment.PROTECTION,
            Enchantment.FIRE_PROTECTION,
            Enchantment.BLAST_PROTECTION,
            Enchantment.PROJECTILE_PROTECTION,
            Enchantment.THORNS,
            Enchantment.BINDING_CURSE
    );

    private static final List<Enchantment> HELMET_ENCHANTMENTS = Arrays.asList(
            Enchantment.RESPIRATION,
            Enchantment.AQUA_AFFINITY
    );

    private static final List<Enchantment> BOOT_ENCHANTMENTS = Arrays.asList(
            Enchantment.FEATHER_FALLING,
            Enchantment.DEPTH_STRIDER,
            Enchantment.FROST_WALKER,
            Enchantment.SOUL_SPEED
    );

    private static final List<Enchantment> SWORD_ENCHANTMENTS = Arrays.asList(
            Enchantment.SWEEPING
    );

    private static final List<Enchantment> WEAPON_ENCHANTMENTS = Arrays.asList(
            Enchantment.SHARPNESS,
            Enchantment.KNOCKBACK,
            Enchantment.FIRE_ASPECT
    );

    private static final List<Enchantment> TOOL_ENCHANTMENTS = Arrays.asList(
            Enchantment.EFFICIENCY,
            Enchantment.SILK_TOUCH,
            Enchantment.FORTUNE
    );

    private static final List<Enchantment> BOW_ENCHANTMENTS = Arrays.asList(
            Enchantment.POWER,
            Enchantment.PUNCH,
            Enchantment.FLAME,
            Enchantment.INFINITY
    );

    private static final List<Enchantment> CROSSBOW_ENCHANTMENTS = Arrays.asList(
            Enchantment.MULTISHOT,
            Enchantment.QUICK_CHARGE,
            Enchantment.PIERCING
    );

    private static final List<Enchantment> TRIDENT_ENCHANTMENTS = Arrays.asList(
            Enchantment.LOYALTY,
            Enchantment.IMPALING,
            Enchantment.RIPTIDE,
            Enchantment.CHANNELING
    );

    private static final List<Material> BASE_MATERIALS = Arrays.asList(
            Material.ELYTRA,
            Material.CARVED_PUMPKIN
    );

    private static final List<Material> ARMOR_MATERIALS = Arrays.asList(
            Material.LEATHER_HELMET,
            Material.LEATHER_CHESTPLATE,
            Material.LEATHER_LEGGINGS,
            Material.LEATHER_BOOTS,
            Material.GOLDEN_HELMET,
            Material.GOLDEN_CHESTPLATE,
            Material.GOLDEN_LEGGINGS,
            Material.GOLDEN_BOOTS,
            Material.CHAINMAIL_HELMET,
            Material.CHAINMAIL_CHESTPLATE,
            Material.CHAINMAIL_LEGGINGS,
            Material.CHAINMAIL_BOOTS,
            Material.IRON_HELMET,
            Material.IRON_CHESTPLATE,
            Material.IRON_LEGGINGS,
            Material.IRON_BOOTS,
            Material.DIAMOND_HELMET,
            Material.DIAMOND_CHESTPLATE,
            Material.DIAMOND_LEGGINGS,
            Material.DIAMOND_BOOTS,
            Material.NETHERITE_HELMET,
            Material.NETHERITE_CHESTPLATE,
            Material.NETHERITE_LEGGINGS,
            Material.NETHERITE_BOOTS,
            Material.TURTLE_HELMET,
            Material.ELYTRA
    );

    private static final List<Material> HELMET_MATERIALS = Arrays.asList(
            Material.LEATHER_HELMET,
            Material.GOLDEN_HELMET,
            Material.CHAINMAIL_HELMET,
            Material.IRON_HELMET,
            Material.DIAMOND_HELMET,
            Material.NETHERITE_HELMET,
            Material.TURTLE_HELMET
    );

    private static final List<Material> BOOT_MATERIALS = Arrays.asList(
            Material.LEATHER_BOOTS,
            Material.GOLDEN_BOOTS,
            Material.CHAINMAIL_BOOTS,
            Material.IRON_BOOTS,
            Material.DIAMOND_BOOTS,
            Material.NETHERITE_BOOTS
    );

    private static final List<Material> SWORD_MATERIALS = Arrays.asList(
            Material.WOODEN_SWORD,
            Material.STONE_SWORD,
            Material.GOLDEN_SWORD,
            Material.IRON_SWORD,
            Material.DIAMOND_SWORD,
            Material.NETHERITE_SWORD
    );

    private static final List<Material> AXE_MATERIALS = Arrays.asList(
            Material.WOODEN_AXE,
            Material.STONE_AXE,
            Material.GOLDEN_AXE,
            Material.IRON_AXE,
            Material.DIAMOND_AXE,
            Material.NETHERITE_AXE
    );

    private static final List<Material> TOOL_MATERIALS = Arrays.asList(
            Material.WOODEN_SHOVEL,
            Material.WOODEN_PICKAXE,
            Material.WOODEN_HOE,
            Material.STONE_SHOVEL,
            Material.STONE_PICKAXE,
            Material.STONE_HOE,
            Material.GOLDEN_SHOVEL,
            Material.GOLDEN_PICKAXE,
            Material.GOLDEN_HOE,
            Material.IRON_SHOVEL,
            Material.IRON_PICKAXE,
            Material.IRON_HOE,
            Material.DIAMOND_SHOVEL,
            Material.DIAMOND_PICKAXE,
            Material.DIAMOND_HOE,
            Material.NETHERITE_SHOVEL,
            Material.NETHERITE_PICKAXE,
            Material.NETHERITE_HOE
    );

    public static final List<Material> ENCHANTABLE_ITEMS = Stream.of(BASE_MATERIALS, ARMOR_MATERIALS, SWORD_MATERIALS, AXE_MATERIALS, TOOL_MATERIALS)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());

    public static boolean isEnchantable(Material material) {
        return ENCHANTABLE_ITEMS.contains(material);
    }

    public static List<Enchantment> getMaterialEnchantments(Material material) {
        var enchantments = new ArrayList<>(EnchantmentType.BASE_ENCHANTMENTS);

        if(BASE_MATERIALS.contains(material)) {
            return enchantments;
        }

        if(ARMOR_MATERIALS.contains(material)) {
            enchantments.addAll(ARMOR_ENCHANTMENTS);

            if(HELMET_MATERIALS.contains(material)) {
                enchantments.addAll(HELMET_ENCHANTMENTS);
            }

            if(BOOT_MATERIALS.contains(material)) {
                enchantments.addAll(BOOT_ENCHANTMENTS);
            }

            return enchantments;
        }

        if(SWORD_MATERIALS.contains(material) || AXE_MATERIALS.contains(material) ) {
            enchantments.addAll(WEAPON_ENCHANTMENTS);

            if(SWORD_MATERIALS.contains(material)) {
                enchantments.addAll(SWORD_ENCHANTMENTS);
            }

            return enchantments;
        }

        if(TOOL_MATERIALS.contains(material)) {
            enchantments.addAll(TOOL_ENCHANTMENTS);

            return enchantments;
        }

        if(material == Material.BOW) {
            enchantments.addAll(BOW_ENCHANTMENTS);

            return enchantments;
        }

        if(material == Material.CROSSBOW) {
            enchantments.addAll(CROSSBOW_ENCHANTMENTS);

            return enchantments;
        }

        if(material == Material.TRIDENT) {
            enchantments.addAll(TRIDENT_ENCHANTMENTS);

            return enchantments;
        }

        return enchantments;
    }

}
