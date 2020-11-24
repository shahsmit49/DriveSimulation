package entryPoint;

import java.util.ArrayList;
import java.util.List;

public class SimulatorToDisplaySensorData {
	
	private String currentTime = "-";
	private String vehicleSpeed = "-";
	private String steerAngle = "-";
	private String yawRate = "-";
	private String latAccel = "-";
	private String longAccel = "-";
	private String gpsLatLong = "-";
	
	public CurveSensorPojo displaySensorInformation(List<SensorObj> dataArray) {
		
		//defining UI array which will hold all sensor data at specific offset
		List<String> UIArray = new ArrayList<String>();
		
		//data structure to 
		List<CurveInfo> curveData = new ArrayList<CurveInfo>();
		
		//data structure to return multiple values
		CurveSensorPojo finalData = new CurveSensorPojo();
		
		//to detect when curve is ending
		int flag = 0;
		
		//for simulation 4
		System.out.println("CurrentTime"+"\t"+"VehicleSpeed"+"\t"+"SteerAngle"+
				"\t"+"YawRate"+"\t\t"+"LatAccel"+"\t"+"LongAccel"+"\t"+"GPS Lat/Long");
		
		//curve object
		CurveInfo curveDetected = null;
		
		//data for averaging speed
		Float speedSum = 0F;
		Float speedCounter = 0F;
		
		//data to run program on system speed
		long time = System.currentTimeMillis();
		long prev = 0;
		
		for(int i = 0 ; i < dataArray.size() ; ++i) {
			
			//code to run program on system speed
			currentTime = dataArray.get(i).getTimeOffset();
			
			//wait till offset value is reached
			while(System.currentTimeMillis() < time) {
				//do nothing;
			}
			
			//calculating next time
			if(i + 1 < dataArray.size()) {
				try {
					long nexttime = (long)(Double.parseDouble(currentTime));
					time = time + (nexttime - prev);
					prev = nexttime;
				} catch(Exception e) {
					
					e.printStackTrace();
				}

			}
			
			//getting vehicle speed
			if(dataArray.get(i).getType().equals("Displa vehicle speed(km/hr): ")) {
				
				if(flag == 1 || flag == -1) {
					speedSum = speedSum + Float.parseFloat(vehicleSpeed); 
					speedCounter += 1;
				}
				vehicleSpeed = dataArray.get(i).getValue();
			}
			
			//getting wheel angle and also detecting curves
			if(dataArray.get(i).getType().equals("Steering wheel angle(degrees): ")) {
				
				String newValue = dataArray.get(i).getValue();
				
				Float newValueOfSteerAngle = Float.parseFloat(newValue);
				
				//thresold value 9 to ignore minor steering angle changes and code to detect right turn
				if(newValueOfSteerAngle > 9 && flag == 0) {
					flag = 1;
					
					//curve detected and then storing curve info
					curveDetected = new CurveInfo();
					curveDetected.setGpsLatLongStart(gpsLatLong);
					curveDetected.setDirection(false);
					curveDetected.setTimeOffset(currentTime);
					speedSum = speedSum + Float.parseFloat(vehicleSpeed); 
					speedCounter += 1;
//					System.out.println("Right turn Started"+"||"+currentTime+"||"+newValueOfSteerAngle);
				}
				
				//to detect that right curve is ended
				if(flag == 1 && newValueOfSteerAngle < 9) {
					
					flag = 0;
					
					//curve ended to adding final data in curve object
					curveDetected.setGpsLatLongEnd(gpsLatLong);
					float averageSpeed = (speedSum/speedCounter);
					curveDetected.setAverageVehicleSpeed(averageSpeed+"");
					if(averageSpeed > 50) {
						curveDetected.setspeedflag(true);
					} else {
						curveDetected.setspeedflag(false);
					}
					curveDetected.setTimeOffsetEnd(currentTime);
					curveData.add(curveDetected);
					speedSum = 0F;
					speedCounter = 0F;
//					System.out.println("Right turn Ended"+"||"+currentTime+"||"+newValueOfSteerAngle);
				}
				
				//code to detect left curve with thresold degree of -9
				if(newValueOfSteerAngle < -9 && flag == 0) {
					flag = -1;
					
					//storing start curve data
					curveDetected = new CurveInfo();
					curveDetected.setGpsLatLongStart(gpsLatLong);
					curveDetected.setDirection(true);
					curveDetected.setTimeOffset(currentTime);
					speedSum = speedSum + Float.parseFloat(vehicleSpeed); 
					speedCounter += 1;
//					System.out.println("left turn Started"+"||"+currentTime+"||"+newValueOfSteerAngle);
				}
				
				//code to detect left curve ending with threshold value of -9
				if(flag == -1 && newValueOfSteerAngle > -9) {
					flag = 0;
					
					//storing left curve data
					curveDetected.setGpsLatLongEnd(gpsLatLong);
					float averageSpeed = (speedSum/speedCounter);
					curveDetected.setAverageVehicleSpeed(averageSpeed+"");
					if(averageSpeed > 50) {
						curveDetected.setspeedflag(true);
					} else {
						curveDetected.setspeedflag(false);
					}
					curveDetected.setTimeOffsetEnd(currentTime);
					curveData.add(curveDetected);
					speedSum = 0F;
					speedCounter = 0F;
//					System.out.println("left turn Ended"+"||"+currentTime+"||"+newValueOfSteerAngle);
				}
				steerAngle = newValue;
			}
			
			//getting yaw rate
			if(dataArray.get(i).getType().equals("Vehicle yaw rate(degree/sec):  ")) {
				yawRate = dataArray.get(i).getValue();
			}
			
			//getting lateral acceleration
			if(dataArray.get(i).getType().equals("Vehicle lat accele(m/sec^2): ")) {
				latAccel = dataArray.get(i).getValue();
			}
			
			//getting longitudinal acceleration
			if(dataArray.get(i).getType().equals("Vehicle longi accele(m/sec^2): ")) {
				longAccel = dataArray.get(i).getValue();
			}
			
			//getting gps latitude longitude
			if(dataArray.get(i).getType().equals("GPS data(Latitude:Longitude)")) {
				gpsLatLong = dataArray.get(i).getValue();
			}

			
			//storing all that data in string and adding it to array to display it on UI
			String s = currentTime+"\t"+vehicleSpeed+"\t"+steerAngle+
					"\t"+yawRate+"\t"+latAccel+"\t"+longAccel+"\t"+gpsLatLong;
			UIArray.add(s);
			
			//splitting data for asthetic purpose to display on console
			int speed = vehicleSpeed.length() < 5 ? vehicleSpeed.length() : 5;
			int latAc = latAccel.length() < 5 ? latAccel.length() : 5;
			int longAc = longAccel.length() < 5 ? longAccel.length() : 5;
			int yaw = yawRate.length() < 5 ? yawRate.length() : 5;
			
			
			String displayData = currentTime+"\t\t"+vehicleSpeed.substring(0, speed)+"\t\t"+steerAngle+
					"\t\t"+yawRate.substring(0, yaw)+"\t\t"+latAccel.substring(0, latAc)+"\t\t"+longAccel.substring(0, longAc)+"\t\t"+gpsLatLong;
			
			//displaying data on console
			System.out.print(displayData+"\r");
			
		}
		
		//if the curve didnot ended on last reading then taking last reading as curve end
		if(flag == 1 || flag == -1) {
			curveDetected.setGpsLatLongEnd(gpsLatLong);
			float averageSpeed = (speedSum/speedCounter);
			curveDetected.setAverageVehicleSpeed(averageSpeed+"");
			if(averageSpeed > 50) {
				curveDetected.setspeedflag(true);
			} else {
				curveDetected.setspeedflag(false);
			}
			curveDetected.setTimeOffsetEnd(currentTime);
			curveData.add(curveDetected);
			speedSum = 0F;
			speedCounter = 0F;
		}
		finalData.setCurveData(curveData);
		finalData.setUIArray(UIArray);
		
		//returning pojo that containns all sensor data and curve info.
		return finalData;
	}
}
