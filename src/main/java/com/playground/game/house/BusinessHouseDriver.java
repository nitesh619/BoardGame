package com.playground.game.house;

import com.playground.game.house.slot.ISlot;
import com.playground.game.house.slot.StartSlot;
import com.playground.game.house.account.Player;
import com.playground.game.house.exception.IllegalSlotException;
import com.playground.game.house.slot.EmptySlot;
import com.playground.game.house.slot.JailSlot;
import com.playground.game.house.slot.LotterySlot;
import com.playground.game.house.slot.hotel.HotelSlot;
import java.util.ArrayList;
import java.util.List;

//Driver class
public class BusinessHouseDriver {

    private static final String CELLS = "S,J,H,L,H,E,L,H,L,H,J";
    private String[] boardLayout = CELLS.split(",");

    public static void main(String[] args) {
        BusinessHouseDriver driver = new BusinessHouseDriver();
        driver.startGame();
    }

    private void startGame() {
        BusinessHouseGame houseGame = new BusinessHouseGame();

        houseGame.initializeBoard(parseBoard());
        houseGame.initializePlayers(createPlayers());
        houseGame.playGame(new int[] {2,3,1,6,3,3,2,1,4,2});
    }

    private List<Player> createPlayers() {
        List<Player> players = new ArrayList<>(2);
        players.add(new Player(0, "Nitesh"));
        players.add(new Player(0, "Sahil"));
        players.add(new Player(0, "Neha"));
        return players;
    }

    private List<ISlot> parseBoard() {
        List<ISlot> gameSlots = new ArrayList<>();
        for (int indexPos = 0; indexPos < boardLayout.length; indexPos++) {
            ISlot slot;
            switch (boardLayout[indexPos]) {
                case "S":
                    slot = new StartSlot(indexPos,0);
                    break;
                case "J":
                    slot = new JailSlot(indexPos, JailSlot.JAIL_PANELTY);
                    break;
                case "L":
                    slot = new LotterySlot(indexPos, LotterySlot.LOTTERY_PRIZE);
                    break;
                case "E":
                    slot = new EmptySlot(indexPos);
                    break;
                case "H":
                    slot = HotelSlot.builder().slotPos(indexPos).build();
                    break;
                default:
                    throw new IllegalSlotException(
                            "Slot type " + boardLayout[indexPos] + " is not a valid type");
            }
            gameSlots.add(slot);
        }
        return gameSlots;
    }

}
