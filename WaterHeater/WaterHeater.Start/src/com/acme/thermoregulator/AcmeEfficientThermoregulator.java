package com.acme.thermoregulator;

/**
 * This class represents the ACME efficient thermoregulator that reads the temperature every 1000 milliseconds.
 * @author Ivan Georgiev
 *
 */
public class AcmeEfficientThermoregulator extends AcmeThermoregulator {

	/**
	 * Calls the {@link AcmeThermoregulator#AcmeThermoregulator(long, AcmeThermoregulatorToThermometerAdapter, AcmeThermoregulatorToHeaterAdapter) AcmeThermoregulator(long, AcmeThermoregulatorToThermometerAdapter, AcmeThermoregulatorToHeaterAdapter)} constructor.
	 * <br>
	 * Sets the time interval between each thermometer reading to 1000 milliseconds.
	 * @param thermometerAdapter An adapter for the thermometer.
	 * @param heaterAdapter An adapter for the heater.
	 */
	public AcmeEfficientThermoregulator(final AcmeThermoregulatorToThermometerAdapter thermometerAdapter, final AcmeThermoregulatorToHeaterAdapter heaterAdapter) {
		
		super(1000, thermometerAdapter, heaterAdapter);
	}
}
