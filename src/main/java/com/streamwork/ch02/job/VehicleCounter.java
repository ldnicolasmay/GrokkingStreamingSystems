package com.streamwork.ch02.job;

import java.util.HashMap;
import java.util.List;
//import java.util.ArrayList;
//import java.util.Map;
//import java.util.Collections;

import com.streamwork.ch02.api.Event;
import com.streamwork.ch02.api.Operator;

//// Original
//class VehicleCounter extends Operator {
//  private final Map<String, Integer> countMap = new HashMap<String, Integer>();
//
//  public VehicleCounter(String name) {  super(name);  }
//
//  @Override
//  public void apply(Event vehicleEvent, List<Event> eventCollector) {
//    String vehicle = ((VehicleEvent)vehicleEvent).getData();
//    Integer count = countMap.getOrDefault(vehicle, 0) + 1;
//    countMap.put(vehicle, count);
//
//    System.out.println("VehicleCounter --> ");
//    printCountMap();
//  }
//
//  private void printCountMap() {
//    List<String> vehicles = new ArrayList<>(countMap.keySet());
//    Collections.sort(vehicles);
//
//    for (String vehicle: vehicles) {
//      System.out.println("  " + vehicle + ": " + countMap.get(vehicle));
//    }
//  }
//}

//// Added by me
//class VehicleCounter extends Operator {
//  private final Map<String, Integer> countMap = new HashMap<String, Integer>();
//
//  public VehicleCounter(String name) {  super(name);  }
//
//  // Added by me
//  private final Map<String, Double> feeMap = new HashMap<>() {{
//    put("car", 3.0);
//    put("suv", 3.5);
//    put("truck", 4.0);
//    put("van", 4.5);
//    put("bus", 6.0);
//    put("semi", 8.0);
//  }}; // Unknown vehicles will be charged maximum $8.00
//
//  // Added by me
//  private final Map<String, Double> cumeFeesMap = new HashMap<>();
//
//  // Added by me
//  @Override
//  public void apply(Event vehicleEvent, List<Event> eventCollector) {
//    String vehicle = ((VehicleEvent) vehicleEvent).getData();
//    Integer count = countMap.getOrDefault(vehicle, 0) + 1;
//    countMap.put(vehicle, count);
//
//    System.out.println("VehicleCounter --> ");
//    printCountMap();
//
//    Double cumeFee = cumeFeesMap.getOrDefault(vehicle, 0.0) + feeMap.getOrDefault(vehicle, 8.0);
//    cumeFeesMap.put(vehicle, cumeFee);
//
//    System.out.println("CumulativeFees --> ");
//    printCumeFeesMap();
//  }
//
//  private void printCountMap() {
//    List<String> vehicles = new ArrayList<>(countMap.keySet());
//    Collections.sort(vehicles);
//
//    for (String vehicle: vehicles) {
//      System.out.println("  " + vehicle + ": " + countMap.get(vehicle));
//    }
//  }
//
//  // Added by me
//  private void printCumeFeesMap() {
//    List<String> vehicles = new ArrayList<>(cumeFeesMap.keySet());
//    Collections.sort(vehicles);
//
//    for (String vehicle : vehicles) {
//      System.out.println("  " + vehicle + ": " + cumeFeesMap.get(vehicle));
//    }
//  }
//}

// Added by me
class VehicleCounter extends Operator {
  private final HashMap<String, Integer> countMap = new HashMap<>();

  public VehicleCounter(String name) {  super(name);  }

  @Override
  public void apply(Event vehicleEvent, List<Event> eventCollector) {
    String vehicle = ((VehicleEvent)vehicleEvent).getData();
    Integer count = countMap.getOrDefault(vehicle, 0) + 1;
    countMap.put(vehicle, count);

    eventCollector.add(new CounterEvent(countMap));
    System.out.println("VehicleCounter --> " + vehicle);
  }
}

