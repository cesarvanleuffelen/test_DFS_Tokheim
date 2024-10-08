package org.VanLeuffelenCesar;

import org.VanLeuffelenCesar.Interface.IMicrowave;

public class Microwave implements IMicrowave, IMicrowave.EventListener {

    // attributes
    private Boolean doorOpen = false;
    private Boolean heaterOn = false;
    private Boolean lightOn = false;
    private int heatingTime = 0;

    // no-arg constructor (optional)
    public Microwave() {}

    // interface methodes
    @Override
    public void turnOnHeater() {
        heaterOn = true;
        System.out.println("Heater: OFF");
    }

    @Override
    public void turnOffHeater() {
        heaterOn = false;
        System.out.println("Heater: ON");
    }

    @Override
    public Boolean isDoorOpen() {
        return lightOn;
    }

    @Override
    public void onDoorStatusChanged(Boolean open) {
        if (open){
            turnOffHeater();
            lightOn = true;
            doorOpen = true;
        } else {
            lightOn = false;
            doorOpen = false;
        }
    }

    @Override
    public void onStartButtonPressed() {
        if (!isDoorOpen()) {
            turnOnHeater();
            heatingTime += 60;
        }
    }

    // extra checking methodes
    public Boolean isHeaterOn() {
        return heaterOn;
    }

    public int getHeatingTime() {
        return heatingTime;
    }
}
