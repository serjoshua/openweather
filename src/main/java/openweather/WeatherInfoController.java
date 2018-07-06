package openweather;

import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherInfoController {

	ArrayList<WeatherInfo> weatherArray = new ArrayList<WeatherInfo>();
	@Autowired
	private WeatherInfoRepository weatherInfoRepository;

	// TODO endopint should have a paramater "location" specifying the city,
	// e.g, London, Prague, San Francisco
	@RequestMapping(value = "/forecast", method = RequestMethod.GET)
	public @ResponseBody WeatherInfo getWeatherForecast(
			@RequestParam(value = "location", defaultValue = "Manila") String location) {

		RestTemplate restTemplate = new RestTemplate();
		// TODO need appid to be updated
		WeatherInfo weatherInfo = restTemplate.getForObject(
				"https://openweathermap.org/data/2.5/find?q={location}&appid=b6907d289e10d714a6e88b30761fae22&_=1530892351202",
				WeatherInfo.class, location);

		weatherInfo.setResponseId(UUID.randomUUID().toString());
		weatherInfo.setDtimeInserted(new Timestamp(new Date().getTime()));

		System.out.println(weatherInfo.toString());
		System.out.println(weatherArray.size());

		if (weatherArray.size() < 5)
			weatherArray.add(weatherInfo);
		else {
			weatherArray.remove(0);
			weatherArray.add(weatherInfo);
		}

		return weatherInfo;
	}

	@RequestMapping(value = "/forecast/add", method = RequestMethod.GET)
	public @ResponseBody String addWeatherForecast() {

		ArrayList<WeatherLog> wiList = new ArrayList<WeatherLog>();
		WeatherLog wi = new WeatherLog();

		for (WeatherInfo weatherInfo : weatherArray) {

			wi.setResponseId(weatherInfo.getResponseId());
			wi.setLocation(weatherInfo.getLocation());
			wi.setActualWeather(weatherInfo.getWeather());
			wi.setTemperature(weatherInfo.getTemperature());
			wi.setDtimeInserted(weatherInfo.getDtimeInserted());

			wiList.add(wi);

			System.out.println(weatherInfo.toString());
		}

		weatherInfoRepository.saveAll(wiList);

		return "Added";
	}

}
