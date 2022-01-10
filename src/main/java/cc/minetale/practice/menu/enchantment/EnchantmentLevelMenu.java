package cc.minetale.practice.menu.enchantment;

import cc.minetale.mlib.canvas.CanvasType;
import cc.minetale.mlib.canvas.FillingType;
import cc.minetale.mlib.canvas.Fragment;
import cc.minetale.mlib.canvas.Pagination;
import cc.minetale.mlib.util.SoundsUtil;
import cc.minetale.practice.kit.Kit;
import cc.minetale.practice.menu.KitMenu;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextDecoration;
import net.minestom.server.entity.Player;
import net.minestom.server.item.Enchantment;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;

public class EnchantmentLevelMenu extends KitMenu {

    public EnchantmentLevelMenu(Player player, Kit kit, int slot, Enchantment enchantment) {
        super(kit, player, Component.text("Enchantment Level"), CanvasType.THREE_ROW);

        var kitItem = kit.getInventory()[slot];

        setFiller(FillingType.BORDER);

        setFragment(4, Fragment.empty(kitItem.getItemStack()));

        setFragment(22, Fragment.of(ItemStack.of(Material.ARROW)
                        .withDisplayName(Component.text("Back",
                                Style.style(NamedTextColor.GRAY, TextDecoration.ITALIC.as(false)))),
                event -> {
                    SoundsUtil.playClickSound(player);

                    new EnchantmentSelectionMenu(player, kit, slot);
                }));

        var maxLevel = (int) enchantment.registry().maxLevel();
        var pagination = new Pagination(10, 7, false);
        var fragments = new Fragment[maxLevel];

        for (int i = 1; i <= maxLevel; i++) {
            var level = (short) i;

            fragments[i - 1] = Fragment.of(ItemStack.of(Material.ENCHANTED_BOOK, i)
                            .withDisplayName(Component.text().append(
                                    Component.translatable(enchantment.registry().translationKey()),
                                    Component.text(" " + i)
                            ).style(Style.style(NamedTextColor.YELLOW, TextDecoration.ITALIC.as(false))).build()),
                    event -> {
                        SoundsUtil.playClickSound(player);

                        var itemEnchantments = kitItem.getEnchantments();

                        if(itemEnchantments.containsKey(enchantment) && itemEnchantments.containsValue(level)) {
                            itemEnchantments.remove(enchantment);
                        } else {
                            itemEnchantments.put(enchantment, level);
                        }

                        new EnchantmentSelectionMenu(player, kit, slot);
                    });
        }

        pagination.setFragments(fragments);
        setPagination(pagination);

        openMenu();
    }

}
