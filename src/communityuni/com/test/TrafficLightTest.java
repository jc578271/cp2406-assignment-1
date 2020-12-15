package communityuni.com.test;

import communityuni.com.model.Road;
import communityuni.com.model.TrafficLight;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TrafficLightTest {
    Road road = new Road(1, 1, 5);
    TrafficLight light = new TrafficLight(0, road);

    @Test
    void testOperate() {
        light.operate();
        ArrayList<String> list = new ArrayList<>();
        list.add("red");
        list.add("green");
        assertTrue(list.contains(light.getState()));
    }

    @Test
    void getRoad() {
        assertEquals(road, light.getRoadAttachedTo());
    }

    @Test
    void getPosition() {
        assertEquals(5, light.getPosition());
    }

    @Test
    void getId() {
        assertEquals("light_0", light.getId());
    }
}
