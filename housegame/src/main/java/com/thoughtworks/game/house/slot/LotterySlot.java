package com.thoughtworks.game.house.slot;

import com.thoughtworks.game.house.account.Player;
import com.thoughtworks.game.house.bank.HouseBank;
import com.thoughtworks.game.house.bank.HouseBank.HouseBankHelper;

public class LotterySlot implements ISlot {

    public static final int LOTTERY_PRIZE = 200;
    private final int slotPos;
    private final int slotCost;


    public LotterySlot(final int slotPos, final int slotCost) {
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
    public void triggerFeature(Player player) {
        HouseBank bank = HouseBankHelper.getBank();
        bank.updateBalance(player, getSlotCashValue());
    }

    @Override
    public String toString() {
        return "LotterySlot{" +
                ", slotPos=" + slotPos +
                ", slotCost=" + slotCost +
                '}';
    }
}
