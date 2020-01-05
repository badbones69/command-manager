package me.badbones69.commandmanager.objects;

import me.badbones69.commandmanager.CommandManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public abstract class SubCommand {
    
    private CommandManager commandManager = CommandManager.getInstance();
    
    public abstract String getPermission();
    
    public abstract String getArguments();
    
    public abstract String getDescription();
    
    public abstract boolean allowConsole();
    
    public abstract List<String> getAliases();
    
    public boolean passCommandChecks(CommandSender sender, String command, String[] args) {
        if (sender instanceof Player) {
            return sender.hasPermission(getPermission());
        } else if (allowConsole()) {
            return true;
        } else {
            System.out.println(commandManager.getPrefix("&7You must be a player to use this command."));
            return false;
        }
    }
    
    public abstract void run(CommandSender sender, String[] args);
    
    public String getPrefix() {
        return commandManager.getPrefix();
    }
    
    public String getPrefix(String string) {
        return commandManager.getPrefix(string);
    }
    
    public String color(String string) {
        return commandManager.color(string);
    }
    
}