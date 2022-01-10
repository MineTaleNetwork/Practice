package cc.minetale.practice.menu;

import cc.minetale.mlib.canvas.CanvasType;
import cc.minetale.mlib.canvas.Menu;
import cc.minetale.practice.kit.Kit;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import net.minestom.server.entity.Player;

@Getter
public class KitMenu extends Menu {

    private final Kit kit;

    public KitMenu(Kit kit, Player player, Component title, CanvasType type) {
        super(player, title, type);

        this.kit = kit;
    }
}
