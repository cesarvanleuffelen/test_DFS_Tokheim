package org.VanLeuffelenCesar.Interface;

public interface IMicrowave {
    /** Turns on the microwave heater element. */
    void turnOnHeater();
    /** Turns off the microwave heater element. */
    void turnOffHeater();
    /** Indicates if the door to the microwave is open or closed. */
    Boolean isDoorOpen();

    interface EventListener {
        /** Signals that the door is opened or closed */
        void onDoorStatusChanged(Boolean open);
        /** Signals that the start button is pressed */
        void onStartButtonPressed();
    }
}
