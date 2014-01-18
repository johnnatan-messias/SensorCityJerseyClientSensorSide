package src;

import Connections.Connection;

public class Main {

	public static void main(String[] args) {

		Connection con = Connection.getInstance();
		System.out.println(con.readAudio(1).getValue());

	}

}
