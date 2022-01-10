package cc.minetale.practice.menu.enchantment;

import cc.minetale.mlib.canvas.*;
import cc.minetale.mlib.util.SoundsUtil;
import cc.minetale.practice.enchantment.EnchantmentType;
import cc.minetale.practice.kit.Kit;
import cc.minetale.practice.menu.KitEditorMenu;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextDecoration;
import net.minestom.server.entity.Player;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;

public class EnchantmentSelectionMenu extends Menu {

    public EnchantmentSelectionMenu(Player player, Kit kit, int slot) {
        super(player, Component.text("Enchantment Selection"), CanvasType.FOUR_ROW);

        var kitItem = kit.getInventory()[slot];

        setFiller(FillingType.BORDER);

        setFragment(4, Fragment.empty(kitItem.getItemStack()));

        setFragment(31, Fragment.of(ItemStack.of(Material.ARROW)
                        .withDisplayName(Component.text("Back",
                                Style.style(NamedTextColor.GRAY, TextDecoration.ITALIC.as(false)))),
                event -> {
                    SoundsUtil.playClickSound(player);

                    new KitEditorMenu(player, kit);
                }));

        var enchantments = EnchantmentType.getMaterialEnchantments(kitItem.getMaterial());

        var pagination = new Pagination(10, 14, false);
        var fragments = new Fragment[enchantments.size()];

        int i = 0;

        for (var enchantment : enchantments) {
            fragments[i] = Fragment.of(ItemStack.of(Material.ENCHANTED_BOOK)
                            .withDisplayName(Component.translatable(enchantment.registry().translationKey(),
                                    Style.style(NamedTextColor.YELLOW, TextDecoration.ITALIC.as(false)))),
                    event -> {
                        SoundsUtil.playClickSound(player);

                        if (enchantment.registry().maxLevel() == 1.0D) {
                            var itemEnchantments = kitItem.getEnchantments();

                            if(itemEnchantments.containsKey(enchantment)) {
                                itemEnchantments.remove(enchantment);
                            } else {
                                kitItem.getEnchantments().put(enchantment, (short) 1);
                            }

                            getInventory().setItemStack(4, kitItem.getItemStack());
                        } else {
                            new EnchantmentLevelMenu(player, kit, slot, enchantment);
                        }
                    });
            i++;
        }

        pagination.setFragments(fragments);
        setPagination(pagination);

        openMenu();
    }

}
