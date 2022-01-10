package cc.minetale.practice.menu;

import cc.minetale.mlib.canvas.CanvasType;
import cc.minetale.mlib.canvas.Fragment;
import cc.minetale.mlib.util.SoundsUtil;
import cc.minetale.practice.Practice;
import cc.minetale.practice.enchantment.EnchantmentType;
import cc.minetale.practice.kit.Kit;
import cc.minetale.practice.kit.KitItem;
import cc.minetale.practice.menu.armor.ArmorMenu;
import cc.minetale.practice.menu.armor.SlotType;
import cc.minetale.practice.menu.category.CategoryMenu;
import cc.minetale.practice.menu.enchantment.EnchantmentSelectionMenu;
import cc.minetale.practice.menu.stack.StackSizeMenu;
import com.fasterxml.jackson.core.JsonProcessingException;
import net.kyori.adventure.text.Component;
import net.minestom.server.entity.Player;
import net.minestom.server.item.ItemStack;

import java.util.concurrent.atomic.AtomicReference;

public class KitEditorMenu extends KitMenu {

    // TODO -> Make an anvil gui
    // TODO -> Check if opening the guis also unregisters them
    // TODO -> Firework power and flight duration editor (7 for both)

    public KitEditorMenu(Player player, Kit kit) {
        super(kit, player, Component.text("Kit Creator"), CanvasType.FIVE_ROW);

        var kitInventory = kit.getInventory();

        for (int i = 0; i < kitInventory.length; i++) {
            var type = SlotType.getType(i);
            var kitItem = kitInventory[i];
            var slot = i;

            setFragment(
                    (type == SlotType.INVENTORY || type == SlotType.HOTBAR) ? i + 4 : i,
                    Fragment.of(kitItem != null ?
                                    kitItem.getItemStack() :
                                    ItemStack.of(type.getIcon())
                                            .withDisplayName(Component.text(type.getName())),
                            event -> {
                                switch (event.getClickType()) {
                                    case SHIFT_CLICK -> {
                                        // TODO -> Paste
                                    }
                                    case DROP -> {
                                        // TODO -> Copy
                                    }
                                    case LEFT_CLICK -> {
                                        SoundsUtil.playClickSound(player);

                                        if (type.isArmor()) {
                                            new ArmorMenu(player, kit, type);
                                        } else {
                                            new CategoryMenu(player, this.getKit(), slot);
                                        }
                                    }
                                    case RIGHT_CLICK -> {
                                        SoundsUtil.playClickSound(player);

                                        if (kitItem != null) {
                                            if (EnchantmentType.isEnchantable(kitItem.getMaterial())) {
                                                new EnchantmentSelectionMenu(player, kit, slot);
                                            }

                                            if (kitItem.getMaterial().maxStackSize() == 1) {
                                                return;
                                            }

                                            new StackSizeMenu(player, kit, slot);
                                        }
                                    }
                                }
                            })
            );
        }

//        setFragment(7, Fragment.empty(
//                ItemStack.of(Material.TNT)
//                        .withDisplayName(Component.text("Reset Kit", Style.style(NamedTextColor.RED, TextDecoration.ITALIC.as(false))))
//        ));
//
//        setFragment(8, Fragment.empty(
//                ItemStack.of(Material.NAME_TAG)
//                        .withDisplayName(Component.text("Rename Kit", Style.style(NamedTextColor.GOLD, TextDecoration.ITALIC.as(false))))
//        ));

        openMenu();
    }


    @Override
    public void close() {
        try {
            System.out.println(Practice.mapper.writeValueAsString(this.getKit()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
