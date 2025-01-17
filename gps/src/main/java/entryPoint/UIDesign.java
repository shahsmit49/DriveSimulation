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

		JFrame mainWindow;
		mainWindow = new JFrame();
		// Simulation and Reset Buttons
		JButton startButton = new JButton("Start Simulation");
		JButton resetButton = new JButton("Reset");
		// Columns Headings
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
		// Section 2 Label to show curve warnings
		JLabel curveDetectionLabel = new JLabel("Curve Status");
		JLabel curvePrompt = new JLabel();
		// Section 3 Label to show data from previous curve
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
		JLabel distanceLabel = new JLabel("Distance to Curve(meters): ");
		// Labels to display warning when simulating the second time (Question 3 & 4)
		JLabel warning = new JLabel();
		JTextField distanceMessage = new JTextField();

		// Positioning of Labels, Buttons and Text Fields
		startButton.setBounds(500, 50, 200, 30);
		resetButton.setBounds(750, 50, 200, 30);
		timeOffsetLabel.setBounds(50, 100, 150, 30);
		timeOffsetText.setBounds(10, 140, 150, 30);
		speedLabel.setBounds(250, 100, 150, 30);
		speedText.setBounds(210, 140, 150, 30);
		steerAngleLabel.setBounds(450, 100, 150, 30);
		steerAngleText.setBounds(410, 140, 150, 30);
		yawRateLabel.setBounds(650, 100, 150, 30);
		yawRateText.setBounds(610, 140, 150, 30);
		lateralAccLabel.setBounds(850, 100, 150, 30);
		lateralAccText.setBounds(810, 140, 150, 30);
		LongiAccLabel.setBounds(1050, 100, 150, 30);
		LongiAccText.setBounds(1010, 140, 150, 30);
		gpsLabel.setBounds(1250, 100, 150, 30);
		gpsText.setBounds(1210, 140, 170, 30);
		// Positioning of Section 2 Labels
		curveDetectionLabel.setBounds(660, 250, 200, 30);
		curveDetectionLabel.setForeground(Color.BLUE);
		curveDetectionLabel.setFont(new Font("Serif", Font.BOLD, 20));
		curvePrompt.setBounds(615, 300, 250, 30);
		curvePrompt.setForeground(Color.RED);
		curvePrompt.setFont(new Font("Serif", Font.PLAIN, 16));
		// Positioning of Section 3 Labels
		lastCurve.setBounds(630, 420, 250, 40);
		lastCurve.setForeground(Color.decode("#1F6601"));
		lastCurve.setFont(new Font("Serif", Font.BOLD, 20));
		// Positioning of data Fields in Section 3
		avgSpeedLabel.setBounds(300, 500, 200, 40);
		averageSpeed.setBounds(450, 500, 200, 40);
		startPosition.setBounds(285, 580, 200, 40);
		gpsStart.setBounds(450, 580, 200, 40);
		speedTypeLabel.setBounds(950, 500, 200, 40);
		speedTypeField.setBounds(1100, 500, 200, 40);
		endPosition.setBounds(935, 580, 200, 40);
		gpsEnd.setBounds(1100, 580, 200, 40);
		curveTypeJLabel.setBounds(315, 660, 200, 40);
		curveTypeField.setBounds(450, 660, 200, 40);
		// Warning Message positioning for simulation after the first one
		warningMessageLabel.setBounds(680, 250, 200, 30);
		warningMessageLabel.setForeground(Color.decode("#DC7500"));
		warning.setBounds(520, 320, 500, 30);
		warningMessageLabel.setFont(new Font("Serif", Font.BOLD, 20));
		warning.setForeground(Color.RED);
		warning.setFont(new Font("Serif", Font.PLAIN, 15));
		distanceLabel.setBounds(520, 400, 250, 40);
		distanceMessage.setBounds(700, 400, 200, 40);

		// Adding all components of Main JFrame
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
		// Reset Button
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// To verify that the thread ends before updating Labels
				if (worker != null && !worker.isDone()) {
					worker.cancel(true);

				}
				// Updating labels when reset button is clicked
				timeOffsetText.setText("--");
				speedText.setText("--");
				steerAngleText.setText("--");
				yawRateText.setText("--");
				lateralAccText.setText("--");
				LongiAccText.setText("--");
				gpsText.setText("--");
				startButton.setEnabled(true);
			}
		});
		// Simulation Button
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Creating Swing Worker class to manage threads
				worker = new SwingWorker<String, String>() {
					@Override
					protected String doInBackground() throws Exception {
						// TODO Auto-generated method stub
						
						if (worker != null) {
							startButton.setEnabled(false);
						}
						/*
						 * Flag to differentiate between simulation 1 (Question 2) and eventual
						 * Simulations (Question 3 & 4)
						 */
						if (flag == 0) {

							flag = 1;
							int curveCounter = 0;
							
							//variables to wait till offset time is reached
							long time = System.currentTimeMillis();
							long prev = 0;
							
							for (int i = 0; i < finalData.getUIArray().size(); i++) {
								if (isCancelled()) {
									break;
								}
								// Splitting all string values to display data from sensors
								String[] offsetFromLinear = finalData.getUIArray().get(i).split("\\s+");
								
								//code to wait till offset time is reached
								while(System.currentTimeMillis() < time) {
									//do nothing;
								}
								
								//calculating next time 
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
								
								//setting data on UI
								timeOffsetText.setText(offsetFromLinear[0]);
								speedText.setText(offsetFromLinear[1]);
								steerAngleText.setText(offsetFromLinear[2]);
								yawRateText.setText(offsetFromLinear[3]);
								lateralAccText.setText(offsetFromLinear[4]);
								LongiAccText.setText(offsetFromLinear[5]);
								gpsText.setText(offsetFromLinear[6]);
								
								// Comparing offsets to established if curve has been detected
								if (finalData.getCurveData().get(curveCounter).getTimeOffset()
										.equals(offsetFromLinear[0])) {
									// Using curveDataObject to establish Speed and Direction type
									// True -> High Speed, Left Curve
									// False -> Low Speed, Right Curve
									String speed = finalData.getCurveData().get(curveCounter).isspeedflag() == true
											? "High Speed"
											: "Low Speed";
									if (finalData.getCurveData().get(curveCounter).isDirection() == true) {
										curvePrompt.setText(speed + " Left Curve Detected!!");
									} else {
										curvePrompt.setText(speed + " Right Curve Detected!!");
									}
								}
								// Storing details from Previous Curve
								if (finalData.getCurveData().get(curveCounter).getTimeOffsetEnd()
										.equals(offsetFromLinear[0])) {
									curvePrompt.setText("");
									// Updating Average speed during curve
									averageSpeed.setText(
											finalData.getCurveData().get(curveCounter).getAverageVehicleSpeed());
									// Updating curve start position
									gpsStart.setText(finalData.getCurveData().get(curveCounter).getGpsLatLongStart());
									// updating curve end position
									gpsEnd.setText(finalData.getCurveData().get(curveCounter).getGpsLatLongEnd());
									// updating curve direction
									curveTypeField.setText(
											finalData.getCurveData().get(curveCounter).isDirection() == true ? "Left"
													: "Right");
									// updating curve speed
									speedTypeField
											.setText(finalData.getCurveData().get(curveCounter).isspeedflag() == true
													? "High Speed"
													: "Low Speed");
									++curveCounter;
								}

							}
							
							return null;
						} else {
							// Else condition to handle simulation 2 and onwards
							int curveCounter = 0;
							// Removing all the components and repainting the JFrames
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
							// Adding components to display warning message and distance to curve
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
								// Splitting all string values to display data from sensors
								String[] offsetFromLinear = finalData.getUIArray().get(i).split("\\s+");
								
								//code to wait till specific time is achieved
								while(System.currentTimeMillis() < time) {
									//do nothing;
								}
								
								//updating next time to wait
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
								
								//setting data on UI
								timeOffsetText.setText(offsetFromLinear[0]);
								speedText.setText(offsetFromLinear[1]);
								steerAngleText.setText(offsetFromLinear[2]);
								yawRateText.setText(offsetFromLinear[3]);
								lateralAccText.setText(offsetFromLinear[4]);
								LongiAccText.setText(offsetFromLinear[5]);
								gpsText.setText(offsetFromLinear[6]);
								
								//variable to store distance to next curve
								double distance = 0;
								if(curveCounter < finalData.getCurveData().size()) {
									String coordinates[] = offsetFromLinear[6].split(":");
									
									//calculating next curve distance from latitude and longitude 
									double latitudeCurrent = Double.parseDouble(coordinates[0]);
									double longitudeCurrent = Double.parseDouble(coordinates[1]);
									
									String coordinatesCurve[] = finalData.getCurveData().get(curveCounter).getGpsLatLongStart().split(":");
									double latitudeCurve = Double.parseDouble(coordinatesCurve[0]);
									double longitudeCurve = Double.parseDouble(coordinatesCurve[1]);
									
									//getting distance in meters
									distance = distance(latitudeCurrent,longitudeCurrent,latitudeCurve,longitudeCurve)*1000;
								}
								
								//displaying distance only if the curve is in next 100 meters
								if (distance < 100.0 && curveCounter < finalData.getCurveData().size()) {

									String tmp = "";
									// Establishing direction of the incoming curve
									if (finalData.getCurveData().get(curveCounter).isDirection() == true) {
										tmp = "Left Curve Ahead!!";
									} else {
										tmp = " Right Curve Ahead!!";
									}
									// Calculating average speed to display along with warning message
									tmp = tmp + " Please Maintain average speed of "
											+ finalData.getCurveData().get(curveCounter).getAverageVehicleSpeed();
									warning.setText(tmp);

									distanceMessage.setText(distance + "");
				
								}
								
								//logic to move counter to check for next curve
								if(curveCounter < finalData.getCurveData().size() && finalData.getCurveData().get(curveCounter).getTimeOffset().equals(offsetFromLinear[0])) {
									warning.setText("");
									++curveCounter;
								}
								//if inside the curve remove curve warning
								if(curveCounter == finalData.getCurveData().size()) {
									warning.setText("");
								}
								
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
	
	//Haversine method to calculate distance in meters between 2 coordinates
	private static double distance(double lat1, double lon1, double lat2, double lon2) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			dist = dist * 1.609344;
			return (dist);
		}
	}
}
