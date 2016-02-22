package org.nchristod.lp.controller;

/**
 * @author Christodoulopoulos Nikolaos
 */
public class HeatingSilo extends Silo {

	private ActuatorAdapter resistor;
    private SensorAdapter thermometer;

	/**
     * Default constructor
     * @param name 
     */
    public HeatingSilo(String name) {
    	super(name);
    	this.resistor = new ActuatorAdapter(name + "Resistor");
    	this.thermometer = new SensorAdapter(name + "Thermometer");
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
