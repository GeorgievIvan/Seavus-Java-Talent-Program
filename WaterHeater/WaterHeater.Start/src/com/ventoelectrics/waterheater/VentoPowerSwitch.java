package com.ventoelectrics.waterheater;

import java.util.ArrayList;
import java.util.List;

public class VentoPowerSwitch {
	
	private List<VentoPoweredDevice> poweredDevices = new ArrayList<VentoPoweredDevice>();
	
	public void controlPowerFor(VentoPoweredDevice poweredDevice) {
		poweredDevices.add(poweredDevice);
	}
	
	public void turnOn() {
		for (VentoPoweredDevice device : poweredDevices) {
			device.enablePower();
		}
	}
	
	public void turnOff() {
		for (VentoPoweredDevice device : poweredDevices) {
			device.disablePower();
		}
	}
}
