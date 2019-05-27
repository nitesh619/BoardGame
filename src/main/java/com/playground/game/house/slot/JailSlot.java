package com.playground.game.house.slot;

import com.playground.game.house.account.Player;
import com.playground.game.house.bank.HouseBank;
import com.playground.game.house.bank.HouseBank.HouseBankHelper;

public class JailSlot implements ISlot {

    public static final int JAIL_PANELTY = 100;
    private final int slotPos;
    private final int slotCost;

    public JailSlot(final int slotPos, final int slotCost) {
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
        return "JailSlot{" +
                ", slotPos=" + slotPos +
                ", slotCost=" + slotCost +
                '}';
    }
}
