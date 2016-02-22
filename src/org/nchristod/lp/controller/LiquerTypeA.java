package org.nchristod.lp.controller;

public class LiquerTypeA extends LiquerType {

	public LiquerTypeA(PlantMonitor monitor, String batch, String temp, String time) {
		super("Type A", monitor, batch, temp, time);
		upperSilo = new Silo("s1");
		lowerSilo = new MixingHeatingSilo("s4");
	}
	
    @Override
    public void run() {
//    	if (this.isRunning) {
    	for (int i = 1; i < batch + 1; i++) {
    		System.out.println(name + ": Batch No " + i + " Starting");
    		upperSilo.fill();
    		System.out.println(name + ": Requesting Pipe...");
    		while (!monitor.pipeAvailable()) {
    			System.out.println(name + ": Waiting on Pipe");
    		}
    		upperSilo.transferTo(lowerSilo);
    		((MixingHeatingSilo) lowerSilo).heat(temp);
    		System.out.println(name + ": Requesting Mixer...");
    		while (!monitor.mixerAvailable()) {
    			System.out.println(name + ": Waiting on Mixer");
    		}
    		((MixingHeatingSilo) lowerSilo).mix(time);
    		lowerSilo.empty();
    		System.out.println(name + " :batch No " + i + " produced!");
    		LpController.getMainWindow().getProgressTypeA().setValue(i* 100 / batch);
    	}
//    	} else {
//    		System.out.println("returning?");
//    		return;
//    	}
    }

}
