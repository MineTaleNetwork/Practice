package cc.minetale.practice.menu.armor;

import cc.minetale.mlib.canvas.*;
import cc.minetale.mlib.util.SoundsUtil;
import cc.minetale.practice.menu.KitEditorMenu;
import cc.minetale.practice.kit.Kit;
import cc.minetale.practice.kit.KitItem;
import cc.minetale.practice.menu.KitMenu;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextDecoration;
import net.minestom.server.entity.Player;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;

public class ArmorMenu extends KitMenu {

    // new Material[] { Material.LEATHER_HELMET, Material.GOLDEN_HELMET, Material.CHAINMAIL_HELMET, Material.TURTLE_HELMET, Material.IRON_HELMET, Material.DIAMOND_HELMET, Material.NETHERITE_HELMET, Material.CARVED_PUMPKIN }
    // new Material[] { Material.LEATHER_CHESTPLATE, Material.GOLDEN_CHESTPLATE, Material.CHAINMAIL_CHESTPLATE, Material.IRON_CHESTPLATE, Material.DIAMOND_CHESTPLATE, Material.NETHERITE_CHESTPLATE, Material.ELYTRA }
    // new Material[] { Material.LEATHER_LEGGINGS, Material.GOLDEN_LEGGINGS, Material.CHAINMAIL_LEGGINGS, Material.IRON_LEGGINGS, Material.DIAMOND_LEGGINGS, Material.NETHERITE_LEGGINGS }
    // new Material[] { Material.LEATHER_BOOTS, Material.GOLDEN_BOOTS, Material.CHAINMAIL_BOOTS, Material.IRON_BOOTS, Material.DIAMOND_BOOTS, Material.NETHERITE_BOOTS }

    public ArmorMenu(Player player, Kit kit, SlotType type) {
        super(kit, player, Component.text("Armor Selection"), CanvasType.FOUR_ROW);

//        setFiller(FillingType.BORDER);
//
//        setFragment(31, Fragment.of(ItemStack.of(Material.ARROW)
//                        .withDisplayName(Component.text("Back",
//                                Style.style(NamedTextColor.GRAY, TextDecoration.ITALIC.as(false)))),
//                event -> {
//                    this.click();
//                }));
//
//        var pagination = new Pagination(10, 14, false);
//        var fragments = new Fragment[type.getItems().length + 1];
//
//        fragments[0] = Fragment.of(ItemStack.of(Material.BARRIER)
//                        .withDisplayName(Component.text("None",
//                                Style.style(NamedTextColor.GRAY, TextDecoration.ITALIC.as(false)))),
//                event -> {
//                    kit.getArmor()[type.getSlot()] = null;
//                    this.click();
//                });
//
//        int i = 1;
//
//        for (var material : type.getItems()) {
//            fragments[i] = Fragment.of(ItemStack.of(material),
//                    event -> {
//                        kit.getArmor()[type.getSlot()] = new KitItem(material);
//
//                        this.click();
//                    });
//
//            i++;
//        }
//
//        pagination.setFragments(fragments);
//        setPagination(pagination);
//
//        openMenu();
    }

    private void click() {
//        SoundsUtil.playClickSound(this.player);
//        new KitEditorMenu(this.player, this.kit);
    }

    @Override
    public void close() {}

}
