package koen.katas.ChristmasLightsKata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GridTest {
    final static int GRID_SIZE = 1000000;
    final static int X_LOW = 5;
    final static int Y_LOW = 5;
    final static int X_HIGH = X_LOW + 1;
    final static int Y_HIGH = Y_LOW + 1;

    @Test
    void newGridShouldHaveOneMillionDimmedLights() {
        Grid grid = new Grid();
        Light lightOn = new Light();
        lightOn.setStatus(true);

        assertNotNull(grid.getLightGrid());

        assertEquals(GRID_SIZE, grid.getLightGrid().size());
        assertFalse(grid.getLightGrid().containsValue(lightOn));

    }

    @Test
    void turnOnLightsOfSameCoordinateShouldWork() {
        Grid grid = new Grid();
        Coordinate co1 = new Coordinate(5, 5);

        grid.turnOnLightCo1toCo2(co1, co1);

        assertTrue(grid.getLightGrid().get(co1).isStatus());
        assertEquals(GRID_SIZE - 1, grid.getLightsOn());
    }

    @Test
    void turnOnLightOfCo1LeftBelowCo2ShouldWork() {
        Grid grid = new Grid();

        Coordinate co1 = new Coordinate(X_LOW, Y_LOW);
        Coordinate co2 = new Coordinate(X_HIGH, Y_HIGH);

        grid.turnOnLightCo1toCo2(co1, co2);

        assertTrue(grid.getLightGrid().get(co1).isStatus());
        assertTrue(grid.getLightGrid().get(co2).isStatus());
        assertTrue(grid.getLightGrid().get(new Coordinate(X_HIGH, Y_LOW)).isStatus());
        assertTrue(grid.getLightGrid().get(new Coordinate(X_LOW, Y_HIGH)).isStatus());
        assertEquals(GRID_SIZE - 4, grid.getLightsOn());
    }

    @Test
    void turnOnLightOfCo1RightAboveCo2ShouldWork() {
        Grid grid = new Grid();

        Coordinate co1 = new Coordinate(X_LOW, Y_LOW);
        Coordinate co2 = new Coordinate(X_HIGH, Y_HIGH);

        grid.turnOnLightCo1toCo2(co1, co2);

        assertTrue(grid.getLightGrid().get(co1).isStatus());
        assertTrue(grid.getLightGrid().get(co2).isStatus());
        assertTrue(grid.getLightGrid().get(new Coordinate(X_HIGH, Y_LOW)).isStatus());
        assertTrue(grid.getLightGrid().get(new Coordinate(X_LOW, Y_HIGH)).isStatus());
        assertEquals(GRID_SIZE - 4, grid.getLightsOn());
    }

    @Test
    void turnOnLightOfCo1LeftAboveCo2ShouldWork() {
        Grid grid = new Grid();

        Coordinate co1 = new Coordinate(X_LOW, Y_HIGH);
        Coordinate co2 = new Coordinate(X_HIGH, Y_LOW);

        grid.turnOnLightCo1toCo2(co1, co2);

        assertTrue(grid.getLightGrid().get(co1).isStatus());
        assertTrue(grid.getLightGrid().get(co2).isStatus());
        assertTrue(grid.getLightGrid().get(new Coordinate(X_HIGH, Y_HIGH)).isStatus());
        assertTrue(grid.getLightGrid().get(new Coordinate(X_LOW, Y_LOW)).isStatus());
        assertEquals(GRID_SIZE - 4, grid.getLightsOn());
    }

    @Test
    void turnOnLightOfCo1RightBelowCo2ShouldWork() {
        Grid grid = new Grid();

        Coordinate co1 = new Coordinate(X_HIGH, Y_LOW);
        Coordinate co2 = new Coordinate(X_LOW, Y_HIGH);

        grid.turnOnLightCo1toCo2(co1, co2);

        assertTrue(grid.getLightGrid().get(co1).isStatus());
        assertTrue(grid.getLightGrid().get(co2).isStatus());
        assertTrue(grid.getLightGrid().get(new Coordinate(X_HIGH, Y_HIGH)).isStatus());
        assertTrue(grid.getLightGrid().get(new Coordinate(X_LOW, Y_LOW)).isStatus());
        assertEquals(GRID_SIZE - 4, grid.getLightsOn());
    }

    @Test
    void turnOfLightsOfSameCoordinateShouldWork() {
        Grid grid = new Grid();
        grid.turnOnLightCo1toCo2(new Coordinate(0, 0), new Coordinate(999, 999));

        Coordinate co1 = new Coordinate(5, 5);

        grid.turnOfLightCo1toCo2(co1, co1);

        assertFalse(grid.getLightGrid().get(co1).isStatus());
        assertEquals(GRID_SIZE - 1, GRID_SIZE - grid.getLightsOn());
    }

    @Test
    void turnOfLightOfCo1LeftBelowCo2ShouldWork() {
        Grid grid = new Grid();
        grid.turnOnLightCo1toCo2(new Coordinate(0, 0), new Coordinate(999, 999));

        Coordinate co1 = new Coordinate(X_LOW, Y_LOW);
        Coordinate co2 = new Coordinate(X_HIGH, Y_HIGH);

        grid.turnOfLightCo1toCo2(co1, co2);

        assertFalse(grid.getLightGrid().get(co1).isStatus());
        assertFalse(grid.getLightGrid().get(co2).isStatus());
        assertFalse(grid.getLightGrid().get(new Coordinate(X_HIGH, Y_LOW)).isStatus());
        assertFalse(grid.getLightGrid().get(new Coordinate(X_LOW, Y_HIGH)).isStatus());
        assertEquals(GRID_SIZE - 4, GRID_SIZE - grid.getLightsOn());
    }

    @Test
    void turnOfLightOfCo1RightAboveCo2ShouldWork() {
        Grid grid = new Grid();
        grid.turnOnLightCo1toCo2(new Coordinate(0, 0), new Coordinate(999, 999));

        Coordinate co1 = new Coordinate(X_LOW, Y_LOW);
        Coordinate co2 = new Coordinate(X_HIGH, Y_HIGH);

        grid.turnOfLightCo1toCo2(co1, co2);

        assertFalse(grid.getLightGrid().get(co1).isStatus());
        assertFalse(grid.getLightGrid().get(co2).isStatus());
        assertFalse(grid.getLightGrid().get(new Coordinate(X_HIGH, Y_LOW)).isStatus());
        assertFalse(grid.getLightGrid().get(new Coordinate(X_LOW, Y_HIGH)).isStatus());
        assertEquals(GRID_SIZE - 4, GRID_SIZE - grid.getLightsOn());
    }

    @Test
    void turnOfLightOfCo1LeftAboveCo2ShouldWork() {
        Grid grid = new Grid();
        grid.turnOnLightCo1toCo2(new Coordinate(0, 0), new Coordinate(999, 999));

        Coordinate co1 = new Coordinate(X_LOW, Y_HIGH);
        Coordinate co2 = new Coordinate(X_HIGH, Y_LOW);

        grid.turnOfLightCo1toCo2(co1, co2);

        assertFalse(grid.getLightGrid().get(co1).isStatus());
        assertFalse(grid.getLightGrid().get(co2).isStatus());
        assertFalse(grid.getLightGrid().get(new Coordinate(X_HIGH, Y_HIGH)).isStatus());
        assertFalse(grid.getLightGrid().get(new Coordinate(X_LOW, Y_LOW)).isStatus());
        assertEquals(GRID_SIZE - 4, GRID_SIZE - grid.getLightsOn());
    }

    @Test
    void turnOfLightOfCo1RightBelowCo2ShouldWork() {
        Grid grid = new Grid();
        grid.turnOnLightCo1toCo2(new Coordinate(0, 0), new Coordinate(999, 999));

        Coordinate co1 = new Coordinate(X_HIGH, Y_LOW);
        Coordinate co2 = new Coordinate(X_LOW, Y_HIGH);

        grid.turnOfLightCo1toCo2(co1, co2);

        assertFalse(grid.getLightGrid().get(co1).isStatus());
        assertFalse(grid.getLightGrid().get(co2).isStatus());
        assertFalse(grid.getLightGrid().get(new Coordinate(X_HIGH, Y_HIGH)).isStatus());
        assertFalse(grid.getLightGrid().get(new Coordinate(X_LOW, Y_LOW)).isStatus());
        assertEquals(GRID_SIZE - 4,GRID_SIZE - grid.getLightsOn());
    }

}