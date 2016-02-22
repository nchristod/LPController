package org.nchristod.lp.controller;

public class LiquerTypeB extends LiquerType {
	
	public LiquerTypeB(PlantMonitor monitor, String batch, String temp, String time) {
		super("Type B", monitor, batch, temp, time);
		upperSilo = new HeatingSilo("s2");
		lowerSilo = new MixingSilo("s3");
	}
	
	@Override
	public void run() {

		for (int i = 1; i <= batch; i++) {
//			if (this.isRunning) {
				System.out.println(name + ": Batch No " + i + " Starting");
				upperSilo.fill();
				((HeatingSilo) upperSilo).heat(temp);
				System.out.println(name + ": Requesting Pipe...");
				while (!monitor.pipeAvailable()) {
					System.out.println(name + ": Waiting on Pipe");
				}
				upperSilo.transferTo(lowerSilo);
				System.out.println(name + ": Requesting Mixer...");
				while (!monitor.mixerAvailable()) {
					System.out.println(name + ": Waiting on Mixer");
				}
				((MixingSilo) lowerSilo).mix(time);
				lowerSilo.empty();
				System.out.println(name + " :batch No " + i + " produced!");
				LpController.getMainWindow().getProgressTypeB().setValue(i* 100 / batch);
//			} else {
//				return;
//			}
		}
	}

}
