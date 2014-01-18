package src;

import Connections.Connection;
import data.Audio;

public class Main {

	public static void main(String[] args) {

		Connection con = Connection.getInstance();
		Audio a = new Audio();
		a.setId(2);
		a.setValue(4.23);
		con.createAudio(a);
		Audio audio = con.readAudio(2);
		audio.setValue(5.65);
		con.updateAudio(audio);
		System.out.println(con.readAudio(2).getValue());
	}
}
