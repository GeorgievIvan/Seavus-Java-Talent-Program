package com.acme.thermoregulator.adapters.vento;

import com.acme.thermoregulator.adapters.AcmeThermoregulatorToHeaterAdapter;
import com.ventoelectrics.waterheater.NoPowerException;
import com.ventoelectrics.waterheater.VentoHeater;

public class AcmeThermoregulatorToVentoHeaterAdapter implements AcmeThermoregulatorToHeaterAdapter {

	private final VentoHeater ventoHeater;
	
	public AcmeThermoregulatorToVentoHeaterAdapter(final VentoHeater ventoHeater) {
		
		this.ventoHeater = ventoHeater;
	}
	
	@Override
	public void enableHeater() throws NoPowerException {
		
		ventoHeater.enable();
	}

	@Override
	public void disableHeater() {
		
		ventoHeater.disable();
	}
}
