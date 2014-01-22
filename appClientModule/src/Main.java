package src;

import sensor.SerialTest;
import Connections.Connection;

public class Main {

	protected static int id;

	public static void main(String[] args) {
		Connection con = Connection.getInstance();
		System.out.println(util.DateUtil.getLocalDate());
		con.setServer("200.239.138.155", 44583);
		// con.setServer("192.168.1.22", 8080);
		id = Integer.valueOf(args[0]);
		System.out.println(Connection.getInstance().getServer());

		System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyACM0");

		if (args.length > 1 && args[1].compareTo("create") == 0) {

			SetInitialDatabase sensor = new SetInitialDatabase(id);
		} else {
			System.out.println("No new sensor create.");
		}

		// get data from sensor
		SerialTest main = new SerialTest();
		main.initialize(id);

		System.out.println("Started");
	}
}
