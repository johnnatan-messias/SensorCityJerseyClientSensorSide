package src;

import Connections.Connection;
import data.Address;
import data.AtmPressure;
import data.Audio;
import data.GPS;
import data.Humidity;
import data.Luminosity;
import data.Sensor;
import data.Temperature;

public class SetInitialDatabase {
	protected Audio audio;
	protected Humidity humidity;
	protected AtmPressure atmPressure;
	protected Temperature temperature;
	protected Luminosity luminosity;
	protected long id = 0;

	public SetInitialDatabase(long id) {
		super();
		this.id = id;
		Connection con = Connection.getInstance();

		// Create audio
		audio = new Audio();
		audio.setId(id);
		audio.setValue(0);
		con.createAudio(audio);

		// Create humidity
		humidity = new Humidity();
		humidity.setId(id);
		humidity.setValue(0);
		con.createHumidity(humidity);

		// Create atmPressure
		atmPressure = new AtmPressure();
		atmPressure.setId(id);
		atmPressure.setValue(0);
		con.createAtmPressure(atmPressure);

		// Create temperature
		temperature = new Temperature();
		temperature.setId(id);
		temperature.setValue(0);
		con.createTemperature(temperature);

		// Create luminosity
		luminosity = new Luminosity();
		luminosity.setId(id);
		luminosity.setValue(0);
		con.createLuminosity(luminosity);
		
		//Create GPS
		GPS gps = new GPS();
		gps.setId(id);
		gps.setLatitude(47.47353);
		gps.setLongitude(19.05763);
		con.createGPS(gps);
		

		// Create Address
		Address address = new Address();
		address.setCity("Budapest");
		address.setCountry("Hungary");
		address.setId(id);
		address.setNeighbour("XI");
		address.setNum(10);
		address.setState("Budaoest");
		address.setStreet("Bogdanfy");
		address.setZip("1117");
		con.createAddress(address);

		// Create Sensor
		Sensor s = new Sensor();
		s.setName("sensor" + id);
		s.setId(id);
		s.setTimestamp(util.DateUtil.getLocalDate());
		s.setAddress(address);
		s.setAddress(address);
		con.createSensor(s);
	}

}
