package openweather;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WeatherLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String responseId;
	private String location;
	private String actualWeather;
	private String temperature;
	private Timestamp dtimeInserted;

	public Long getId() {
		return id;
	}

	public String getResponseId() {
		return responseId;
	}

	public String getLocation() {
		return location;
	}

	public String getActualWeather() {
		return actualWeather;
	}

	public String getTemperature() {
		return temperature;
	}

	public Timestamp getDtimeInserted() {
		return dtimeInserted;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setActualWeather(String actualWeather) {
		this.actualWeather = actualWeather;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public void setDtimeInserted(Timestamp dtimeInserted) {
		this.dtimeInserted = dtimeInserted;
	}

}
