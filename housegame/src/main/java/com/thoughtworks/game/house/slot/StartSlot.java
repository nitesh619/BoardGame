package com.thoughtworks.game.house.slot;

import com.thoughtworks.game.house.account.Player;
import com.thoughtworks.game.house.bank.HouseBank;

public class StartSlot implements ISlot {

    public static final long ROUND_COMPLETION_BONUS = 1000;
    private final int slotPos;
    private final int slotCost;

    public StartSlot(final int slotPos, final int slotCost) {
        this.slotPos = slotPos;
        this.slotCost = slotCost;
    }

    public int getSlotPosition() {
        return slotPos;
    }

    public int getSlotCashValue() {
        return slotCost;
    }

    @Override
    public void triggerFeature(final Player player) {
        awardBonusPrize(player);
    }

    private void awardBonusPrize(Player player) {
        HouseBank.HouseBankHelper.getBank().updateBalance(player,
                StartSlot.ROUND_COMPLETION_BONUS);
    }

    @Override
    public String toString() {
        return "StartSlot{" +
                ", slotPos=" + slotPos +
                ", slotCost=" + slotCost +
                '}';
    }
}
