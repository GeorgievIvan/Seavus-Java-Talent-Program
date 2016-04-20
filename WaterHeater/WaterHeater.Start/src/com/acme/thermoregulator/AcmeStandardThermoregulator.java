package com.acme.thermoregulator;

/**
 * This class represents the ACME standard thermoregulator that reads the temperature every 3000 milliseconds.
 * @author Ivan Georgiev
 *
 */
public class AcmeStandardThermoregulator extends AcmeThermoregulator {
	
	/**
	 * Calls the {@link AcmeThermoregulator#AcmeThermoregulator(long, AcmeThermoregulatorToThermometerAdapter, AcmeThermoregulatorToHeaterAdapter) AcmeThermoregulator(long, AcmeThermoregulatorToThermometerAdapter, AcmeThermoregulatorToHeaterAdapter)} constructor.
	 * <br>
	 * Sets the time interval between each thermometer reading to 3000 milliseconds.
	 * @param thermometerAdapter An adapter for the thermometer.
	 * @param heaterAdapter An adapter for the heater.
	 */
	public AcmeStandardThermoregulator(final AcmeThermoregulatorToThermometerAdapter thermometerAdapter, final AcmeThermoregulatorToHeaterAdapter heaterAdapter) {
		
		super(3000, thermometerAdapter, heaterAdapter);
	}
}
