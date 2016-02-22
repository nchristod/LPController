package org.nchristod.lp.controller;

import java.awt.EventQueue;

import org.nchristod.lp.simulator.LpSimulator;
import org.nchristod.lp.ui.ControllerGui;

/**
 * @author Christodoulopoulos Nikolaos
 */
public class LpController {

    /**
     * Default constructor
     */
    public LpController() {
    }

    static LiquerType typeA;
    static LiquerType typeB;
    /**
     * 
     */
    private static Thread typeAThread;

    /**
     * 
     */
    private static Thread typeBThread;

    /**
     * 
     */
    private static PlantMonitor monitor;

    /**
     * 
     */
    private static ControllerGui mainWindow;

	static LpSimulator simulator;

    /**
     * 
     */
//    private static LpSimulator simulator;





    /**
     *  Launch the application
     */
	public static void main(String[] args) {
		//Run the simulator
		simulator = new LpSimulator();
		simulator.setVisible(true);
		
		//Run the controller
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow = new ControllerGui();
					mainWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public static void start(String batchTypeA, String tempTypeA, String mixTimeTypeA, String batchTypeB, String tempTypeB, String mixTimeTypeB) {
		monitor = new PlantMonitor();
		typeA = new LiquerTypeA(monitor, batchTypeA, tempTypeA, mixTimeTypeA);
		typeB = new LiquerTypeB(monitor, batchTypeB, tempTypeB, mixTimeTypeB);
		
		init();
		System.out.println("After Initialized");
	
//		Thread [] t = new Thread[2];
//		t[0] = new Thread(typeA);
//		t[1] = new Thread(typeB);
			Thread t1 = new Thread(typeA);
			Thread t2 = new Thread(typeB);
			t1.start();
			t2.start();
//		t[0].start();
//		t[1].start();
//		
//		typeAThread = new Thread(typeA);
//		typeAThread.start();
//		
//		typeBThread = new Thread(typeB);
//		typeBThread.start();
		
//		for (int i = 0; i < t.length; i++) {
//			try {
//				t[i].join();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
			
//		try {
//			t1.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally{
//			System.out.println("Inside finally");
//			mainWindow.batchTypeA.setEditable(true);
//			mainWindow.tempTypeA.setEditable(true);
//			mainWindow.mixTimeTypeA.setEditable(true);
//		}
//		try {
//			t2.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			mainWindow.batchTypeB.setEditable(true);
//			mainWindow.tempTypeB.setEditable(true);
//			mainWindow.mixTimeTypeB.setEditable(true);
//		}
		
		mainWindow.unlock();
	}

	public static void init() {
		mainWindow.progressTypeA.setValue(0);
		mainWindow.progressTypeB.setValue(0);

		mainWindow.lock();
	}

	public static void stop() {
		
		typeA.kill();
		typeB.kill();
		try {
			typeAThread.join();
			typeBThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mainWindow.unlock();

	}

	public static ControllerGui getMainWindow() {
		return mainWindow;
	}

	public static void setMainWindow(ControllerGui mainWindow) {
		LpController.mainWindow = mainWindow;
	}
	
	

}