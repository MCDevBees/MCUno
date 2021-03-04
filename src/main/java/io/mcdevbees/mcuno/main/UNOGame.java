package io.mcdevbees.mcuno.main;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class UNOGame {

    private static final int MAX_PLAYER_COUNT = 4;

    private ArrayList<Player> players;

    private enum GameState {LOBBY, IN_GAME};
    private GameState gameStatus;

    public UNOGame() {
        players = new ArrayList<Player>();
        gameStatus = GameState.LOBBY;
    }

    public int getPlayerCount() {
        return players.size();
    }

    /**
     * Adds a player to the game.
     * @param player
     * @return if the player was successfully added.
     */
    public boolean addPlayer(Player player) {
        if(players.size() >= MAX_PLAYER_COUNT || gameStatus != GameState.LOBBY) {
            return false;
        }
        return true;
    }

    /**
     * Removes a player from the game.
     * @param player
     */
    public void removePlayer(Player player) {
        players.remove(player);
    }
    
}
