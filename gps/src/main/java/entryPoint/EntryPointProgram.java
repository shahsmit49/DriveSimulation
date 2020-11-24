package entryPoint;

import java.util.List;

public class EntryPointProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//To get base system directory on any system
//		String pathToDirectory = System.getProperty("user.dir");
		
		//getting can messages file as arguments 
		String canMessages = args[0];
		
		//getting GPS file as arguments 
		String gpsTrack = args[1];
		
		//creating the object of our parser class
		Parser parse = new Parser();
		
		//call method to parse our input files
		List<SensorObj> dataArray = parse.inputFiles(canMessages, gpsTrack);
		
		//simulator call to display all reading on console with carriage return
		SimulatorToDisplaySensorData simulatorToDisplaySensorData = new SimulatorToDisplaySensorData();
		CurveSensorPojo finalData = simulatorToDisplaySensorData.displaySensorInformation(dataArray);
		
		//calling UI to do simulation 3-4 from assignments
		UIDesign graphicalInterface = new UIDesign();
		graphicalInterface.display(finalData);
	}

//	Error: Could not find or load main class

}
