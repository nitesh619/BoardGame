package com.thoughtworks.game.house.slot;

import com.thoughtworks.game.house.account.Player;

public class EmptySlot implements ISlot {

    private final int slotPos;
    private final int slotCashValue;

    public EmptySlot(final int slotPos, final int slotCost) {
        this.slotPos = slotPos;
        this.slotCashValue = slotCost;
    }

    public EmptySlot(final int pos) {
        this(pos, 0);
    }

    public int getSlotPosition() {
        return slotPos;
    }

    public int getSlotCashValue() {
        return slotCashValue;
    }

    @Override
    public void triggerFeature(Player player) {
    }

    @Override
    public String toString() {
        return "EmptySlot{" +
                ", slotPos=" + slotPos +
                ", slotCashValue=" + slotCashValue +
                '}';
    }
}
