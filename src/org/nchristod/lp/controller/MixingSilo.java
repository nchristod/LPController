package org.nchristod.lp.controller;

/**
 * @author Christodoulopoulos Nikolaos
 */
public class MixingSilo extends Silo {


    private ActuatorAdapter mixer;
    
    /**
     * Default constructor
     */
    public MixingSilo(String name) {
    	super(name);
    	this.mixer = new ActuatorAdapter(name + "Mixer");
    }

    /**
     * @param: time (seconds)
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

}