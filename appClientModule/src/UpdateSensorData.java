package src;

import sensor.SerialTest;
import Connections.Connection;
import data.AtmPressure;
import data.Audio;
import data.Humidity;
import data.Luminosity;
import data.Temperature;

public class UpdateSensorData 
{
	protected Audio audio;
	protected Humidity humidity;
	protected AtmPressure atmPressure;
	protected Temperature temperature;
	protected Luminosity  luminosity;
	private double audioValue;
	private double humidityValue;
	private double atmPressureValue;
	private double temperatureValue;
	private double luminosityValue;
	private long id;
	protected SerialTest serialTest;
	protected Connection con;
	
	
	

	public UpdateSensorData(double audioValue, double humidityValue,
			double atmPressureValue, double temperatureValue,
			double luminosityValue) {
		super();
		this.audioValue = audioValue;
		this.humidityValue = humidityValue;
		this.atmPressureValue = atmPressureValue;
		this.temperatureValue = temperatureValue;
		this.luminosityValue = luminosityValue;
	}

	public UpdateSensorData()
	{
		
	}
	
	public void update(double audioValue, double humidityValue,
			double atmPressureValue, double temperatureValue,
			double luminosityValue,long id)
	{   
		Connection con= Connection.getInstance();
		//update audio
		audio = con.readAudio(id);
		audio.setValue(audioValue);
		con.updateAudio(audio);
		System.out.println(con.readAudio(id).getValue());
		
		//update humidity
		humidity = con.readHumidity(id);
		humidity.setValue(humidityValue);
		con.updateHumidity(humidity);
		System.out.println(con.readHumidity(id).getValue());
		
		//update atemPressure
		atmPressure = con.readAtmPressure(id);
		atmPressure.setValue(atmPressureValue);
		con.updateAtmPressure(atmPressure);
		System.out.println(con.readAtmPressure(id).getValue());
		
		//update tempereture 
		temperature = con.readTemperature(id);
		temperature.setValue(temperatureValue);
		con.updateTemperature(temperature);
		System.out.println(con.readTemperature(id).getValue());
		
		//update luminosity
		luminosity = con.readLuminosity(id);
		luminosity.setValue(luminosityValue);
		con.updateLuminosity(luminosity);
		System.out.println(con.readLuminosity(id).getValue());
		
	}
}
