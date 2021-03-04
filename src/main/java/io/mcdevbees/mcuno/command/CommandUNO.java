package io.mcdevbees.mcuno.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.mcdevbees.mcuno.main.GameManager;

public class CommandUNO implements CommandExecutor {

    private GameManager manager;

    public CommandUNO(GameManager manager) {
        this.manager = manager;
    }
    
    /**
     * Commands:
     * /uno list
     * /uno join <code>
     * /uno leave
     * /uno create
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length > 0) {
            if(args[0].equals("list")) {
                
            } else {
                if(sender instanceof Player) {
                    if(args[0].equals("join") && args.length == 2) {
                        if(manager.playerJoinGame(args[1], (Player) sender)) {
                            sender.sendMessage("You have joined the UNO game with code: " + args[1]);
                        } else {
                            sender.sendMessage("Failed to join the game; did you use a valid code or are you currently in a game?");
                        }
                    } else if(args[0].equals("leave")) {
                        if(manager.playerLeaveGame((Player) sender)) {
                            sender.sendMessage("You have been removed from the game.");
                        } else {
                            sender.sendMessage("You are not currently in a game.");
                        }
                    } else if(args[0].equals("create")) {
                        String gameCode = manager.createGame((Player) sender);
                        if(gameCode != null) {
                            sender.sendMessage("Game created; code: " + gameCode);
                        } else {
                            sender.sendMessage("An error has occured creating a game; are you already in a game?");
                        }
                    } else {
                        sender.sendMessage("Invalid command usage.");
                    }
                } else {
                    sender.sendMessage("You must be a player to use /uno " + args[0]);
                }
            }
        } else {
            sender.sendMessage("Invalid command usage.");
        }
        
        return false;
    }
    
}
