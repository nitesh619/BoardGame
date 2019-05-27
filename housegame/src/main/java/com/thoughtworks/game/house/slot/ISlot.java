package com.thoughtworks.game.house.slot;

import com.thoughtworks.game.house.account.Player;

public interface ISlot {

    int getSlotPosition();

    int getSlotCashValue();

    void triggerFeature(Player player);

}
