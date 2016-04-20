package com.acme.thermoregulator;

/**
 * This {@code abstract} class defines the basic states and behaviors of an ACME thermoregulator.
 * @author Ivan Georgiev
 *
 */
public abstract class AcmeThermoregulator extends Thread {

	/**
	 * The upper limit temperature. If this temperature is reached, the heater is turned off.
	 */
	private Integer upperLimitTemperature;
	
	/**
	 * Specifies the time interval in milliseconds between each thermometer reading.
	 */
	private final long sleepTime;
	
	/**
	 * An adapter for the thermometer.
	 */
	private final AcmeThermoregulatorToThermometerAdapter thermometerAdapter;
	
	/**
	 * An adapter for the heater.
	 */
	private final AcmeThermoregulatorToHeaterAdapter heaterAdapter;
	
	
	/**
	 * Initializes the sleep time and adapters. 
	 * @param sleepTime The time interval in milliseconds between each thermometer reading.
	 * @param thermometerAdapter An adapter for the thermometer.
	 * @param heaterAdapter An adapter for the heater.
	 */
	public AcmeThermoregulator(final long sleepTime, final AcmeThermoregulatorToThermometerAdapter thermometerAdapter, AcmeThermoregulatorToHeaterAdapter heaterAdapter) {
				
		upperLimitTemperature = null;
		
		this.sleepTime = sleepTime;
		
		this.thermometerAdapter = thermometerAdapter;
		
		this.heaterAdapter = heaterAdapter;
	}
	
	
	/**
	 * Sets the upper limit temperature.
	 * @param upperLimitTemperature The upper limit temperature.
	 */
	public void setUpperLimitTemperature(final Integer upperLimitTemperature) {

		this.upperLimitTemperature = upperLimitTemperature;
	}
	
	/**
	 * Enables the thermoregulator.
	 */
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
