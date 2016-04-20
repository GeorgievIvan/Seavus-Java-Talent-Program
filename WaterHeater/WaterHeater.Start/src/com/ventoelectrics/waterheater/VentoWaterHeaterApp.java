package com.ventoelectrics.waterheater;

import java.util.concurrent.TimeUnit;

public class VentoWaterHeaterApp {

	public static void run(VentoThermoregulator thermoregulator, VentoPowerSwitch powerSwitch) {
		
		thermoregulator.setTemperature(20);
		powerSwitch.turnOn();

		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
		}
		thermoregulator.setTemperature(40);

		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
		}
		powerSwitch.turnOff();
	}
}
