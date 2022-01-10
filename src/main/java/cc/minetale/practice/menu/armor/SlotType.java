package cc.minetale.practice.menu.armor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.minestom.server.item.Material;

@Getter @AllArgsConstructor
public enum SlotType {

    HELMET("Helmet", Material.ORANGE_STAINED_GLASS_PANE, 0, 0),
    CHESTPLATE("Chestplate", Material.ORANGE_STAINED_GLASS_PANE, 1, 1),
    LEGGINGS("Leggings", Material.ORANGE_STAINED_GLASS_PANE, 2, 2),
    BOOTS("Boots", Material.ORANGE_STAINED_GLASS_PANE, 3, 3),
    OFFHAND("Offhand", Material.ORANGE_STAINED_GLASS_PANE, 4, 4),
    INVENTORY("Inventory", Material.GRAY_STAINED_GLASS_PANE, 5, 31),
    HOTBAR("Hotbar", Material.YELLOW_STAINED_GLASS_PANE, 32, 41);

    private final String name;
    private final Material icon;
    private final int start;
    private final int finish;

    public int getSlot() {
        return this.ordinal();
    }

    public boolean isArmor() {
        return this == SlotType.HELMET || this == SlotType.CHESTPLATE || this == SlotType.LEGGINGS || this == SlotType.BOOTS;
    }

    public static SlotType getType(int slot) {
        for(var type : SlotType.values()) {
            if (slot >= type.getStart() && slot <= type.getFinish()) {
                return type;
            }
        }

        return null;
    }

}
