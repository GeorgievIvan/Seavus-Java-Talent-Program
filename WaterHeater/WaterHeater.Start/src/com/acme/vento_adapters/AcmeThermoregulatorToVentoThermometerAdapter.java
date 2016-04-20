package com.acme.vento_adapters;

import com.acme.thermoregulator.AcmeThermoregulator;
import com.acme.thermoregulator.AcmeThermoregulatorToThermometerAdapter;
import com.ventoelectrics.waterheater.VentoThermometer;

/**
 * An adapter that enables an {@link AcmeThermoregulator ACME thermoregulator} to work with a {@link VentoThermometer Vento Thermometer}.
 * @author Ivan Georgiev
 *
 */
public class AcmeThermoregulatorToVentoThermometerAdapter implements AcmeThermoregulatorToThermometerAdapter {

	/**
	 * The Vento thermometer.
	 */
	private final VentoThermometer ventoThermometer;
	
	/**
	 * Initializes the Vento thermometer.
	 * @param ventoThermometer The Vento thermometer.
	 */
	public AcmeThermoregulatorToVentoThermometerAdapter(final VentoThermometer ventoThermometer) {
		
		this.ventoThermometer = ventoThermometer;
	}
	
	@Override
	public Integer getTemperature() {

		return ventoThermometer.getTemperature();
	}
}
