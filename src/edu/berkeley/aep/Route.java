package edu.berkeley.aep;

import java.util.ArrayList;

public class Route {

    private final Airport destination;
    private Integer cost;


    public Route(Airport destination, Integer cost) {
        this.destination = destination;
        this.cost = cost;
    }

}
