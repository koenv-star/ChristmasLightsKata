package koen.katas.ChristmasLightsKata;

import java.util.HashMap;

public class Grid {

    private final HashMap<Coordinate, Light> lightGrid = new HashMap<>(10000000);

    public Grid() {
        this.setUpLights();
    }

    public void setUpLights() {
        for (int x = 0; x < 1000; x++) {
            for (int y = 0; y < 1000; y++) {
                this.lightGrid.put(new Coordinate(x, y), new Light());
            }
        }
    }

    public HashMap<Coordinate, Light> getLightGrid() {
        return lightGrid;
    }

    public void turnOnLightCo1toCo2(Coordinate co1, Coordinate co2) {

        int x1 = Math.min(co1.getX(), co2.getX());
        int y1 = Math.min(co1.getY(), co2.getY());

        int x2 = Math.max(co1.getX(), co2.getX());
        int y2 = Math.max(co1.getY(), co2.getY());

        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                Coordinate coordinateToLightOn = new Coordinate(x, y);
                setStatusOfLightWithCo(coordinateToLightOn, true);
            }

        }

    }

    public void turnOfLightCo1toCo2(Coordinate co1, Coordinate co2) {

        int x1 = Math.min(co1.getX(), co2.getX());
        int y1 = Math.min(co1.getY(), co2.getY());

        int x2 = Math.max(co1.getX(), co2.getX());
        int y2 = Math.max(co1.getY(), co2.getY());

        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                Coordinate coordinateToDim = new Coordinate(x, y);
                setStatusOfLightWithCo(coordinateToDim, false);
            }

        }

    }

    public long getLightsOn() {
        return lightGrid.values().stream()
                .filter(light -> !light.isStatus()).count();
    }

    private void setStatusOfLightWithCo(Coordinate co, boolean b) {
        Light lightOn = new Light(b);
        lightGrid.put(co, lightOn);
    }

}

