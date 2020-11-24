package entryPoint;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

public class UIDesign {

	SwingWorker<String, String> worker = null;
	int flag = 0;

	void display(CurveSensorPojo finalData) {

//		this.dataArray = dataArray;
//		List<CurveInfo> curveData = finalData.getCurveData();
//		for (CurveInfo curveInfo : curveData) {
//
//			System.out.println("TimeOffset: " + curveInfo.getTimeOffset());
//			System.out.println("TimeOffsetEnd: " + curveInfo.getTimeOffsetEnd());
//			System.out.println("averageVehicleSpeed: " + curveInfo.getAverageVehicleSpeed());
//			System.out.println("gpsLatLongStart: " + curveInfo.getGpsLatLongStart());
//			System.out.println("gpsLatLongEnd: " + curveInfo.getGpsLatLongEnd());
//			System.out.println("SpeedFlag: " + (curveInfo.isspeedflag() == true ? "highspeed" : "lowspeed"));
//			System.out.println("Direction: " + (curveInfo.isDirection() == true ? "left" : "right"));
//			System.out.println("----------------------------------------------------------------------");
//		}
		JFrame mainWindow;
		mainWindow = new JFrame();

		JButton startButton = new JButton("Start Simulation");
		JButton resetButton = new JButton("Reset");

		JLabel timeOffsetLabel = new JLabel("Time Offset");
		timeOffsetLabel.setFont(new Font("Serif", Font.BOLD, 14));
		JTextField timeOffsetText = new JTextField();
		JLabel speedLabel = new JLabel("Speed");
		speedLabel.setFont(new Font("Serif", Font.BOLD, 14));
		JTextField speedText = new JTextField();
		JLabel steerAngleLabel = new JLabel("Steering Angle");
		steerAngleLabel.setFont(new Font("Serif", Font.BOLD, 14));
		JTextField steerAngleText = new JTextField();
		JLabel yawRateLabel = new JLabel("Yaw Rate");
		yawRateLabel.setFont(new Font("Serif", Font.BOLD, 14));
		JTextField yawRateText = new JTextField();
		JLabel lateralAccLabel = new JLabel("Lateral Accel.");
		lateralAccLabel.setFont(new Font("Serif", Font.BOLD, 14));
		JTextField lateralAccText = new JTextField();
		JLabel LongiAccLabel = new JLabel("Longi. Acc.");
		LongiAccLabel.setFont(new Font("Serif", Font.BOLD, 14));
		JTextField LongiAccText = new JTextField();
		JLabel gpsLabel = new JLabel("GPS (Lat : Lon)");
		gpsLabel.setFont(new Font("Serif", Font.BOLD, 14));
		JTextField gpsText = new JTextField();
		
		JLabel curveDetectionLabel = new JLabel("Curve Status");
		JLabel curvePrompt = new JLabel();
		
		JLabel lastCurve = new JLabel("Previous Curve Stats");
		JLabel avgSpeedLabel = new JLabel("Average Speed: ");
		JLabel averageSpeed = new JLabel();
		JLabel startPosition = new JLabel("Curve Start Position: ");
		JLabel gpsStart = new JLabel();
		JLabel endPosition = new JLabel("Curve End Position: ");
		JLabel gpsEnd = new JLabel();
		JLabel speedTypeLabel = new JLabel("Speed Type: ");
		JLabel speedTypeField = new JLabel();
		JLabel curveTypeJLabel = new JLabel("Curve Type:");
		JLabel curveTypeField = new JLabel();
		JLabel warningMessageLabel = new JLabel("Warnings");
		JLabel distanceLabel = new JLabel("Distance to Curve: ");
		
		JLabel warning = new JLabel();
		JTextField distanceMessage = new JTextField();


		startButton.setBounds(500, 50, 200, 30);
		resetButton.setBounds(750, 50, 200, 30);
		timeOffsetLabel.setBounds(50,100,150,30);
		timeOffsetText.setBounds(10,140,150,30);
		speedLabel.setBounds(250,100,150,30);
		speedText.setBounds(210,140,150,30);
		steerAngleLabel.setBounds(450,100,150,30);
		steerAngleText.setBounds(410,140,150,30);
		yawRateLabel.setBounds(650,100,150,30);
		yawRateText.setBounds(610,140,150,30);
		lateralAccLabel.setBounds(850,100,150,30);
		lateralAccText.setBounds(810,140,150,30);
		LongiAccLabel.setBounds(1050,100,150,30);
		LongiAccText.setBounds(1010,140,150,30);
		gpsLabel.setBounds(1250,100,150,30);
		gpsText.setBounds(1210,140,170,30);
		
		curveDetectionLabel.setBounds(660, 250, 200, 30);
		curveDetectionLabel.setForeground(Color.BLUE);
		curveDetectionLabel.setFont(new Font("Serif", Font.BOLD, 20));
		curvePrompt.setBounds(615, 320, 250, 30);
		curvePrompt.setForeground(Color.RED);
		curvePrompt.setFont(new Font("Serif", Font.PLAIN, 16));
		
		lastCurve.setBounds(630, 450, 250, 40);
		lastCurve.setForeground(Color.decode("#1F6601"));
		lastCurve.setFont(new Font("Serif", Font.BOLD, 20));

		avgSpeedLabel.setBounds(300, 550, 200, 40);
		averageSpeed.setBounds(450, 550, 200, 40);
		startPosition.setBounds(285, 650, 200, 40);
		gpsStart.setBounds(450, 650, 200, 40);
		speedTypeLabel.setBounds(950, 550, 200, 40);
		speedTypeField.setBounds(1100, 550, 200, 40);
		endPosition.setBounds(935, 650, 200, 40);
		gpsEnd.setBounds(1100, 650, 200, 40);
		curveTypeJLabel.setBounds(315, 750, 200, 40);
		curveTypeField.setBounds(450, 750, 200, 40);
		
		warningMessageLabel.setBounds(680, 250, 200, 30);
		warningMessageLabel.setForeground(Color.decode("#DC7500"));
		warning.setBounds(520, 320, 500, 30);
		warningMessageLabel.setFont(new Font("Serif", Font.BOLD, 20));
		warning.setForeground(Color.RED);
		warning.setFont(new Font("Serif", Font.PLAIN, 15));
//		distanceLabel.setBounds(30, 250, 250, 40);
//		distanceMessage.setBounds(300, 300, 200, 40);


		mainWindow.add(startButton);
		mainWindow.add(resetButton);
		
		mainWindow.add(timeOffsetLabel);
		mainWindow.add(timeOffsetText);
		mainWindow.add(speedLabel);
		mainWindow.add(speedText);
		mainWindow.add(steerAngleLabel);
		mainWindow.add(steerAngleText);
		mainWindow.add(yawRateLabel);
		mainWindow.add(yawRateText);
		mainWindow.add(lateralAccLabel);
		mainWindow.add(lateralAccText);
		mainWindow.add(LongiAccLabel);
		mainWindow.add(LongiAccText);
		mainWindow.add(gpsLabel);
		mainWindow.add(gpsText);
		
		mainWindow.add(curveDetectionLabel);
		mainWindow.add(curvePrompt);
		
		mainWindow.add(lastCurve);
		mainWindow.add(averageSpeed);
		mainWindow.add(gpsStart);
		mainWindow.add(gpsEnd);
		mainWindow.add(avgSpeedLabel);
		mainWindow.add(startPosition);
		mainWindow.add(endPosition);
		mainWindow.add(speedTypeLabel);
		mainWindow.add(speedTypeField);
		mainWindow.add(curveTypeJLabel);
		mainWindow.add(curveTypeField);

		mainWindow.setSize(800, 500);
		mainWindow.setLayout(null);
		mainWindow.setVisible(true);

		// Action listeners
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// Not Working!!!
//				timeOffsetText.setText("");
//				speedText.setText("");
//				steerAngleText.setText("");
//				yawRateText.setText("");
//				lateralAccText.setText("");
//				LongiAccText.setText("");
//				gpsText.setText("");
				startButton.setEnabled(true);
				if (worker != null && !worker.isDone()) {
					worker.cancel(true);

				}
			}
		});

		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				worker = new SwingWorker<String, String>() {
					@Override
					protected String doInBackground() throws Exception {
						// TODO Auto-generated method stub
						
						if (worker != null) {
							startButton.setEnabled(false);
						}
						if (flag == 0) {
							flag = 1;
							int curveCounter = 0;
							
							long time = System.currentTimeMillis();
							long prev = 0;
							for (int i = 0; i < finalData.getUIArray().size(); i++) {
								if (isCancelled()) {
									break;
								}
								
								String[] offsetFromLinear = finalData.getUIArray().get(i).split("\\s+");

								while(System.currentTimeMillis() < time) {
									//do nothing;
								}

								if(i + 1 < finalData.getUIArray().size()) {
									String[] offsetFromLinearNext = finalData.getUIArray().get(i+1).split("\\s+");

									try {
										long nexttime = (long)(Double.parseDouble(offsetFromLinearNext[0]));
										time = time + (nexttime - prev);
										prev = nexttime;
									} catch(Exception e) {

										e.printStackTrace();
									}

								}
									
								timeOffsetText.setText(offsetFromLinear[0]);
								speedText.setText(offsetFromLinear[1]);
								steerAngleText.setText(offsetFromLinear[2]);
								yawRateText.setText(offsetFromLinear[3]);
								lateralAccText.setText(offsetFromLinear[4]);
								LongiAccText.setText(offsetFromLinear[5]);
								gpsText.setText(offsetFromLinear[6]);
								
								
								if (finalData.getCurveData().get(curveCounter).getTimeOffset()
										.equals(offsetFromLinear[0])) {
									String speed = finalData.getCurveData().get(curveCounter).isspeedflag() == true
											? "High Speed"
											: "Low Speed";
									if (finalData.getCurveData().get(curveCounter).isDirection() == true) {
										curvePrompt.setText(speed + " Left Curve Detected!!");
									} else {
										curvePrompt.setText(speed + " Right Curve Detected!!");
									}
								}
								if (finalData.getCurveData().get(curveCounter).getTimeOffsetEnd()
										.equals(offsetFromLinear[0])) {
									curvePrompt.setText("");
									averageSpeed.setText(
											finalData.getCurveData().get(curveCounter).getAverageVehicleSpeed());
									gpsStart.setText(finalData.getCurveData().get(curveCounter).getGpsLatLongStart());
									gpsEnd.setText(finalData.getCurveData().get(curveCounter).getGpsLatLongEnd());
									curveTypeField.setText(
											finalData.getCurveData().get(curveCounter).isDirection() == true ? "Left"
													: "Right");
									speedTypeField
											.setText(finalData.getCurveData().get(curveCounter).isspeedflag() == true
													? "High Speed"
													: "Low Speed");
									++curveCounter;
								}
//								Thread.sleep(1);
							}
							return null;
						} else {
							int curveCounter = 0;
							mainWindow.getContentPane().remove(avgSpeedLabel);
							mainWindow.getContentPane().remove(curvePrompt);
							mainWindow.getContentPane().remove(curveDetectionLabel);
							mainWindow.getContentPane().remove(lastCurve);
							mainWindow.getContentPane().remove(averageSpeed);
							mainWindow.getContentPane().remove(gpsStart);
							mainWindow.getContentPane().remove(gpsEnd);
							mainWindow.getContentPane().remove(avgSpeedLabel);
							mainWindow.getContentPane().remove(startPosition);
							mainWindow.getContentPane().remove(endPosition);
							mainWindow.getContentPane().remove(speedTypeLabel);
							mainWindow.getContentPane().remove(speedTypeField);
							mainWindow.getContentPane().remove(curveTypeJLabel);
							mainWindow.getContentPane().remove(curveTypeField);
							mainWindow.repaint();
							mainWindow.add(warningMessageLabel);
							mainWindow.add(warning);
							mainWindow.add(distanceLabel);
							mainWindow.add(distanceMessage);
							long time = System.currentTimeMillis();
							long prev = 0;
							for (int i = 0; i < finalData.getUIArray().size(); i++) {

								if (isCancelled()) {
									break;
								}
								String[] offsetFromLinear = finalData.getUIArray().get(i).split("\\s+");
								
								while(System.currentTimeMillis() < time) {
									//do nothing;
								}

								if(i + 1 < finalData.getUIArray().size()) {
									String[] offsetFromLinearNext = finalData.getUIArray().get(i+1).split("\\s+");

									try {
										long nexttime = (long)(Double.parseDouble(offsetFromLinearNext[0]));
										time = time + (nexttime - prev);
										prev = nexttime;
									} catch(Exception e) {

										e.printStackTrace();
									}

								}
								
								timeOffsetText.setText(offsetFromLinear[0]);
								speedText.setText(offsetFromLinear[1]);
								steerAngleText.setText(offsetFromLinear[2]);
								yawRateText.setText(offsetFromLinear[3]);
								lateralAccText.setText(offsetFromLinear[4]);
								LongiAccText.setText(offsetFromLinear[5]);
								gpsText.setText(offsetFromLinear[6]);
//								System.out.println(finalData.getUIArray().get(i));
								if (curveCounter < finalData.getCurveData().size() && finalData.getCurveData().get(curveCounter).getGpsLatLongStart()
										.equals(offsetFromLinear[6])) {
									String tmp = "";
									if (finalData.getCurveData().get(curveCounter).isDirection() == true) {
										tmp = "Left Curve Ahead!!";
									} else {
										tmp = " Right Curve Ahead!!";
									}
									tmp = tmp + " Please Maintain average speed of "
											+ finalData.getCurveData().get(curveCounter).getAverageVehicleSpeed();
									warning.setText(tmp);

									Float currenttime = Float.parseFloat(offsetFromLinear[0]);
									Float startTime = Float
											.parseFloat(finalData.getCurveData().get(curveCounter).getTimeOffset());
									Float diff = (startTime - currenttime) / 3600000F;
									Float avgSpeed = Float.parseFloat(
											finalData.getCurveData().get(curveCounter).getAverageVehicleSpeed());
									Float distance = (diff * avgSpeed) * 1000F;
									distanceMessage.setText(distance + "");

									++curveCounter;
								}
								

//								Thread.sleep(1);
//Include the average speed of the curve and the direction (left/right) in the issued warning.
							}
						}
						return null;

					}

				};
				worker.execute();

			}
		});

		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
