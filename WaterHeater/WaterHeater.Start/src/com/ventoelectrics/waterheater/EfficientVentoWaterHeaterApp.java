package com.ventoelectrics.waterheater;

import com.acme.thermoregulator.AcmeEfficientThermoregulator;
import com.acme.vento_adapters.AcmeThermoregulatorToVentoHeaterAdapter;
import com.acme.vento_adapters.AcmeThermoregulatorToVentoThermometerAdapter;
import com.acme.vento_adapters.VentoWaterHeaterSystemToAcmeThermoregulatorAdapter;

public class EfficientVentoWaterHeaterApp {

	public static void main(String[] args) throws Exception {

		final VentoThermometer ventoThermometer = new VentoThermometer();
		final VentoHeater ventoHeater = new VentoHeater();
		final VentoPowerSwitch ventoPowerSwitch = new VentoPowerSwitch();
		
		final AcmeThermoregulatorToVentoThermometerAdapter thermometerAdapter = new AcmeThermoregulatorToVentoThermometerAdapter(ventoThermometer);
		final AcmeThermoregulatorToVentoHeaterAdapter heaterAdapter = new AcmeThermoregulatorToVentoHeaterAdapter(ventoHeater);
		final AcmeEfficientThermoregulator acmeEfficientThermoregulator = new AcmeEfficientThermoregulator(thermometerAdapter, heaterAdapter);
		final VentoWaterHeaterSystemToAcmeThermoregulatorAdapter ventoWaterHeaterSystemToACMEThermoregulatorAdapter = new VentoWaterHeaterSystemToAcmeThermoregulatorAdapter(acmeEfficientThermoregulator);
		
		final VentoThermoregulator ventoThermoregulator = ventoWaterHeaterSystemToACMEThermoregulatorAdapter; // ACME efficient thermoregulator instance. 

		ventoPowerSwitch.controlPowerFor(ventoThermoregulator);
		ventoPowerSwitch.controlPowerFor(ventoHeater);
		ventoPowerSwitch.controlPowerFor(ventoThermometer);

		VentoWaterHeaterApp.run(ventoThermoregulator, ventoPowerSwitch);
	}
}
