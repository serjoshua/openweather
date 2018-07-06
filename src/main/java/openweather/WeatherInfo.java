package openweather;

import java.sql.Timestamp;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherInfo {

	private String responseId;
	private ArrayList<Forecast> list;
	private Timestamp dtimeInserted;

	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

	public void setList(ArrayList<Forecast> list) {
		this.list = list;
	}

	public void setDtimeInserted(Timestamp dtimeInserted) {
		this.dtimeInserted = dtimeInserted;
	}

	public String getResponseId() {
		return responseId;
	}

	public String getLocation() {
		return list.get(0).getName();
	}

	public String getWeather() {
		return list.get(0).getWeather().get(0).getMain() + " - " + list.get(0).getWeather().get(0).getDescription();
	}

	public String getTemperature() {
		return Double.toString(list.get(0).getMain().getTemp());
	}

	public Timestamp getDtimeInserted() {
		return dtimeInserted;
	}

	@Override
	public String toString() {
		return "WeatherInfo{" + "location=" + getLocation() + ", weather=" + getWeather() + ", temperature="
				+ getTemperature() + "}";
	}

}
