package me.badbones69.commandmanager;

import me.badbones69.commandmanager.objects.BaseCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class CommandManager implements CommandExecutor {
    
    private static CommandManager instance = new CommandManager();
    private List<BaseCommand> commands = new ArrayList<>();
    private String prefix = "";
    
    public static CommandManager getInstance() {
        return instance;
    }
    
    public void registerCommand(BaseCommand command) {
        commands.add(command);
    }
    
    public void unregisterCommand(BaseCommand command) {
        commands.remove(command);
    }
    
    public void setPrefix(String prefix) {
        this.prefix = color(prefix);
    }
    
    public String getPrefix() {
        return prefix;
    }
    
    public String getPrefix(String string) {
        return prefix + color(string);
    }
    
    public String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
    
    public List<BaseCommand> getCommands() {
        return commands;
    }
    
    public BaseCommand getCommand(String commandName) {
        for (BaseCommand command : commands) {
            if (commandName.equalsIgnoreCase(command.getBaseCommand())) {
                return command;
            }
        }
        return null;
    }
    
    /** TODO
     Need to check if the command they typed has args.
     If it doesn't have args then it needs to check what to do.
     Need to make it so BaseCommand is not a normal object but instead a abstract class like SubCommand.
     */
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        for (BaseCommand command : commands) {
            if (label.equalsIgnoreCase(command.getBaseCommand())) {
                if (command.hasSubCommands()) {
                
                } else {
                    if (sender.hasPermission(command.getPermission())) {
                    
                    } else {
                    
                    }
                }
            }
        }
        return false;
    }
    
}