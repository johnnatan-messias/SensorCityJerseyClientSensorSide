package Connections;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import data.AddressData;
import data.AtmPressureData;
import data.AudioData;
import data.GPSData;
import data.HumidityData;
import data.LuminosityData;
import data.SensorData;
import data.TemperatureData;
import data.UsersData;

public class Connection {

	private static Connection con = null;
	private String URL = "http://localhost:8080/EJBSensorCity/rest/";

	private Client client;
	private WebTarget target;

	private Connection() {
		this.client = ClientBuilder.newClient();
	}

	public static Connection getInstance() {
		if (con == null) {
			con = new Connection();
		}
		return con;
	}

	public void createTemperature(TemperatureData temperature) {
		target = client.target(URL + "sensor/type/temperature");
		target.request().post(
				Entity.entity(temperature, MediaType.APPLICATION_XML),
				TemperatureData.class);

	}

	public TemperatureData readTemperature(long id) {
		target = client.target(URL + "sensor/type/temperature/get?id=" + id);
		TemperatureData temperature = target.request(MediaType.APPLICATION_XML)
				.get(TemperatureData.class);
		return temperature;

	}

	public void updateTemperature(TemperatureData temperature) {
		target = client.target(URL + "sensor/type/temperature");
		target.request().put(
				Entity.entity(temperature, MediaType.APPLICATION_XML),
				TemperatureData.class);
	}

	public void deleteTemperature(long id) {
		target = client.target(URL + "sensor/type/temperature/del?id=" + id);
		target.request().delete();

	}

	public List<TemperatureData> findTemperature() {
		target = client.target(URL + "sensor/type/temperature/get/temperature");
		GenericType<List<TemperatureData>> list = new GenericType<List<TemperatureData>>() {
		};
		List<TemperatureData> temperatures = target.request(
				MediaType.APPLICATION_XML).get(list);
		return temperatures;
	}

	public void createHumidity(HumidityData humidity) {
		target = client.target(URL + "sensor/type/humidity");
		target.request().post(
				Entity.entity(humidity, MediaType.APPLICATION_XML),
				HumidityData.class);

	}

	public HumidityData readHumidity(long id) {
		target = client.target(URL + "sensor/type/humidity/get?id=" + id);
		HumidityData humidity = target.request(MediaType.APPLICATION_XML).get(
				HumidityData.class);
		return humidity;

	}

	public void updateHumidity(HumidityData humidity) {
		target = client.target(URL + "sensor/type/humidity");
		target.request().put(
				Entity.entity(humidity, MediaType.APPLICATION_XML),
				HumidityData.class);
	}

	public void deleteHumidity(long id) {
		target = client.target(URL + "sensor/type/humidity/del?id=" + id);
		target.request().delete();

	}

	public List<HumidityData> findHumidity() {
		target = client.target(URL + "sensor/type/humidity/get/humidity");
		GenericType<List<HumidityData>> list = new GenericType<List<HumidityData>>() {
		};
		List<HumidityData> humiditys = target
				.request(MediaType.APPLICATION_XML).get(list);
		return humiditys;
	}

	public void createAtmPressure(AtmPressureData atmPressure) {
		target = client.target(URL + "sensor/type/atmPressure");
		target.request().post(
				Entity.entity(atmPressure, MediaType.APPLICATION_XML),
				AtmPressureData.class);

	}

	public AtmPressureData readAtmPressure(long id) {
		target = client.target(URL + "sensor/type/atmPressure/get?id=" + id);
		AtmPressureData atmPressure = target.request(MediaType.APPLICATION_XML)
				.get(AtmPressureData.class);
		return atmPressure;

	}

	public void updateAtmPressure(AtmPressureData atmPressure) {
		target = client.target(URL + "sensor/type/atmPressure");
		target.request().put(
				Entity.entity(atmPressure, MediaType.APPLICATION_XML),
				AtmPressureData.class);
	}

	public void deleteAtmPressure(long id) {
		target = client.target(URL + "sensor/type/atmPressure/del?id=" + id);
		target.request().delete();

	}

	public List<AtmPressureData> findAtmPressure() {
		target = client.target(URL + "sensor/type/atmPressure/get/atmPressure");
		GenericType<List<AtmPressureData>> list = new GenericType<List<AtmPressureData>>() {
		};
		List<AtmPressureData> atmPressures = target.request(
				MediaType.APPLICATION_XML).get(list);
		return atmPressures;
	}

	public void createAudio(AudioData audio) {
		target = client.target(URL + "sensor/type/audio");
		target.request().post(Entity.entity(audio, MediaType.APPLICATION_XML),
				AudioData.class);

	}

	public AudioData readAudio(long id) {
		target = client.target(URL + "sensor/type/audio/get?id=" + id);
		AudioData audio = target.request(MediaType.APPLICATION_XML).get(
				AudioData.class);
		return audio;

	}

	public void updateAudio(AudioData audio) {
		target = client.target(URL + "sensor/type/audio");
		target.request().put(Entity.entity(audio, MediaType.APPLICATION_XML),
				AudioData.class);
	}

	public void deleteAudio(long id) {
		target = client.target(URL + "sensor/type/audio/del?id=" + id);
		target.request().delete();

	}

