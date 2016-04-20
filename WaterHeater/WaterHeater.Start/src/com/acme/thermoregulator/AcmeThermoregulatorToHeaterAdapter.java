package com.acme.thermoregulator;

/**
 * Specifies the methods that each ACME thermoregulator to heater adapter needs to implement.
 * @author Ivan Georgiev
 *
 */
public interface AcmeThermoregulatorToHeaterAdapter {

	/**
	 * Enables the heater.
	 */
	public void enableHeater();
	
	/**
	 * Disables the heater.
	 */
	public void disableHeater();
}
