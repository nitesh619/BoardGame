package com.playground.game.house;

import com.playground.game.house.bank.HouseBank;
import com.playground.game.house.slot.ISlot;
import com.playground.game.house.account.Player;
import com.playground.game.house.exception.OutOfBoardException;
import java.util.List;
import java.util.Optional;

public class BusinessHouseGame implements IHouseGame {

    private static final int START_BALANCE = 1000;
    private List<ISlot> slots;
    private List<Player> players;
    private final HouseBank bank = HouseBank.HouseBankHelper.getBank();
    private int currentPlayerTurnIndex;

    public BusinessHouseGame() {
        bank.setBankBalance(50000);
    }

    public void initializePlayers(final List<Player> players) {
        this.players = players;
        for (Player player : players) {
            bank.register(player, START_BALANCE);
        }
    }

    public void initializeBoard(final List<ISlot> slots) {
        this.slots = slots;
    }

    @Override
    public void movePlayer(final Player player, final int slotIndex) throws OutOfBoardException {
        Optional.ofNullable(slots.get(slotIndex))
                .orElseThrow(() -> new OutOfBoardException("Invalid move"))
                .triggerFeature(player);
        player.setCurrPos(slotIndex);
    }

    public void playGame(int[] diceMoves) {
        for (int i = 0; i < diceMoves.length; i++) {
            Player player = players.get(currentPlayerTurnIndex);
            movePlayer(player, diceMoves[i]);
            currentPlayerTurnIndex = i % 3;
        }
    }

    @Override
    public String getGameWinner() {
        return "";
    }

    @Override
    public void resetGame() {
        currentPlayerTurnIndex = 0;
        this.slots = null;
        this.players = null;
    }

}
