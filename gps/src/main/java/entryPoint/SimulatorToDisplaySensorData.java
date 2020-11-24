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
		int flag = 0;
		System.out.println("CurrentTime"+"\t"+"VehicleSpeed"+"\t"+"SteerAngle"+
				"\t"+"YawRate"+"\t"+"LatAccel"+"\t"+"LongAccel"+"\t"+"GPS Lat/Long");
		CurveInfo curveDetected = null;
		Float speedSum = 0F;
		Float speedCounter = 0F;
		
		long time = System.currentTimeMillis();
		long prev = 0;
		
		for(int i = 0 ; i < dataArray.size() ; ++i) {
			
			currentTime = dataArray.get(i).getTimeOffset();
			
			while(System.currentTimeMillis() < time) {
				//do nothing;
			}

			if(i + 1 < dataArray.size()) {
				try {
					long nexttime = (long)(Double.parseDouble(currentTime));
					time = time + (nexttime - prev);
					prev = nexttime;
				} catch(Exception e) {

					e.printStackTrace();
				}

			}
			
			if(dataArray.get(i).getType().equals("Displa vehicle speed(km/hr): ")) {
				
				if(flag == 1 || flag == -1) {
					speedSum = speedSum + Float.parseFloat(vehicleSpeed); 
					speedCounter += 1;
				}
				vehicleSpeed = dataArray.get(i).getValue();
			}
			if(dataArray.get(i).getType().equals("Steering wheel angle(degrees): ")) {
				
				String newValue = dataArray.get(i).getValue();
				
				Float newValueOfSteerAngle = Float.parseFloat(newValue);
//				Float oldValueOfSteerAngle = steerAngle.equals("-") ? newValueOfSteerAngle : Float.parseFloat(steerAngle);
				
				if(newValueOfSteerAngle > 9 && flag == 0) {
					flag = 1;
					
					curveDetected = new CurveInfo();
					curveDetected.setGpsLatLongStart(gpsLatLong);
					curveDetected.setDirection(false);
					curveDetected.setTimeOffset(currentTime);
					speedSum = speedSum + Float.parseFloat(vehicleSpeed); 
					speedCounter += 1;
//					System.out.println("Right turn Started"+"||"+currentTime+"||"+newValueOfSteerAngle);
				}
				if(flag == 1 && newValueOfSteerAngle < 9) {
					flag = 0;
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
				if(newValueOfSteerAngle < -9 && flag == 0) {
					flag = -1;
					curveDetected = new CurveInfo();
					curveDetected.setGpsLatLongStart(gpsLatLong);
					curveDetected.setDirection(true);
					curveDetected.setTimeOffset(currentTime);
					speedSum = speedSum + Float.parseFloat(vehicleSpeed); 
					speedCounter += 1;
//					System.out.println("left turn Started"+"||"+currentTime+"||"+newValueOfSteerAngle);
				}
				if(flag == -1 && newValueOfSteerAngle > -9) {
					flag = 0;
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
			if(dataArray.get(i).getType().equals("Vehicle yaw rate(degree/sec):  ")) {
				yawRate = dataArray.get(i).getValue();
			}
			if(dataArray.get(i).getType().equals("Vehicle lat accele(m/sec^2): ")) {
				latAccel = dataArray.get(i).getValue();
			}
			if(dataArray.get(i).getType().equals("Vehicle longi accele(m/sec^2): ")) {
				longAccel = dataArray.get(i).getValue();
			}
			if(dataArray.get(i).getType().equals("GPS data(Latitude:Longitude)")) {
				gpsLatLong = dataArray.get(i).getValue();
			}

			String s = currentTime+"\t"+vehicleSpeed+"\t"+steerAngle+
					"\t"+yawRate+"\t"+latAccel+"\t"+longAccel+"\t"+gpsLatLong;
			UIArray.add(s);
			
			int speed = vehicleSpeed.length() < 5 ? vehicleSpeed.length() : 5;
			int latAc = latAccel.length() < 5 ? latAccel.length() : 5;
			int longAc = longAccel.length() < 5 ? longAccel.length() : 5;
			int yaw = yawRate.length() < 5 ? yawRate.length() : 5;
			
			String displayData = currentTime+"\t\t"+vehicleSpeed.substring(0, speed)+"\t\t"+steerAngle+
					"\t\t"+yawRate.substring(0, yaw)+"\t\t"+latAccel.substring(0, latAc)+"\t\t"+longAccel.substring(0, longAc)+"\t\t"+gpsLatLong;
			
			System.out.print(displayData+"\r");
			
		}
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
		return finalData;
	}
}
