package com.playground.game.house.slot.hotel;

import com.playground.game.house.bank.HouseBank;
import com.playground.game.house.bank.HouseBank.HouseBankHelper;
import com.playground.game.house.slot.ISlot;
import com.playground.game.house.account.Player;

public class HotelSlot implements ISlot {

    private final int slotPos;
    private final int slotCost;
    private Player hotelOwner;

    private HotelType hotelType;
    private HouseBank bank;


    public HotelSlot(final int slotPos, final int slotCost,
            final HotelType hotelType) {
        this.slotPos = slotPos;
        this.slotCost = slotCost;
        this.hotelType = hotelType;
        bank = HouseBankHelper.getBank();
    }

    public static HotelSlotBuilder builder() {
        return new HotelSlotBuilder();
    }

    public int getSlotPosition() {
        return slotPos;
    }

    public int getSlotCashValue() {
        return slotCost;
    }

    @Override
    public void triggerFeature(Player player) {
        if (hotelOwner != null) {
            if (isEligibleToUpgrade(player)) {
                upgradeHotel(player);
            } else {
                chargeRentTo(player);
            }
        } else {
            assignOwner(player);
        }
    }

    private boolean isEligibleToUpgrade(final Player player) {
        return player.equals(hotelOwner) && !HotelType.PLATINUM.equals(hotelType);
    }

    private void upgradeHotel(Player player) {
        int oldValuePaid = hotelType.getValue();
        hotelType = HotelType.getNextUpgrade(hotelType);
        bank.updateBalance(player, hotelType.getValue() - oldValuePaid);
    }

    private void chargeRentTo(final Player player) {
        bank.transferMoney(player, hotelOwner, hotelType.getRent());
    }

    private void assignOwner(final Player player) {
        hotelOwner = player;
        bank.updateBalance(player, hotelType.getValue());
    }

    public static class HotelSlotBuilder {

        private int slotPos;
        private int slotCost;
        private HotelType hotelType = HotelType.SILVER;

        HotelSlotBuilder() {
        }

        public HotelSlotBuilder slotPos(int slotPos) {
            this.slotPos = slotPos;
            return this;
        }

        public HotelSlotBuilder slotCost(int slotCost) {
            this.slotCost = slotCost;
            return this;
        }

        public HotelSlotBuilder hotelType(HotelType hotelType) {
            this.hotelType = hotelType;
            return this;
        }

        public HotelSlot build() {
            return new HotelSlot(slotPos, slotCost, hotelType);
        }

        public String toString() {
            return "HotelSlot.HotelSlotBuilder(slotPos="
                    + this.slotPos
                    + ", slotCost=" + this.slotCost + ", hotelType=" + this.hotelType + ")";
        }
    }
}
