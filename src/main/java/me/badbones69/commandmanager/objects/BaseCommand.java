package me.badbones69.commandmanager.objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseCommand {
    
    private String baseCommand;
    private List<SubCommand> subCommands;
    private String permission;
    
    public BaseCommand(String baseCommand, String permission) {
        this.baseCommand = baseCommand;
        this.subCommands = new ArrayList<>();
        this.permission = permission;
    }
    
    public BaseCommand(String baseCommand, SubCommand subCommands) {
        this(baseCommand, Arrays.asList(subCommands));
    }
    
    public BaseCommand(String baseCommand, List<SubCommand> subCommands) {
        this.baseCommand = baseCommand;
        this.subCommands = subCommands;
        this.permission = "";
    }
    
    public String getBaseCommand() {
        return baseCommand;
    }
    
    public SubCommand getSubCommand(String commandName) {
        for (SubCommand subCommand : subCommands) {
            if (subCommand.getAliases().contains(commandName.toLowerCase())) {
                return subCommand;
            }
        }
        return null;
    }
    
    public List<SubCommand> getSubCommands() {
        return subCommands;
    }
    
    public String getPermission() {
        return permission;
    }
    
    public boolean hasSubCommands() {
        return !subCommands.isEmpty();
    }
    
}