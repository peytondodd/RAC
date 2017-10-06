package gg.revival.rac.commands;

import gg.revival.rac.RAC;
import lombok.Getter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RACCommandExecutor implements CommandExecutor {

    @Getter RAC rac;

    public RACCommandExecutor(RAC rac) {
        this.rac = rac;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        if(!command.getName().equalsIgnoreCase("rac")) return false;

        if(args.length == 0) {
            // TODO: Send RAC info
            return false;
        }

        for(RACCommand commands : rac.getCommandManager().getCommands()) {
            if(commands.getLabel().equalsIgnoreCase(args[0])) {
                commands.onCommand(sender, args);
                return false;
            }

            if(commands.getAliases().contains(args[0].toLowerCase())) {
                commands.onCommand(sender, args);
                return false;
            }
        }

        return false;
    }
}
