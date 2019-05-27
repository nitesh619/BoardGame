package com.thoughtworks.game.house.bank;

import com.thoughtworks.game.house.account.Player;
import com.thoughtworks.game.house.exception.AccountLimitException;
import java.util.HashMap;


public class HouseBank implements IBank {

    private HashMap<Player, Long> playerAccounts;

    private long bankBalance;

    private HouseBank() {
        playerAccounts = new HashMap<>();
    }

    public static class HouseBankHelper {

        private static final HouseBank INSTANCE = new HouseBank();

        public static HouseBank getBank() {
            return INSTANCE;
        }
    }

    public long getBankBalance() {
        return bankBalance;
    }

    public boolean debit(final long amount) {
        bankBalance -= amount;
        return true;
    }

    public void updateBalance(Player player, final long amount) {
        playerAccounts.compute(player, (p, cash) -> cash + amount);
        this.bankBalance -= amount;
    }

    public void transferMoney(Player guest, Player owner, final long amount) {
        Long fromBalance = playerAccounts.get(guest);
        Long toBalance = playerAccounts.get(owner);

        fromBalance -= amount;
        toBalance +=amount;

        playerAccounts.put(guest, fromBalance);
        playerAccounts.put(owner, toBalance);
    }

    public void setBankBalance(final long bankBalance) {
        this.bankBalance = bankBalance;
    }

    public long credit(final long amount) {
        bankBalance += amount;
        return bankBalance;
    }

    public void register(Player account, long balance) throws AccountLimitException{
        playerAccounts.put(account, balance);
    }
}
