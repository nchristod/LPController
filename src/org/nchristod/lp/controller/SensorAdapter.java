package org.nchristod.lp.controller;

import org.nchristod.lp.simulator.Senseable;

/**
 * @author Christodoulopoulos Nikolaos
 */
public class SensorAdapter {

    private Senseable sensor;


	/**
     * Default constructor
     */
    public SensorAdapter(String name) {
    	this.sensor = (Senseable) LpController.simulator.get(name);
//			try {
//				this.sensor = (Senseable) Naming.lookup("//localhost/" + name);
//			} catch (MalformedURLException | RemoteException | NotBoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
    }


    /**
     * 
     */
    public String getData() {
		return (sensor.getData());
    }

}