package src;

import Connections.Connection;
import data.AtmPressure;
import data.Audio;
import data.Humidity;
import data.Luminosity;
import data.Temperature;

public class SetInitialDatabase
{
	protected Audio audio;
	protected Humidity humidity;
	protected AtmPressure atmPressure;
	protected Temperature temperature;
	protected Luminosity  luminosity;
	protected long id = 0;
	
	public SetInitialDatabase(long id)
	{
		super();
		this.id = id;
		Connection con = Connection.getInstance();
	
		//Create audio
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
		
		//Create temperature
		temperature = new Temperature();
		temperature.setId(id);
		temperature.setValue(0);
		con.createTemperature(temperature);
		
		//Create luminosity
		luminosity = new Luminosity();
		luminosity.setId(id);
		luminosity.setValue(0);
		con.createLuminosity(luminosity);	
}
	
}
