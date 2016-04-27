package com.ventoelectrics.waterheater;

import com.acme.thermoregulator.AcmeStandardThermoregulator;
import com.acme.thermoregulator.adapters.vento.AcmeThermoregulatorToVentoHeaterAdapter;
import com.acme.thermoregulator.adapters.vento.AcmeThermoregulatorToVentoThermometerAdapter;
import com.acme.thermoregulator.adapters.vento.VentoWaterHeaterSystemToAcmeThermoregulatorAdapter;

public class StandardVentoWaterHeaterApp {

	public static void main(String[] args) throws Exception {

		final VentoThermometer ventoThermometer = new VentoThermometer();
		final VentoHeater ventoHeater = new VentoHeater();
		final VentoPowerSwitch ventoPowerSwitch = new VentoPowerSwitch();

		final AcmeThermoregulatorToVentoThermometerAdapter thermometerAdapter = new AcmeThermoregulatorToVentoThermometerAdapter(ventoThermometer);
		final AcmeThermoregulatorToVentoHeaterAdapter heaterAdapter = new AcmeThermoregulatorToVentoHeaterAdapter(ventoHeater);
		final AcmeStandardThermoregulator acmeStandardThermoregulator = new AcmeStandardThermoregulator(thermometerAdapter, heaterAdapter);
		final VentoWaterHeaterSystemToAcmeThermoregulatorAdapter ventoWaterHeaterSystemToACMEThermoregulatorAdapter = new VentoWaterHeaterSystemToAcmeThermoregulatorAdapter(acmeStandardThermoregulator);
		
		final VentoThermoregulator ventoThermoregulator = ventoWaterHeaterSystemToACMEThermoregulatorAdapter; // ACME standard thermoregulator instance. 

		ventoPowerSwitch.controlPowerFor(ventoThermoregulator);
		ventoPowerSwitch.controlPowerFor(ventoHeater);
		ventoPowerSwitch.controlPowerFor(ventoThermometer);

		VentoWaterHeaterApp.run(ventoThermoregulator, ventoPowerSwitch);
	}
}
