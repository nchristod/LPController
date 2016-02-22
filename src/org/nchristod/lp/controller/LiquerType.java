package org.nchristod.lp.controller;

/**
 * @author Christodoulopoulos Nikolaos
 */
public abstract class LiquerType implements Runnable {

	protected volatile Boolean isRunning = true;
	
    protected Integer batch;

	protected Integer temp;

	protected Integer time;

	protected String name;

	protected PlantMonitor monitor;

    /**
     * 
     */
    protected Silo upperSilo;

    /**
     * 
     */
    protected Silo lowerSilo;

	/**
     * Default constructor
     */
    public LiquerType(String name, PlantMonitor monitor, String batch, String temp, String time) {
    	this.name = name;
    	this.batch = Integer.valueOf(batch);
    	this.temp = Integer.valueOf(temp);
    	this.time = Integer.valueOf(time);
    	this.monitor = monitor;
    }



	@Override
	abstract public void run();
	
	void kill() {
    	this.isRunning = false;
    }
	
}