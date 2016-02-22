package org.nchristod.lp.controller;

/**
 * @author Christodoulopoulos Nikolaos
 */
public class Silo {

    ActuatorAdapter outValve;
	private ActuatorAdapter inValve;
	private SensorAdapter eLevel;
	private SensorAdapter fLevel;
	private String name;

	/**
     * Default constructor
     */
    public Silo(String name) {
    	this.name = name;
    	System.out.println(name);
    	inValve = new ActuatorAdapter(name + "In");
    	outValve = new ActuatorAdapter(name + "Out");
    	eLevel = new SensorAdapter(name + "eLevel");
    	fLevel = new SensorAdapter(name + "fLevel");
    }

    /**
     * 
     */
    public void fill() {
//    	if (outValve.getStatus()) { outValve.close(); }; // close this to be sure
		inValve.open();
		while (fLevel.getData() == "false") {
			// do nothing
		}
		inValve.close();
//		if (outValve.getStatus()) { outValve.close(); }; //again to be sure
    	System.out.println("Filled!");
    }

    /**
     * 
     */
    public void empty() {
    	outValve.open();
    	System.out.println("Emptying..");
		while (eLevel.getData() == "true") {
			// do nothing
		}
		outValve.close();
    }
    
    public void transferTo(Silo silo) {
		outValve.open();
		
		//fill
		silo.inValve.open();
		while (silo.fLevel.getData() == "false") {
			// do nothing
		}
		outValve.close();
		silo.inValve.close();
    	
    }

}