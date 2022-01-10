package cc.minetale.practice.command;

import cc.minetale.practice.kit.Kit;
import cc.minetale.practice.kit.KitItem;
import cc.minetale.practice.menu.KitEditorMenu;
import net.minestom.server.command.CommandSender;
import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.CommandContext;
import net.minestom.server.entity.Player;
import net.minestom.server.item.Material;

import java.util.HashMap;

public class KitCommand extends Command {

    public KitCommand() {
        super("kit");

        setDefaultExecutor(this::defaultExecutor);
    }

    private void defaultExecutor(CommandSender sender, CommandContext context) {
        if(sender instanceof Player executor) {
            new KitEditorMenu(executor, new Kit());
        }
    }

}
