package com.acme.thermoregulator;

/**
 * Specifies the methods that each ACME thermoregulator to thermometer adapter needs to implement.
 * @author Ivan Georgiev
 *
 */
public interface AcmeThermoregulatorToThermometerAdapter {

	/**
	 * Returns the temperature reading from the thermometer.
	 * @return The temperature reading from the thermometer.
	 */
	public Integer getTemperature();
}
