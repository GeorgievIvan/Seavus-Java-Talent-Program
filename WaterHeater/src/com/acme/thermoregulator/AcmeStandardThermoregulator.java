package com.acme.thermoregulator;

import com.acme.thermoregulator.adapters.AcmeThermoregulatorToHeaterAdapter;
import com.acme.thermoregulator.adapters.AcmeThermoregulatorToThermometerAdapter;

public class AcmeStandardThermoregulator extends AcmeThermoregulator {
	
	public AcmeStandardThermoregulator(final AcmeThermoregulatorToThermometerAdapter thermometerAdapter, final AcmeThermoregulatorToHeaterAdapter heaterAdapter) {
		
		super(3000, thermometerAdapter, heaterAdapter);
	}
}
