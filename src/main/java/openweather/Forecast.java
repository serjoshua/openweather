package openweather;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Forecast {

	private Temperature main;
	private ArrayList<Weather> weather;
	private String name;

	public Temperature getMain() {
		return main;
	}

	public ArrayList<Weather> getWeather() {
		return weather;
	}

	public String getName() {
		return name;
	}

	public void setMain(Temperature main) {
		this.main = main;
	}

	public void setWeather(ArrayList<Weather> weather) {
		this.weather = weather;
	}

	public void setName(String name) {
		this.name = name;
	}
}
