package koen.katas.ChristmasLightsKata;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LightTest {

    @Test
    void LightShouldBeOfOnCreation() {
        Light light = new Light();
        assertFalse(light.isStatus());
    }

    @Test
    void setStatusTrueShouldWork() {
        Light light = new Light();
        light.setStatus(true);
        assertTrue(light.isStatus());
    }

    @Test
    void setStatusFalseShouldWork() {
        Light light = new Light();
        light.setStatus(true);
        light.setStatus(false);
        assertFalse(light.isStatus());
    }
}