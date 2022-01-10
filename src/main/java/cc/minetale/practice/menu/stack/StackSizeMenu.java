package cc.minetale.practice.menu.stack;

import cc.minetale.mlib.canvas.CanvasType;
import cc.minetale.mlib.canvas.FillingType;
import cc.minetale.mlib.canvas.Fragment;
import cc.minetale.mlib.util.SoundsUtil;
import cc.minetale.practice.kit.Kit;
import cc.minetale.practice.menu.KitEditorMenu;
import cc.minetale.practice.menu.KitMenu;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextDecoration;
import net.minestom.server.entity.Player;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;

public class StackSizeMenu extends KitMenu {

    public StackSizeMenu(Player player, Kit kit, int slot) {
        super(kit, player, Component.text("Item Stack Size"), CanvasType.THREE_ROW);

        var kitItem = kit.getInventory()[slot];

        setFiller(FillingType.BORDER);

        setFragment(22, Fragment.of(ItemStack.of(Material.ARROW)
                        .withDisplayName(Component.text("Back",
                                Style.style(NamedTextColor.GRAY, TextDecoration.ITALIC.as(false)))),
                event -> {
                    SoundsUtil.playClickSound(player);

                    new KitEditorMenu(player, kit);
                }));

        setFragment(10, Fragment.of(ItemStack.of(kitItem.getMaterial(), 1),
                event -> {
                    SoundsUtil.playClickSound(player);
                    kitItem.setAmount(1);

                    new KitEditorMenu(player, kit);
                }));

        setFragment(11, Fragment.of(ItemStack.of(kitItem.getMaterial(), 4),
                event -> {
                    SoundsUtil.playClickSound(player);
                    kitItem.setAmount(4);

                    new KitEditorMenu(player, kit);
                }));

        setFragment(12, Fragment.of(ItemStack.of(kitItem.getMaterial(), 8),
                event -> {
                    SoundsUtil.playClickSound(player);
                    kitItem.setAmount(8);

                    new KitEditorMenu(player, kit);
                }));

        setFragment(13, Fragment.of(ItemStack.of(kitItem.getMaterial(), 16),
                event -> {
                    SoundsUtil.playClickSound(player);
                    kitItem.setAmount(16);

                    new KitEditorMenu(player, kit);
                }));

        setFragment(14, Fragment.of(ItemStack.of(kitItem.getMaterial(), 32),
                event -> {
                    SoundsUtil.playClickSound(player);
                    kitItem.setAmount(32);

                    new KitEditorMenu(player, kit);
                }));

        setFragment(15, Fragment.of(ItemStack.of(kitItem.getMaterial(), 64),
                event -> {
                    SoundsUtil.playClickSound(player);
                    kitItem.setAmount(64);

                    new KitEditorMenu(player, kit);
                }));

        setFragment(16, Fragment.empty(ItemStack.of(Material.BOOK)
                .withDisplayName(Component.text("Custom Amount", Style.style(NamedTextColor.YELLOW, TextDecoration.ITALIC.as(false))))));

        openMenu();
    }

}
