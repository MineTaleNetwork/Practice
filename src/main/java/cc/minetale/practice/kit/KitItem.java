package cc.minetale.practice.kit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.minestom.server.item.Enchantment;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;

import java.util.HashMap;
import java.util.Map;

@Getter @Setter @AllArgsConstructor
public class KitItem {

    private Material material;
    private int amount;
    private int damage;
    private Map<Enchantment, Short> enchantments;

    public KitItem(Material material) {
        this.material = material;
        this.amount = 1;
        this.damage = 0;
        this.enchantments = new HashMap<>();
    }

    @JsonIgnore
    public ItemStack getItemStack() {
        return ItemStack.of(this.material, this.amount)
                .withMeta(meta -> {
                    meta.enchantments(this.enchantments);
                    meta.damage(this.damage);
                    return meta;
                });
    }

}
