package io.mcdevbees.mcuno.main;

import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class GameManager {
    
    private LinkedHashMap<Integer, UNOGame> games;
    private HashMap<Player, Integer> players;

    public GameManager() {
        games = new LinkedHashMap<Integer, UNOGame>();
        players = new HashMap<Player, Integer>();
    }

    private int generateCode() {
        int code = (int) (Math.random() * 456976);
        int origCode = code;
        while(games.containsKey(code)) {
            code++;
            if(code > 456976) {
                code = 0;
            }
            if(code == origCode) {
                break;
            }
        }
        return code;
    }

    private int convertCodeToNum(String gameCode) {
        return gameCode.charAt(0)-'A' + 26*(gameCode.charAt(1)-'A') + 26*26*(gameCode.charAt(2) - 'A') + 26*26*26*(gameCode.charAt(3) - 'A');
    }

    private String convertNumToCode(int gameCode) {
        String str = "";
        str += (char) ('A' + (gameCode % 26));
        gameCode /= 26;
        str += (char) ('A' + (gameCode % 26));
        gameCode /= 26;
        str += (char) ('A' + (gameCode % 26));
        gameCode /= 26;
        str += (char) ('A' + (gameCode % 26));
        return str;
    }

    public String createGame(Player player) {
        if(players.containsKey(player)) {
            return null;
        }
        UNOGame game = new UNOGame();
        if(game.addPlayer(player)) {
            int code = generateCode();
            games.put(code, game);
            players.put(player, code);
            return convertNumToCode(code);
        }
        return null;
        
    }

    public boolean playerJoinGame(String gameCode, Player player) {
        if(gameCode.length() != 4 || !gameCode.matches("^[A-Z]*$")) {
            return false;
        }
        int code = convertCodeToNum(gameCode);
        if(players.containsKey(player) || !games.containsKey(code) || !games.get(code).addPlayer(player)) {
            return false;
        }
        players.put(player, code);
        return true;
    }

    public boolean playerLeaveGame(Player player) {
        if(!players.containsKey(player)) {
            return false;
        }
        if(!games.containsKey(players.get(player))) {
            players.remove(player);
            return true;
        }
        int gameCode = players.remove(player);
        UNOGame game = games.get(gameCode);
        game.removePlayer(player);
        if(game.getPlayerCount() == 0) {
            games.remove(gameCode);
        }
        return true;
    }

}
