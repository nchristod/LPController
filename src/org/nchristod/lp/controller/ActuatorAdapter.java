package org.nchristod.lp.controller;

import org.nchristod.lp.simulator.ActuatorIf;

/**
 * @author Christodoulopoulos Nikolaos
 */
public class ActuatorAdapter {
	
    private ActuatorIf actuator;

	/**
     * Default constructor
     */
    public ActuatorAdapter(String name) {
    	this.actuator = (ActuatorIf) LpController.simulator.get(name);
		
    }


    /**
     * 
     */
    public void open() {
		actuator.open();
    }

    /**
     * 
     */
    public void close() {
		actuator.close();
    }


	public boolean getStatus() {
		return actuator.getStatus();
	}

}