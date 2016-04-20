package com.acme.vento_adapters;

import com.acme.thermoregulator.AcmeThermoregulator;
import com.acme.thermoregulator.AcmeThermoregulatorToHeaterAdapter;
import com.ventoelectrics.waterheater.NoPowerException;
import com.ventoelectrics.waterheater.VentoHeater;

/**
 * An adapter that enables an {@link AcmeThermoregulator ACME thermoregulator} to work with a {@link VentoHeater Vento Heater}.
 * @author Ivan Georgiev
 *
 */
public class AcmeThermoregulatorToVentoHeaterAdapter implements AcmeThermoregulatorToHeaterAdapter {

	/**
	 * The Vento heater.
	 */
	private final VentoHeater ventoHeater;
	
	/**
	 * Initializes the Vento heater.
	 * @param ventoHeater The Vento heater.
	 */
	public AcmeThermoregulatorToVentoHeaterAdapter(final VentoHeater ventoHeater) {
		
		this.ventoHeater = ventoHeater;
	}
	
	/**
	 * @throws NoPowerException Rethrown from {@link VentoHeater#enable() enable()}.
	 */
	@Override
	public void enableHeater() throws NoPowerException {
		
		ventoHeater.enable();
	}

	@Override
	public void disableHeater() {
		
		ventoHeater.disable();
	}
}
