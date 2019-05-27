package com.playground.game.house.slot;

import com.playground.game.house.account.Player;

public interface ISlot {

    int getSlotPosition();

    int getSlotCashValue();

    void triggerFeature(Player player);

}
