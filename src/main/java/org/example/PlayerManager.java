package org.example;

import java.util.*;


public class PlayerManager {
    private List<Player> allPlayers;
    private Map<League, List<Player>> mapAllPlayers;
    private Set<UUID> uuids;
    static PlayerManager pm = null;


    public static PlayerManager getInstance() {
        if (pm == null)
            pm = new PlayerManager();
        return pm;
    }

    private PlayerManager() {

        allPlayers = new ArrayList<Player>();
        mapAllPlayers = new HashMap<>();
        uuids = new HashSet<>();
        for (League l : League.values()) {
            mapAllPlayers.put(l, new ArrayList<>());
        }
    }


    public boolean addPlayer(Player player) {
        boolean res = false;
        if (!uuids.contains(player.getPlayerId())) {
            League league = assignLeague(player);
            if (league != League.UNDEFINED) {
                List<Player> players = mapAllPlayers.get(league);
                players.add(player);
                uuids.add((player.getPlayerId()));
                res = true;
            }
        }
        return res;
    }

    private League assignLeague(Player player) {
        League res = League.UNDEFINED;

        if (player.getAge() >= 15 && player.getAge() <= 20) {
            player.setLeague(League.SECOND);
            res = League.SECOND;
        } else if (player.getAge() >= 21 && player.getAge() <= 30) {
            player.setLeague(League.FIRST);
            res = League.FIRST;
        } else if (player.getAge() >= 31 && player.getAge() <= 100) {
            player.setLeague(League.PRIME);
            res = League.PRIME;
        }
        return res;

    }

    public List<Player> getPlayersByLeague(League league) {

        return new LinkedList<>(mapAllPlayers.get(league));
    }



    public boolean changeLeague(Player player, League newLeague) {
        boolean res = false;
        if (!player.getLeague().equals(newLeague)) {
            List<Player> playerLeagueOld = mapAllPlayers.get(player.getLeague());
            List<Player> playerLeagueNew = mapAllPlayers.get(newLeague);
            Iterator<Player> it = playerLeagueOld.iterator();
            while (it.hasNext() && !res) {
                Player p = it.next();
                if (p.getPlayerId().equals(player.getPlayerId())) {
                    it.remove();
                    playerLeagueNew.add(player);
                    res = true;
                }
            }
        }
        return res;
    }

}





