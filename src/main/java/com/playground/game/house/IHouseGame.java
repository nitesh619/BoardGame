package com.playground.game.house;

import com.playground.game.house.account.Player;
import com.playground.game.house.exception.OutOfBoardException;

public interface IHouseGame {

    String getGameWinner();
    void resetGame();
    void movePlayer(Player player, int slotIndex) throws OutOfBoardException;

}
