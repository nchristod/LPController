package org.nchristod.lp.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.nchristod.lp.controller.LpController;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ControllerGui extends JFrame {

	private JPanel contentPane;
	public JTextField batchTypeA;
	public JTextField tempTypeA;
	public JTextField mixTimeTypeA;
	public JTextField batchTypeB;
	public JTextField tempTypeB;
	public JTextField mixTimeTypeB;
	public JProgressBar progressTypeA;
	public JProgressBar progressTypeB;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ControllerGui frame = new ControllerGui();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ControllerGui() {
		setTitle("YAC");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInitialize = new JButton("Initialize");
		btnInitialize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LpController.init();
			}
		});
		btnInitialize.setBounds(25, 240, 117, 25);
		contentPane.add(btnInitialize);
		
		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("START pressed.");
				LpController.start(batchTypeA.getText(), tempTypeA.getText(), mixTimeTypeA.getText(), batchTypeB.getText(), tempTypeB.getText(), mixTimeTypeB.getText());
			}
		});
		btnStart.setBounds(165, 240, 117, 25);
		contentPane.add(btnStart);
		
		JButton btnStop = new JButton("STOP");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("STOP pressed.");
				LpController.stop();
			}
		});
		btnStop.setBounds(308, 240, 117, 25);
		contentPane.add(btnStop);
		
		batchTypeA = new JTextField();
		batchTypeA.setText("2");
		batchTypeA.setBounds(28, 56, 114, 19);
		contentPane.add(batchTypeA);
		batchTypeA.setColumns(10);
		
		tempTypeA = new JTextField();
		tempTypeA.setText("35");
		tempTypeA.setBounds(28, 106, 114, 19);
		contentPane.add(tempTypeA);
		tempTypeA.setColumns(10);
		
		mixTimeTypeA = new JTextField();
		mixTimeTypeA.setText("5");
		mixTimeTypeA.setBounds(28, 155, 114, 19);
		contentPane.add(mixTimeTypeA);
		mixTimeTypeA.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Mixing Time");
		lblNewLabel.setBounds(25, 137, 117, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Temperature");
		lblNewLabel_1.setBounds(25, 92, 117, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblBatchNo = new JLabel("Batch No");
		lblBatchNo.setBounds(25, 41, 117, 15);
		contentPane.add(lblBatchNo);
		
		batchTypeB = new JTextField();
		batchTypeB.setText("2");
		batchTypeB.setColumns(10);
		batchTypeB.setBounds(229, 56, 114, 19);
		contentPane.add(batchTypeB);
		
		tempTypeB = new JTextField();
		tempTypeB.setText("45");
		tempTypeB.setColumns(10);
		tempTypeB.setBounds(229, 106, 114, 19);
		contentPane.add(tempTypeB);
		
		mixTimeTypeB = new JTextField();
		mixTimeTypeB.setText("10");
		mixTimeTypeB.setColumns(10);
		mixTimeTypeB.setBounds(229, 155, 114, 19);
		contentPane.add(mixTimeTypeB);
		
		JLabel label = new JLabel("Mixing Time");
		label.setBounds(226, 137, 117, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Temperature");
		label_1.setBounds(226, 92, 117, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Batch No");
		label_2.setBounds(226, 41, 117, 15);
		contentPane.add(label_2);
		
		JLabel lblTypeA = new JLabel("Type A");
		lblTypeA.setBounds(43, 12, 70, 15);
		contentPane.add(lblTypeA);
		
		JLabel lblTypeB = new JLabel("Type B");
		lblTypeB.setBounds(247, 12, 70, 15);
		contentPane.add(lblTypeB);
		
		progressTypeA = new JProgressBar();
		progressTypeA.setOrientation(SwingConstants.VERTICAL);
		progressTypeA.setBounds(165, 26, 14, 148);
		contentPane.add(progressTypeA);
		
		progressTypeB = new JProgressBar();
		progressTypeB.setOrientation(SwingConstants.VERTICAL);
		progressTypeB.setBounds(380, 26, 14, 148);
		contentPane.add(progressTypeB);
	}
	public JProgressBar getProgressTypeA() {
		return progressTypeA;
	}
	public JProgressBar getProgressTypeB() {
		return progressTypeB;
	}
	
	public void lock() {
		batchTypeA.setEditable(false);
		tempTypeA.setEditable(false);
		mixTimeTypeA.setEditable(false);
		batchTypeB.setEditable(false);
		tempTypeB.setEditable(false);
		tempTypeB.setEditable(false);
		mixTimeTypeB.setEditable(false);
	}
	
	public void unlock() {
		batchTypeA.setEditable(true);
		tempTypeA.setEditable(true);
		mixTimeTypeA.setEditable(true);
		batchTypeB.setEditable(true);
		tempTypeB.setEditable(true);
		mixTimeTypeB.setEditable(true);
	}
}
