package com.acme.thermoregulator.adapters.vento;

import com.acme.thermoregulator.AcmeThermoregulator;
import com.ventoelectrics.waterheater.VentoThermoregulator;

public class VentoWaterHeaterSystemToAcmeThermoregulatorAdapter implements VentoThermoregulator {

	private final AcmeThermoregulator acmeThermoregulator;
	
	public VentoWaterHeaterSystemToAcmeThermoregulatorAdapter(final AcmeThermoregulator acmeThermoregulator) {
		
		this.acmeThermoregulator = acmeThermoregulator;
	}

	@Override
	public void enablePower() {
		
		acmeThermoregulator.start();
	}

	@Override
	public void disablePower() {
		
		acmeThermoregulator.interrupt();
	}
	
	@Override
	public void setTemperature(Integer temperature) {
		
		acmeThermoregulator.setUpperLimitTemperature(temperature);
	}
}
