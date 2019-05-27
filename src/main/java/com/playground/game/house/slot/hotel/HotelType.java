package com.playground.game.house.slot.hotel;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum HotelType {
    SILVER(0, 200, 50),
    GOLD(1, 300, 150),
    PLATINUM(2, 500, 300);

    private int priority;

    private int rent;
    private int value;
    private static final Map<Integer, HotelType> PRIORITY_MAP = Collections
            .unmodifiableMap(initializeMapping());

    private static Map<Integer, HotelType> initializeMapping() {
        HashMap<Integer, HotelType> priorityMap = new HashMap<>();
        priorityMap.put(SILVER.getPriority(), SILVER);
        priorityMap.put(GOLD.getPriority(), GOLD);
        priorityMap.put(PLATINUM.getPriority(), PLATINUM);
        return priorityMap;
    }

    HotelType(int priority, int value, int rent) {
        this.priority = priority;
        this.value = value;
        this.rent = rent;
    }

    public int getValue() {
        return value;
    }

    public int getPriority() {
        return priority;
    }

    public int getRent() {
        return rent;
    }

    public static HotelType getNextUpgrade(HotelType currType) {
        return PRIORITY_MAP.getOrDefault(currType.getPriority() + 1, PLATINUM);
    }

}
