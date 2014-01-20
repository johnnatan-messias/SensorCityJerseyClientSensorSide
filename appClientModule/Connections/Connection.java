package Connections;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import data.Address;
import data.AtmPressure;
import data.Audio;
import data.GPS;
import data.Humidity;
import data.Luminosity;
import data.Sensor;
import data.Temperature;
import data.Users;

public class Connection {

	private static Connection con = null;
	// private String URL = "http://192.168.1.76:8080/EJBSensorCity/rest/";
	private String URL;

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

	public void setServer(String ip, int port) {
		URL = "http://" + ip + ":" + port + "/EJBSensorCity/rest/";
	}

	public String getServer() {
		return this.URL;
	}

	public void createTemperature(Temperature temperature) {
		target = client.target(URL + "sensor/type/temperature");
		target.request().post(
				Entity.entity(temperature, MediaType.APPLICATION_XML),
				Temperature.class);

	}

	public Temperature readTemperature(long id) {
		target = client.target(URL + "sensor/type/temperature/get?id=" + id);
		Temperature temperature = target.request(MediaType.APPLICATION_XML)
				.get(Temperature.class);
		return temperature;

	}

	public void updateTemperature(Temperature temperature) {
		target = client.target(URL + "sensor/type/temperature");
		target.request().put(
				Entity.entity(temperature, MediaType.APPLICATION_XML),
				Temperature.class);
	}

	public void deleteTemperature(long id) {
		target = client.target(URL + "sensor/type/temperature/del?id=" + id);
		target.request().delete();

	}

	public List<Temperature> findTemperature() {
		target = client.target(URL + "sensor/type/temperature/get/temperature");
		GenericType<List<Temperature>> list = new GenericType<List<Temperature>>() {
		};
		List<Temperature> temperatures = target.request(
				MediaType.APPLICATION_XML).get(list);
		return temperatures;
	}

	public void createHumidity(Humidity humidity) {
		target = client.target(URL + "sensor/type/humidity");
		target.request().post(
				Entity.entity(humidity, MediaType.APPLICATION_XML),
				Humidity.class);

	}

	public Humidity readHumidity(long id) {
		target = client.target(URL + "sensor/type/humidity/get?id=" + id);
		Humidity humidity = target.request(MediaType.APPLICATION_XML).get(
				Humidity.class);
		return humidity;

	}

	public void updateHumidity(Humidity humidity) {
		target = client.target(URL + "sensor/type/humidity");
		target.request().put(
				Entity.entity(humidity, MediaType.APPLICATION_XML),
				Humidity.class);
	}

	public void deleteHumidity(long id) {
		target = client.target(URL + "sensor/type/humidity/del?id=" + id);
		target.request().delete();

	}

	public List<Humidity> findHumidity() {
		target = client.target(URL + "sensor/type/humidity/get/humidity");
		GenericType<List<Humidity>> list = new GenericType<List<Humidity>>() {
		};
		List<Humidity> humiditys = target.request(MediaType.APPLICATION_XML)
				.get(list);
		return humiditys;
	}

	public void createAtmPressure(AtmPressure atmPressure) {
		target = client.target(URL + "sensor/type/atmPressure");
		target.request().post(
				Entity.entity(atmPressure, MediaType.APPLICATION_XML),
				AtmPressure.class);

	}

	public AtmPressure readAtmPressure(long id) {
		target = client.target(URL + "sensor/type/atmPressure/get?id=" + id);
		AtmPressure atmPressure = target.request(MediaType.APPLICATION_XML)
				.get(AtmPressure.class);
		return atmPressure;

	}

	public void updateAtmPressure(AtmPressure atmPressure) {
		target = client.target(URL + "sensor/type/atmPressure");
		target.request().put(
				Entity.entity(atmPressure, MediaType.APPLICATION_XML),
				AtmPressure.class);
	}

