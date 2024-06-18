package edu.berkeley.aep;

import java.util.*;


public class Airport {
    public final static int UNREACHABLE = -1;
    private final String name;
    private ArrayList<Airport> destinations;
    private ArrayList<Airport> destinationsWithCost;

    private ArrayList<Integer> costs;



    // Constructor that accepts only a name
    public Airport(String name) {
        this.name = name;
        this.destinations = new ArrayList<>();
        this.destinationsWithCost = new ArrayList<>();
        this.costs = new ArrayList<>();
    }

    // Constructor that accepts a name and a list of destinations
    public Airport(String name, ArrayList<Airport> destinations) {
        this.name = name;
        this.destinations = new ArrayList<>(destinations); // Initialize with a copy of the given list
    }

    public Airport(String name, ArrayList<Airport> destinationsWithCost, ArrayList<Integer> costs) {
        this.name = name;
        this.destinationsWithCost = new ArrayList<>(destinationsWithCost);
        this.costs = new ArrayList<Integer>(costs);
    }

//    public Airport(String name, ArrayList<Object> destinations) {
//        this.name = name;
//        this.destinations = new ArrayList<>(destinations);
//        this.costs = new ArrayList<Integer>();
//    }



    public void addDestination(Airport destination) {
        destinations.add(destination);
    }

    public void addDestination(Airport destination, Integer cost) {
        destinationsWithCost.add(destination);
        costs.add(cost);
    }

    public int getLeastCostToDestination(Airport otherAirport) {
        return getLeastCostToDestination(otherAirport, new HashSet<>());
    }


    private int getLeastCostToDestination(Airport otherAirport, Set<Airport> visited) {
        List<Airport> queue = new ArrayList<>();
        Map<Airport, Integer> hopCountMap = new HashMap<>();
        Map<Airport, Integer> hopCostMap = new HashMap<>();

        queue.add(this);
        hopCountMap.put(this, 0);
        hopCostMap.put(this, 0);

        int currentIndex = 0;
        int minCost = UNREACHABLE;
        while (currentIndex < queue.size()) {
            Airport currentAirport = queue.get(currentIndex);
            int currentHopCount = hopCountMap.get(currentAirport);
            int currentCost = hopCostMap.get(currentAirport);
            if (currentAirport.equals(otherAirport)) {
                minCost = Math.min(minCost, currentCost);
            }

            visited.add(currentAirport);

//            for (Airport destination : currentAirport.destinationsWithCost) {
            for (int i = 0; i < currentAirport.destinationsWithCost.size(); i++) {
                Airport destination = currentAirport.destinationsWithCost.get(i);
                Integer cost = currentAirport.costs.get(i);
                // If the destination is not visited, add to queue and hop count
                if (!visited.contains(destination)) {
                    queue.add(destination);
                    hopCountMap.put(destination, currentHopCount + 1);
                    hopCostMap.put(destination, currentCost + cost);

                    System.out.println(hopCountMap);
                    visited.add(destination);
                }
            }
            currentIndex++;
        }
//        return minCost;
        if (visited.contains(otherAirport)){
            return hopCostMap.get(otherAirport);
    }
        return UNREACHABLE;

    }


    public boolean canReach(Airport otherAirport) {
        return countHops(otherAirport) != Airport.UNREACHABLE;
    }

    public int countHops(Airport otherAirport) {
        return countHops(otherAirport, new HashSet<>());
    }

    private int countHops(Airport otherAirport, Set<Airport> visited) {
        List<Airport> queue = new ArrayList<>();
        Map<Airport, Integer> hopCountMap = new HashMap<>();

        queue.add(this);
        hopCountMap.put(this, 0);

        int currentIndex = 0;

        while (currentIndex < queue.size()) {
            Airport currentAirport = queue.get(currentIndex);
            int currentHopCount = hopCountMap.get(currentAirport);
            if (currentAirport.equals(otherAirport)) {
                return currentHopCount;
            }

            visited.add(currentAirport);

            for (Airport destination : currentAirport.destinations) {
                // If the destination is not visited, add to queue and hop count
                if (!visited.contains(destination)) {
                    queue.add(destination);
                    hopCountMap.put(destination, currentHopCount + 1);
                    System.out.println(hopCountMap);
                    visited.add(destination);
                }
            }
            currentIndex++;
        }

        return UNREACHABLE;
    }
}

//    private int countHopsOld(Airport otherAirport, Set<Airport> visited) {
//        if (this.equals(otherAirport)) {
//            return visited.size();
//        }
//        visited.add(this); // to avoid cycle
//
//        for (Airport destination : destinations) {
//            if (!visited.contains(destination) && (destination.countHops(otherAirport, visited) > 0)) {
//                return visited.size();
//            }
//        }
//        return Airport.UNREACHABLE;
//    }

//    private int countHops(Airport otherAirport, Set<Airport> visited) {
//        int whileLoopCounter = 0;
//        List<Airport> airportList = new ArrayList<>();
//        airportList.add(this);
//
//        while (!airportList.isEmpty()){
//            Airport currentAirport = airportList.removeFirst();
//
//            if (currentAirport.equals(otherAirport)){
//                return whileLoopCounter;
//            }
//            visited.add(currentAirport);
//
//            for (Airport destination : destinations) {
//                if (!visited.contains(destination)) {
//                    airportList.add(destination);
//                }
//            }
//
//            whileLoopCounter += 1;
//            }
//
//        return UNREACHABLE;
//    }
//}





//package edu.berkeley.aep;
//
//import java.util.*;
//
//public class Airport {
//
//    private final String airportName;
//    private Map<String, List<String>> map = new HashMap<>();
//
//    public Airport(String airportName){
//        this.airportName = airportName;
//        initMap();
//    }
//
//    public void initMap() {
//        map.put("h", new ArrayList<>(List.of()));
//        map.put("b", new ArrayList<>(List.of("h")));
//        map.put("a", new ArrayList<>(List.of("h","b","c","d","e")));
//        map.put("c", new ArrayList<>(List.of("h")));
//        map.put("d", new ArrayList<>(List.of("h")));
//        map.put("e", new ArrayList<>(List.of("h")));
//        map.put("f", new ArrayList<>(List.of("a","h","b","c","d","e")));
//
//    }
//
//
////    public static void main(String[] args){
////        Map<String, List<String>> map = new HashMap<>();
////        map.put("h", new ArrayList<>(List.of("b")));
////        map.put("b", new ArrayList<>(List.of("a", "c")));
////        map.put("a", new ArrayList<>(List.of("f")));
////        map.put("c", new ArrayList<>(List.of("d","e", "e")));
////        map.put("d", new ArrayList<>(List.of("e")));
////        map.put("e", new ArrayList<>(List.of("b")));
////
////        System.out.println(map);
////    }
//
//
//
//    public boolean canReach(String destination){
//        List<String> destinations = map.get(this.airportName);
//        return !(destinations.contains(destination));
//    }
//
////    public boolean canReachNew(String destination, Set<Airport> visited){
////        if (visited.contains(this)){
////            return false;
////        }
////        visited.add(this);
////
////        for (Airport dest: destinations)
////    }
//}