	public List<AudioData> findAudio() {
		target = client.target(URL + "sensor/type/audio/get/audio");
		GenericType<List<AudioData>> list = new GenericType<List<AudioData>>() {
		};
		List<AudioData> audios = target.request(MediaType.APPLICATION_XML).get(
				list);
		return audios;
	}

	public void createGPS(GPSData gps) {
		target = client.target(URL + "sensor/type/gps");
		target.request().post(Entity.entity(gps, MediaType.APPLICATION_XML),
				GPSData.class);

	}

	public GPSData readGPS(long id) {
		target = client.target(URL + "sensor/type/gps/get?id=" + id);
		GPSData gps = target.request(MediaType.APPLICATION_XML).get(
				GPSData.class);
		return gps;

	}

	public void updateGPS(GPSData gps) {
		target = client.target(URL + "sensor/type/gps");
		target.request().put(Entity.entity(gps, MediaType.APPLICATION_XML),
				GPSData.class);
	}

	public void deleteGPS(long id) {
		target = client.target(URL + "sensor/type/gps/del?id=" + id);
		target.request().delete();

	}

	public List<GPSData> findGPS() {
		target = client.target(URL + "sensor/type/gps/get/gps");
		GenericType<List<GPSData>> list = new GenericType<List<GPSData>>() {
		};
		List<GPSData> gpss = target.request(MediaType.APPLICATION_XML)
				.get(list);
		return gpss;
	}

	public void createLuminosity(LuminosityData luminosity) {
		target = client.target(URL + "sensor/type/luminosity");
		target.request().post(
				Entity.entity(luminosity, MediaType.APPLICATION_XML),
				LuminosityData.class);

	}

	public LuminosityData readLuminosity(long id) {
		target = client.target(URL + "sensor/type/luminosity/get?id=" + id);
		LuminosityData luminosity = target.request(MediaType.APPLICATION_XML)
				.get(LuminosityData.class);
		return luminosity;

	}

	public void updateLuminosity(LuminosityData luminosity) {
		target = client.target(URL + "sensor/type/luminosity");
		target.request().put(
				Entity.entity(luminosity, MediaType.APPLICATION_XML),
				LuminosityData.class);
	}

	public void deleteLuminosity(long id) {
		target = client.target(URL + "sensor/type/luminosity/del?id=" + id);
		target.request().delete();

	}

	public List<LuminosityData> findLuminosity() {
		target = client.target(URL + "sensor/type/luminosity/get/luminosity");
		GenericType<List<LuminosityData>> list = new GenericType<List<LuminosityData>>() {
		};
		List<LuminosityData> luminositys = target.request(
				MediaType.APPLICATION_XML).get(list);
		return luminositys;
	}

	public void createAddress(AddressData address) {
		target = client.target(URL + "address");
		target.request().post(
				Entity.entity(address, MediaType.APPLICATION_XML),
				AddressData.class);
	}

	public AddressData readAddress(long id) {
		target = client.target(URL + "address/get?id=" + id);
		AddressData address = target.request(MediaType.APPLICATION_XML).get(
				AddressData.class);
		return address;

	}

	public void updateAddress(AddressData address) {
		target = client.target(URL + "address");
		target.request().put(Entity.entity(address, MediaType.APPLICATION_XML),
				AddressData.class);
	}

	public void deleteAddress(long id) {
		target = client.target(URL + "address/del?id=" + id);
		target.request().delete();

	}

	public List<AddressData> findAddress() {
		target = client.target(URL + "address/get/addresses");
		GenericType<List<AddressData>> list = new GenericType<List<AddressData>>() {
		};
		List<AddressData> addresses = target.request(MediaType.APPLICATION_XML)
				.get(list);
		return addresses;
	}

	public AddressData readAddressByStreet(String street) {
		target = client.target(URL + "address/get/bystreet?street=" + street);
		AddressData address = target.request(MediaType.APPLICATION_XML).get(
				AddressData.class);
		return address;
	}

	public List<SensorData> findSensorByAddress(long id) {
		target = client.target(URL + "address/get/sensors?id=" + id);
		GenericType<List<SensorData>> list = new GenericType<List<SensorData>>() {
		};
		List<SensorData> sensors = target.request(MediaType.APPLICATION_XML)
				.get(list);
		return sensors;
	}

	public void createUser(UsersData user) {
		target = client.target(URL + "user");
		target.request().post(Entity.entity(user, MediaType.APPLICATION_XML),
				UsersData.class);
	}

	public UsersData readUser(long id) {
		target = client.target(URL + "user/get?id=" + id);
		UsersData user = target.request(MediaType.APPLICATION_XML).get(
				UsersData.class);
		return user;

	}

	public void updateUser(UsersData user) {
		target = client.target(URL + "user");
		target.request().put(Entity.entity(user, MediaType.APPLICATION_XML),
				UsersData.class);
	}

	public void deleteUser(long id) {
		target = client.target(URL + "user/del?id=" + id);
		target.request().delete();

	}

	public List<UsersData> findUser() {
		target = client.target(URL + "user/get/users");
		GenericType<List<UsersData>> list = new GenericType<List<UsersData>>() {
		};
		List<UsersData> users = target.request(MediaType.APPLICATION_XML).get(
				list);
		return users;
	}

	public UsersData readUserByDocument(String document) {
		target = client
				.target(URL + "user/get/bydocument?document=" + document);
		UsersData user = target.request(MediaType.APPLICATION_XML).get(
				UsersData.class);
		return user;
	}

}
