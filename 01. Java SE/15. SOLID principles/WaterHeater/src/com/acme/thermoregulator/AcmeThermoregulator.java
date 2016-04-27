package com.acme.thermoregulator;

import com.acme.thermoregulator.adapters.AcmeThermoregulatorToHeaterAdapter;
import com.acme.thermoregulator.adapters.AcmeThermoregulatorToThermometerAdapter;

public abstract class AcmeThermoregulator extends Thread {

	private Integer upperLimitTemperature;

	private final long sleepTime;

	private final AcmeThermoregulatorToThermometerAdapter thermometerAdapter;
	
	private final AcmeThermoregulatorToHeaterAdapter heaterAdapter;
	
	public AcmeThermoregulator(final long sleepTime, final AcmeThermoregulatorToThermometerAdapter thermometerAdapter, AcmeThermoregulatorToHeaterAdapter heaterAdapter) {
				
		upperLimitTemperature = null;
		
		this.sleepTime = sleepTime;
		
		this.thermometerAdapter = thermometerAdapter;
		
		this.heaterAdapter = heaterAdapter;
	}
	
	public void setUpperLimitTemperature(final Integer upperLimitTemperature) {

		this.upperLimitTemperature = upperLimitTemperature;
	}

	@Override
	public void run() {
		
		while(true) {
			
			try {
				
				Thread.sleep(sleepTime);
				
			}
			catch(InterruptedException interruptedException) {

				return;
			}
			
			if(interrupted()) {
				
				return;
			}
			
			final Integer thermometerTemeprature = thermometerAdapter.getTemperature();
			
			System.out.println(String.format("ACME thermoregulator upper limit temperature: %d", upperLimitTemperature));
			System.out.println(String.format("Thermometer temperature: %d", thermometerTemeprature));
			
			if(upperLimitTemperature >= thermometerTemeprature) {
				
				heaterAdapter.disableHeater();
				
				continue;
			}
			
			heaterAdapter.enableHeater();
		}
	}
}
