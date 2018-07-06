package openweather;

import org.springframework.data.repository.CrudRepository;

// TODO create a schema named "openweather" in MySQL
// check application.properties file under resources directory

public interface WeatherInfoRepository extends CrudRepository<WeatherLog, Long> {

}
