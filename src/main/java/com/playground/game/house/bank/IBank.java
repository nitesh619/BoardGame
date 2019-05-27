package com.playground.game.house.bank;

import com.playground.game.house.account.Player;
import com.playground.game.house.exception.AccountLimitException;

public interface IBank {

    long getBankBalance();

    boolean debit(long amount);

    long credit(long amount);

    void register(Player account, long playerCash) throws AccountLimitException;
}
