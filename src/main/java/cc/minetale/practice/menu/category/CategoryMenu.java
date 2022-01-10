package cc.minetale.practice.menu.category;

import cc.minetale.mlib.canvas.*;
import cc.minetale.mlib.util.SoundsUtil;
import cc.minetale.practice.kit.Kit;
import cc.minetale.practice.menu.KitEditorMenu;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextDecoration;
import net.minestom.server.entity.Player;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;

import java.lang.reflect.InvocationTargetException;

public class CategoryMenu extends Menu {

    private final Player player;
    private final Kit kit;

    public CategoryMenu(Player player, Kit kit, int slot) {
        super(player, Component.text("Item Categories"), CanvasType.FOUR_ROW);

        this.player = player;
        this.kit = kit;

        setFiller(FillingType.BORDER);

        setFragment(31, Fragment.of(ItemStack.of(Material.ARROW)
                        .withDisplayName(Component.text("Back",
                                Style.style(NamedTextColor.GRAY, TextDecoration.ITALIC.as(false)))),
                event -> {
                    this.click();
                    new KitEditorMenu(player, kit);
                }));

        var pagination = new Pagination(10, 14, false);
        var fragments = new Fragment[CategoryType.values().length + 1];

        fragments[0] = Fragment.of(ItemStack.of(Material.BARRIER)
                        .withDisplayName(Component.text("None",
                                Style.style(NamedTextColor.GRAY, TextDecoration.ITALIC.as(false)))),
                event -> {
                    kit.getInventory()[slot] = null;
                    this.click();

                    new KitEditorMenu(this.player, this.kit);
                });

        int i = 1;

        for (var category : CategoryType.values()) {
            fragments[i] = Fragment.of(category.getIcon(),
                    event -> {
                        this.click();

                        try {
                            var menu = category.getMenu();

                            if(menu != null) {
                                menu.getDeclaredConstructor(Player.class, int.class, Kit.class).newInstance(player, slot, kit);
                            } else {
                                new KitEditorMenu(this.player, this.kit);
                            }
                        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                            e.printStackTrace();
                            new KitEditorMenu(this.player, this.kit);
                        }
                    });

            i++;
        }

        pagination.setFragments(fragments);
        setPagination(pagination);

        openMenu();
    }

    private void click() {
        SoundsUtil.playClickSound(this.player);
    }

    @Override
    public void close() {

    }
}
