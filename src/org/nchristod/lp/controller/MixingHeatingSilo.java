package org.nchristod.lp.controller;

/**
 * @author Christodoulopoulos Nikolaos
 */
public class MixingHeatingSilo extends Silo {

    private ActuatorAdapter mixer;
    private ActuatorAdapter resistor;
	private SensorAdapter thermometer;
	

    /**
     * Default constructor
     * @param name 
     */
    public MixingHeatingSilo(String name) {
    	super(name);
    	this.mixer = new ActuatorAdapter(name + "Mixer");
    	this.resistor = new ActuatorAdapter(name + "Resistor");
    	this.thermometer = new SensorAdapter(name + "Thermometer");
    }

    /**
     * @param time (secs)
     * 
     */
    public void mix(Integer time) {
		mixer.open();
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mixer.close();
    	System.out.println("Mixed!");
    }

    /**
     * @param temp 
     * 
     */
    public void heat(Integer temp) {
    	resistor.open();
		while( Integer.valueOf(thermometer.getData()) < temp){
			//do nothing
		}
		resistor.close();
    	System.out.println("Heated!");
    }

}