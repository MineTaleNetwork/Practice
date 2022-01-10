package cc.minetale.practice.menu.category;

import cc.minetale.practice.menu.category.submenu.WeaponsSubmenu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextDecoration;
import net.minestom.server.item.ItemHideFlag;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;

@Getter @AllArgsConstructor
public enum CategoryType {

    ARMOR(
            ItemStack.of(Material.DIAMOND_CHESTPLATE)
                    .withDisplayName(Component.text("Armor", Style.style(NamedTextColor.YELLOW, TextDecoration.ITALIC.as(false))))
                    .withMeta(meta -> meta.hideFlag(ItemHideFlag.HIDE_ATTRIBUTES)),
            null
    ),
    WEAPONS(
            ItemStack.of(Material.IRON_SWORD)
                    .withDisplayName(Component.text("Weapons and Tools", Style.style(NamedTextColor.YELLOW, TextDecoration.ITALIC.as(false))))
                    .withMeta(meta -> meta.hideFlag(ItemHideFlag.HIDE_ATTRIBUTES)),
            WeaponsSubmenu.class
    ),
    PROJECTILES(
            ItemStack.of(Material.BOW)
                    .withDisplayName(Component.text("Projectiles", Style.style(NamedTextColor.YELLOW, TextDecoration.ITALIC.as(false))))
                    .withMeta(meta -> meta.hideFlag(ItemHideFlag.HIDE_ATTRIBUTES)),
            null
    ),
    POTIONS(
            ItemStack.of(Material.POTION)
                    .withDisplayName(Component.text("Potions", Style.style(NamedTextColor.YELLOW, TextDecoration.ITALIC.as(false))))
                    .withMeta(meta -> meta.hideFlag(ItemHideFlag.HIDE_POTION_EFFECTS)),
            null
    ),
    FOOD(
            ItemStack.of(Material.COOKED_BEEF)
                    .withDisplayName(Component.text("Food", Style.style(NamedTextColor.YELLOW, TextDecoration.ITALIC.as(false)))),
            null
    ),
    BLOCKS(
            ItemStack.of(Material.COBBLESTONE)
                    .withDisplayName(Component.text("Blocks", Style.style(NamedTextColor.YELLOW, TextDecoration.ITALIC.as(false)))),
            null
    ),
    MISC(
            ItemStack.of(Material.SADDLE)
                    .withDisplayName(Component.text("Miscellaneous", Style.style(NamedTextColor.YELLOW, TextDecoration.ITALIC.as(false)))),
            null
    );

    private final ItemStack icon;
    private final Class<?> menu;

}
