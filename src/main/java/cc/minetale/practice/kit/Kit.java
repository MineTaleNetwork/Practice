package cc.minetale.practice.kit;

import cc.minetale.commonlib.util.StringUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.minestom.server.entity.Player;

@Getter @AllArgsConstructor
public class Kit {

    @JsonProperty("_id")
    private final String id;
    private final KitItem[] inventory;

    public Kit() {
        this.id = StringUtil.generateId();
        this.inventory = new KitItem[41];
    }

    // TODO
    public void apply(Player player) {
        var inventory = player.getInventory();

        inventory.clear();

        for(int i = 0; i < 27; i++) {
            var kitItem = this.inventory[i];

            if(kitItem != null) {
                inventory.setItemStack(i + 9, kitItem.getItemStack());
            }
        }

        for(int i = 27; i < 36; i++) {
            var kitItem = this.inventory[i];

            if(kitItem != null) {
                inventory.setItemStack(i - 27, kitItem.getItemStack());
            }
        }
    }

}
