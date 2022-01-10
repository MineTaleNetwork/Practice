package cc.minetale.practice.menu.category.submenu;

import cc.minetale.mlib.canvas.CanvasType;
import cc.minetale.mlib.canvas.FillingType;
import cc.minetale.mlib.canvas.Fragment;
import cc.minetale.mlib.canvas.Menu;
import cc.minetale.mlib.util.SoundsUtil;
import cc.minetale.practice.kit.Kit;
import cc.minetale.practice.kit.KitItem;
import cc.minetale.practice.menu.KitEditorMenu;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextDecoration;
import net.minestom.server.entity.Player;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;

public class WeaponsSubmenu extends Menu {

    private final Player player;
    private final Kit kit;

    public WeaponsSubmenu(Player player, int slot, Kit kit) {
        super(player, Component.text("Weapons and Tools"), CanvasType.SIX_ROW);

        this.player = player;
        this.kit = kit;

        setFiller(FillingType.EMPTY_SLOTS);

        setFragment(53, Fragment.of(ItemStack.of(Material.ARROW)
                        .withDisplayName(Component.text("Back",
                                Style.style(NamedTextColor.GRAY, TextDecoration.ITALIC.as(false)))),
                event -> this.click()));

        int i = 0;

        Material[] materials = {
                Material.WOODEN_SWORD,   Material.GOLDEN_SWORD,   Material.STONE_SWORD,   Material.IRON_SWORD,   Material.DIAMOND_SWORD,   Material.NETHERITE_SWORD,   Material.SHIELD,            Material.TRIDENT,        Material.TOTEM_OF_UNDYING,
                Material.WOODEN_AXE,     Material.GOLDEN_AXE,     Material.STONE_AXE,     Material.IRON_AXE,     Material.DIAMOND_AXE,     Material.NETHERITE_AXE,     Material.FLINT_AND_STEEL,   Material.SHEARS,         Material.FISHING_ROD,
                Material.WOODEN_PICKAXE, Material.GOLDEN_PICKAXE, Material.STONE_PICKAXE, Material.IRON_PICKAXE, Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE, Material.BUCKET,            Material.WATER_BUCKET,   Material.LAVA_BUCKET,
                Material.WOODEN_SHOVEL,  Material.GOLDEN_SHOVEL,  Material.STONE_SHOVEL,  Material.IRON_SHOVEL,  Material.DIAMOND_SHOVEL,  Material.NETHERITE_SHOVEL,  Material.MILK_BUCKET,       Material.END_CRYSTAL,    Material.ENDER_PEARL,
                Material.WOODEN_HOE,     Material.GOLDEN_HOE,     Material.STONE_HOE,     Material.IRON_HOE,     Material.DIAMOND_HOE,  Material.NETHERITE_HOE,     Material.EXPERIENCE_BOTTLE, Material.RESPAWN_ANCHOR, Material.FIREWORK_ROCKET,
                Material.SNOWBALL,       Material.RED_BED,        Material.GLOWSTONE
        };

        for(var material : materials) {
            setFragment(i, Fragment.of(ItemStack.of(material), event -> {
                var item = kit.getInventory()[slot];

                if (item != null) {
                    item.setMaterial(material);
                } else {
                    kit.getInventory()[slot] = new KitItem(material);
                }

                this.click();
            }));

            i++;
        }

        openMenu();
    }

    private void click() {
        SoundsUtil.playClickSound(this.player);
        new KitEditorMenu(this.player, this.kit);
    }

    @Override
    public void close() {}

}
