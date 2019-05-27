package com.playground.game.house.account;

import java.util.Objects;

public class Player {

    private int currPos;

    private String playerName;
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Player)) {
            return false;
        }
        final Player player = (Player) o;
        return Objects.equals(getPlayerName(), player.getPlayerName());
    }

    public void setCurrPos(final int currPos) {
        this.currPos = currPos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlayerName());
    }

    public Player(final int currPos,
            final String playerName) {
        this.currPos = currPos;
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

}
