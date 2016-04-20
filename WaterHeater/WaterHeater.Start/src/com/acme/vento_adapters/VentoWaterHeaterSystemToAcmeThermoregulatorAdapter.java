package com.acme.vento_adapters;

import com.acme.thermoregulator.AcmeThermoregulator;
import com.ventoelectrics.waterheater.VentoThermoregulator;

/**
 * An adapter that enables an Vento water heating system to work with an {@link AcmeThermoregulator ACME thermoregulator}.
 * @author Ivan Georgiev
 *
 */
public class VentoWaterHeaterSystemToAcmeThermoregulatorAdapter implements VentoThermoregulator {

	/**
	 * The ACME thermoregulator.
	 */
	private final AcmeThermoregulator acmeThermoregulator;
	
	/**
	 * Initializes the ACME thermoregulator.
	 * @param acmeThermoregulator The ACME thermoregulator.
	 */
	public VentoWaterHeaterSystemToAcmeThermoregulatorAdapter(final AcmeThermoregulator acmeThermoregulator) {
		
		this.acmeThermoregulator = acmeThermoregulator;
	}

	/**
	 * Enables the ACME thermoregulator.
	 */
	@Override
	public void enablePower() {
		
		acmeThermoregulator.start();
	}

	/**
	 * Disables the ACME thermoregulator.
	 */
	@Override
	public void disablePower() {
		
		acmeThermoregulator.interrupt();
	}
	
	/**
	 * Sets the {@link AcmeThermoregulator#upperLimitTemperature upper limit temperature} of the ACME thermoregulator.
	 */
	@Override
	public void setTemperature(Integer temperature) {
		
		acmeThermoregulator.setUpperLimitTemperature(temperature);
	}
}
