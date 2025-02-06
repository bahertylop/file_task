package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

    private int id;
    private String name;
    private int waterCountDay;
    private int waterCountNight;
    private int gasCount;
    private int electroCountDay;
    private int electroCountNight;

    public User(int id, String name, int waterCountDay, int waterCountNight, int gasCount, int electroCountDay, int electroCountNight) {
        this.id = id;
        this.name = name;
        this.waterCountDay = waterCountDay;
        this.waterCountNight = waterCountNight;
        this.gasCount = gasCount;
        this.electroCountDay = electroCountDay;
        this.electroCountNight = electroCountNight;
    }

    public String toLine() {
        return String.format(
                "%d|%s|%d|%d|%d|%d|%d",
                id,
                name,
                waterCountDay,
                waterCountNight,
                gasCount,
                electroCountDay,
                electroCountNight
        );
    }

    public List<Integer> getUserUsings() {
        return Arrays.asList(waterCountDay, waterCountNight, gasCount, electroCountDay, electroCountNight);
    }
}
