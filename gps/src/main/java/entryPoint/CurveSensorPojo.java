package entryPoint;

import java.util.List;

public class CurveSensorPojo {
	
	//Pojo to store all sensor data and curve data
	//sensor data stored in array
	private List<String> UIArray;
	//curve data stored in list
	private List<CurveInfo> curveData;
	
	public List<String> getUIArray() {
		return UIArray;
	}
	public void setUIArray(List<String> uIArray) {
		UIArray = uIArray;
	}
	public List<CurveInfo> getCurveData() {
		return curveData;
	}
	public void setCurveData(List<CurveInfo> curveData) {
		this.curveData = curveData;
	}
	
	
}