	public void deleteAtmPressure(long id) {
		target = client.target(URL + "sensor/type/atmPressure/del?id=" + id);
		target.request().delete();

	}

	public List<AtmPressure> findAtmPressure() {
		target = client.target(URL + "sensor/type/atmPressure/get/atmPressure");
		GenericType<List<AtmPressure>> list = new GenericType<List<AtmPressure>>() {
		};
		List<AtmPressure> atmPressures = target.request(
				MediaType.APPLICATION_XML).get(list);
		return atmPressures;
	}

	public void createAudio(Audio audio) {
		target = client.target(URL + "sensor/type/audio");
		target.request().post(Entity.entity(audio, MediaType.APPLICATION_XML),
				Audio.class);

	}

	public Audio readAudio(long id) {
		target = client.target(URL + "sensor/type/audio/get?id=" + id);
		Audio audio = target.request(MediaType.APPLICATION_XML)
				.get(Audio.class);
		return audio;

	}

	public void updateAudio(Audio audio) {
		target = client.target(URL + "sensor/type/audio");
		target.request().put(Entity.entity(audio, MediaType.APPLICATION_XML),
				Audio.class);
	}

	public void deleteAudio(long id) {
		target = client.target(URL + "sensor/type/audio/del?id=" + id);
		target.request().delete();

	}

	public List<Audio> findAudio() {
		target = client.target(URL + "sensor/type/audio/get/audio");
		GenericType<List<Audio>> list = new GenericType<List<Audio>>() {
		};
		List<Audio> audios = target.request(MediaType.APPLICATION_XML)
				.get(list);
		return audios;
	}

	public void createGPS(GPS gps) {
		target = client.target(URL + "sensor/type/gps");
		target.request().post(Entity.entity(gps, MediaType.APPLICATION_XML),
				GPS.class);

	}

	public GPS readGPS(long id) {
		target = client.target(URL + "sensor/type/gps/get?id=" + id);
		GPS gps = target.request(MediaType.APPLICATION_XML).get(GPS.class);
		return gps;

	}

	public void updateGPS(GPS gps) {
		target = client.target(URL + "sensor/type/gps");
		target.request().put(Entity.entity(gps, MediaType.APPLICATION_XML),
				GPS.class);
	}

	public void deleteGPS(long id) {
		target = client.target(URL + "sensor/type/gps/del?id=" + id);
		target.request().delete();

	}

	public List<GPS> findGPS() {
		target = client.target(URL + "sensor/type/gps/get/gps");
		GenericType<List<GPS>> list = new GenericType<List<GPS>>() {
		};
		List<GPS> gpss = target.request(MediaType.APPLICATION_XML).get(list);
		return gpss;
	}

	public void createLuminosity(Luminosity luminosity) {
		target = client.target(URL + "sensor/type/luminosity");
		target.request().post(
				Entity.entity(luminosity, MediaType.APPLICATION_XML),
				Luminosity.class);

	}

	public Luminosity readLuminosity(long id) {
		target = client.target(URL + "sensor/type/luminosity/get?id=" + id);
		Luminosity luminosity = target.request(MediaType.APPLICATION_XML).get(
				Luminosity.class);
		return luminosity;

	}

	public void updateLuminosity(Luminosity luminosity) {
		target = client.target(URL + "sensor/type/luminosity");
		target.request().put(
				Entity.entity(luminosity, MediaType.APPLICATION_XML),
				Luminosity.class);
	}

	public void deleteLuminosity(long id) {
		target = client.target(URL + "sensor/type/luminosity/del?id=" + id);
		target.request().delete();

	}

	public List<Luminosity> findLuminosity() {
		target = client.target(URL + "sensor/type/luminosity/get/luminosity");
		GenericType<List<Luminosity>> list = new GenericType<List<Luminosity>>() {
		};
		List<Luminosity> luminositys = target
				.request(MediaType.APPLICATION_XML).get(list);
		return luminositys;
	}

