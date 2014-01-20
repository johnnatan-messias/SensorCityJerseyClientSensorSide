package src;

import Connections.Connection;
import sensor.SerialTest;

public class Main {
	protected static long id1 = 1;
	protected static long id2 = 2;
	protected static long id3 = 3;
	protected static long id4 = 4;
	protected static long id5 = 5;
	protected static int idx;

	// protected UpdateSensorData updateSD;

	public static void main(String[] args) {
		Connection con = Connection.getInstance();
		System.out.println(util.DateUtil.getLocalDate());
		if (args.length != 0) {
			con.setServer(args[0], Integer.valueOf(args[1]));
			idx = Integer.valueOf(args[2]);

		} else {
			con.setServer("localhost", 8080);
			idx = 0;
		}
		System.out.println(Connection.getInstance().getServer());

		//System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyACM0");
		switch (idx) {
		case 1:
			SetInitialDatabase sensor1 = new SetInitialDatabase(id1);
			break;
		case 2:
			SetInitialDatabase sensor2 = new SetInitialDatabase(id2);
			break;
		case 3:
			SetInitialDatabase sensor3 = new SetInitialDatabase(id3);
			break;
		case 4:
			SetInitialDatabase sensor4 = new SetInitialDatabase(id4);
			break;
		case 5:
			SetInitialDatabase sensor5 = new SetInitialDatabase(id5);
			break;
		default:
			System.out.println("No new sensor create.");
		}

		// get data from sensor
		SerialTest main = new SerialTest();
		main.initialize(idx);

		System.out.println("Started");
	}
}
