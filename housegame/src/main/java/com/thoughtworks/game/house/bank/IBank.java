package com.thoughtworks.game.house.bank;

import com.thoughtworks.game.house.account.Player;
import com.thoughtworks.game.house.exception.AccountLimitException;

public interface IBank {

    long getBankBalance();

    boolean debit(long amount);

    long credit(long amount);

    void register(Player account, long playerCash) throws AccountLimitException;
}