	public void createAddress(Address address) {
		target = client.target(URL + "address");
		target.request().post(
				Entity.entity(address, MediaType.APPLICATION_XML),
				Address.class);
	}

	public Address readAddress(long id) {
		target = client.target(URL + "address/get?id=" + id);
		Address address = target.request(MediaType.APPLICATION_XML).get(
				Address.class);
		return address;

	}

	public void updateAddress(Address address) {
		target = client.target(URL + "address");
		target.request().put(Entity.entity(address, MediaType.APPLICATION_XML),
				Address.class);
	}

	public void deleteAddress(long id) {
		target = client.target(URL + "address/del?id=" + id);
		target.request().delete();

	}

	public List<Address> findAddress() {
		target = client.target(URL + "address/get/addresses");
		GenericType<List<Address>> list = new GenericType<List<Address>>() {
		};
		List<Address> addresses = target.request(MediaType.APPLICATION_XML)
				.get(list);
		return addresses;
	}

	public Address readAddressByStreet(String street) {
		target = client.target(URL + "address/get/bystreet?street=" + street);
		Address address = target.request(MediaType.APPLICATION_XML).get(
				Address.class);
		return address;
	}

	public List<Sensor> findSensorByAddress(long id) {
		target = client.target(URL + "address/get/sensors?id=" + id);
		GenericType<List<Sensor>> list = new GenericType<List<Sensor>>() {
		};
		List<Sensor> sensors = target.request(MediaType.APPLICATION_XML).get(
				list);
		return sensors;
	}

	public void createUser(Users user) {
		target = client.target(URL + "user");
		target.request().post(Entity.entity(user, MediaType.APPLICATION_XML),
				Users.class);
	}

	public Users readUser(long id) {
		target = client.target(URL + "user/get?id=" + id);
		Users user = target.request(MediaType.APPLICATION_XML).get(Users.class);
		return user;

	}

	public void updateUser(Users user) {
		target = client.target(URL + "user");
		target.request().put(Entity.entity(user, MediaType.APPLICATION_XML),
				Users.class);
	}

	public void deleteUser(long id) {
		target = client.target(URL + "user/del?id=" + id);
		target.request().delete();

	}

	public List<Users> findUser() {
		target = client.target(URL + "user/get/users");
		GenericType<List<Users>> list = new GenericType<List<Users>>() {
		};
		List<Users> users = target.request(MediaType.APPLICATION_XML).get(list);
		return users;
	}

	public Users readUserByDocument(String document) {
		target = client
				.target(URL + "user/get/bydocument?document=" + document);
		Users user = target.request(MediaType.APPLICATION_XML).get(Users.class);
		return user;
	}

	public void createSensor(Sensor sensor) {
		target = client.target(URL + "sensor");
		target.request().post(Entity.entity(sensor, MediaType.APPLICATION_XML),
				Sensor.class);

	}

	public Sensor readSensor(long id) {
		target = client.target(URL + "sensor/get?id=" + id);
		Sensor sensor = target.request(MediaType.APPLICATION_XML).get(
				Sensor.class);
		return sensor;

	}

	public void updateSensor(Sensor sensor) {
		target = client.target(URL + "sensor");
		target.request().put(Entity.entity(sensor, MediaType.APPLICATION_XML),
				Sensor.class);
	}

	public void deleteSensor(long id) {
		target = client.target(URL + "sensor/del?id=" + id);
		target.request().delete();

	}

	public List<Sensor> findSensor() {
		target = client.target(URL + "sensor/get/sensor");
		GenericType<List<Sensor>> list = new GenericType<List<Sensor>>() {
		};
		List<Sensor> sensors = target.request(MediaType.APPLICATION_XML).get(
				list);
		return sensors;
	}

	public Sensor findSensorByName(String name) {

		target = client.target(URL + "sensor/get/byname?name=" + name);
		Sensor sensor = target.request(MediaType.APPLICATION_XML).get(
				Sensor.class);
		return sensor;
	}

}
