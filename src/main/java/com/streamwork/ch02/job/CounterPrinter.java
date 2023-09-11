package com.streamwork.ch02.job;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.streamwork.ch02.api.Event;
import com.streamwork.ch02.api.Operator;

// Added by me
public class CounterPrinter extends Operator {
    public CounterPrinter(String name) {
        super(name);
    }

    @Override
    public void apply(Event countEvent, List<Event> eventCollector) {
        HashMap<String, Integer> countMap = ((CounterEvent) countEvent).getData();

        System.out.println("CounterPrinter --> ");
        printCountMap(countMap);
    }

    private void printCountMap(HashMap<String, Integer> countMap) {
        List<String> vehicles = new ArrayList<>(countMap.keySet());
        Collections.sort(vehicles);

        for (String vehicle : vehicles) {
            System.out.println("  " + vehicle + ": " + countMap.get(vehicle));
        }
    }
}
