package com.acme.thermoregulator;

import com.acme.thermoregulator.adapters.AcmeThermoregulatorToHeaterAdapter;
import com.acme.thermoregulator.adapters.AcmeThermoregulatorToThermometerAdapter;

public class AcmeEfficientThermoregulator extends AcmeThermoregulator {

	public AcmeEfficientThermoregulator(final AcmeThermoregulatorToThermometerAdapter thermometerAdapter, final AcmeThermoregulatorToHeaterAdapter heaterAdapter) {
		
		super(1000, thermometerAdapter, heaterAdapter);
	}
}
