package com.thoughtworks.game.house;

import com.thoughtworks.game.house.account.Player;
import com.thoughtworks.game.house.exception.OutOfBoardException;

public interface IHouseGame {

    String getGameWinner();
    void resetGame();
    void movePlayer(Player player, int slotIndex) throws OutOfBoardException;

}
