package entryPoint;

public class CurveInfo {
	
	//curve starting time
	private String timeOffset;
	//curve ending time
	private String timeOffsetEnd;
	//average vehicle speed throughout the curve
	private String averageVehicleSpeed;
	//curve start latitude longitude
	private String gpsLatLongStart;
	//curve end latitude longitude
	private String gpsLatLongEnd;
	
	//true left ; false right
	private boolean direction;
	
	//true highspeed ; false lowspeed
	private boolean speedflag;

	public String getTimeOffset() {
		return timeOffset;
	}

	public void setTimeOffset(String timeOffset) {
		this.timeOffset = timeOffset;
	}

	public String getAverageVehicleSpeed() {
		return averageVehicleSpeed;
	}

	public void setAverageVehicleSpeed(String averageVehicleSpeed) {
		this.averageVehicleSpeed = averageVehicleSpeed;
	}

	public String getGpsLatLongStart() {
		return gpsLatLongStart;
	}

	public void setGpsLatLongStart(String gpsLatLongStart) {
		this.gpsLatLongStart = gpsLatLongStart;
	}

	public String getGpsLatLongEnd() {
		return gpsLatLongEnd;
	}

	public void setGpsLatLongEnd(String gpsLatLongEnd) {
		this.gpsLatLongEnd = gpsLatLongEnd;
	}

	public boolean isDirection() {
		return direction;
	}

	public void setDirection(boolean direction) {
		this.direction = direction;
	}

	public boolean isspeedflag() {
		return speedflag;
	}

	public void setspeedflag(boolean speed) {
		this.speedflag = speed;
	}

	public String getTimeOffsetEnd() {
		return timeOffsetEnd;
	}

	public void setTimeOffsetEnd(String timeOffsetEnd) {
		this.timeOffsetEnd = timeOffsetEnd;
	}
	
	
}
