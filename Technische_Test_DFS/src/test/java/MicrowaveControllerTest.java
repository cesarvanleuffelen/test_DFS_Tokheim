import org.VanLeuffelenCesar.Microwave;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MicrowaveControllerTest {

    private Microwave microwave;

    @BeforeEach
    void setUp() {
        microwave = new Microwave();
    }

    // When I open the door, the light turns on.
    @Test
    void TestDoorOpenLightOn() {
        microwave.onDoorStatusChanged(true);
        assertTrue(microwave.isDoorOpen());
    }

    // When I close the door, the light turns off.
    @Test
    void TestDoorCloseLightOff() {
        microwave.onDoorStatusChanged(false);
        assertFalse(microwave.isDoorOpen());
    }

    // When I open the door the heater stops running.
    @Test
    void TestDoorOpenHeaterStops() {
        microwave.onDoorStatusChanged(true);
        assertFalse(microwave.isHeaterOn());
    }

    // When I press the start button when the door is opened, nothing happens
    @Test
    void TestStartDoorOpenNothing() {
        microwave.onDoorStatusChanged(true);
        microwave.onStartButtonPressed();
        assertFalse(microwave.isHeaterOn());
    }

    // When I press the start button when the door is closed, the heater runs for 1 minute.
    @Test
    void TestStartDoorCloseHeaterOneMinute() {
        microwave.onDoorStatusChanged(false);
        microwave.onStartButtonPressed();
        assertTrue(microwave.isHeaterOn());
        assertEquals(60, microwave.getHeatingTime());
    }

    // When I press the start button when the door is closed and already heating,
    // the remaining time is increased with 1 minute.
    @Test
    void TestStartDoorCloseHeatingTimePlusOne() {
        microwave.onDoorStatusChanged(false);
        microwave.onStartButtonPressed();
        microwave.onStartButtonPressed();
        assertEquals(120, microwave.getHeatingTime());
    }

}
