package com.streamwork.ch02.job;

import com.streamwork.ch02.api.Event;

import java.util.HashMap;

// Added by me
public class CounterEvent extends Event {
    private final HashMap<String, Integer> countMap;

    public CounterEvent(HashMap<String, Integer> countMap) {
        this.countMap = countMap;
    }

    @Override
    public HashMap<String, Integer> getData() {
        return countMap;
    }
}
