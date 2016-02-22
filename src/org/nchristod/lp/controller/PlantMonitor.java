package org.nchristod.lp.controller;

import org.nchristod.lp.simulator.ActuatorIf;

/**
 * @author Christodoulopoulos Nikolaos
 */
public class PlantMonitor {

    private ActuatorIf s2Out;
	private ActuatorIf s1Out;
	private ActuatorIf s3Mixer;
	private ActuatorIf s4Mixer;

	/**
     * Default constructor
     */
    public PlantMonitor() {
    	this.s2Out = (ActuatorIf) LpController.simulator.get("s2Out");
    	this.s1Out = (ActuatorIf) LpController.simulator.get("s1Out");
    	this.s3Mixer = (ActuatorIf) LpController.simulator.get("s3Mixer");
    	this.s4Mixer = (ActuatorIf) LpController.simulator.get("s4Mixer");
    }


    /**
     * 
     */
    public Boolean pipeAvailable() {
		return !(s2Out.getStatus() || s1Out.getStatus());
    }

    /**
     * 
     */
    public Boolean mixerAvailable() {
		return !(s4Mixer.getStatus() || s3Mixer.getStatus());
    }

}