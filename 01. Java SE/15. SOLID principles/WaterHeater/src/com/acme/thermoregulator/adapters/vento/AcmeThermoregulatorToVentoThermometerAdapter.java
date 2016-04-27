package com.acme.thermoregulator.adapters.vento;

import com.acme.thermoregulator.adapters.AcmeThermoregulatorToThermometerAdapter;
import com.ventoelectrics.waterheater.VentoThermometer;

public class AcmeThermoregulatorToVentoThermometerAdapter implements AcmeThermoregulatorToThermometerAdapter {

	private final VentoThermometer ventoThermometer;
	
	public AcmeThermoregulatorToVentoThermometerAdapter(final VentoThermometer ventoThermometer) {
		
		this.ventoThermometer = ventoThermometer;
	}
	
	@Override
	public Integer getTemperature() {

		return ventoThermometer.getTemperature();
	}
}
