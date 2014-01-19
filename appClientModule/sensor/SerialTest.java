package sensor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import gnu.io.CommPortIdentifier; 
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent; 
import gnu.io.SerialPortEventListener; 

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;

import src.UpdateSensorData;



public class SerialTest implements SerialPortEventListener {
	SerialPort serialPort;
	protected static String message;
	protected double temperature;
	protected double luminosity;
	protected double audio;
	protected double humidity;
	protected  double atmPress;
	protected long sensorId =1;
	protected UpdateSensorData updateSensorData;

	

		/** The port we're normally going to use. */
	private static final String PORT_NAMES[] = { 
			"/dev/tty.usbmodem1411", // Mac OS X
			"/dev/ttyUSB0", // Linux
			"COM3", // Windows
	};
	/**
	* A BufferedReader which will be fed by a InputStreamReader 
	* converting the bytes into characters 
	* making the displayed results codepage independent
	*/
	private BufferedReader input;
	/** The output stream to the port */
	private OutputStream output;
	/** Milliseconds to block while waiting for port open */
	private static final int TIME_OUT = 2000;
	/** Default bits per second for COM port. */
	private static final int DATA_RATE = 9600;

	public void initialize() {
		CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		//First, Find an instance of serial port as set in PORT_NAMES.
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
			for (String portName : PORT_NAMES) {
				if (currPortId.getName().equals(portName)) {
					portId = currPortId;
					break;
				}
			}
		}
		if (portId == null) {
			System.out.println("Could not find COM port.");
			return;
		}

		try {
			// open serial port, and use class name for the appName.
			serialPort = (SerialPort) portId.open(this.getClass().getName(),
					TIME_OUT);

			// set port parameters
			serialPort.setSerialPortParams(DATA_RATE,
					SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);

			// open the streams
			input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
			output = serialPort.getOutputStream();

			// add event listeners
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	/**
	 * This should be called when you stop using the port.
	 * This will prevent port locking on platforms like Linux.
	 */
	public synchronized void close() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	}

	/**
	 * Handle an event on the serial port. Read the data and print it.
	 */
	public synchronized void serialEvent(SerialPortEvent oEvent) 
	{
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE)
		{
			
				updateSensorData = new UpdateSensorData();		
			    String[] inputLine;
				try {
			    inputLine = input.readLine().split(";");
							
				audio = Double.parseDouble(inputLine[0]);
			    humidity = Double.parseDouble(inputLine[1]);
			    atmPress = Double.parseDouble(inputLine[2]);
				temperature = Double.parseDouble(inputLine[3]);
				luminosity = Double.parseDouble(inputLine[4]);	
				final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
				final Calendar cal = Calendar.getInstance();
				message= "s" + ";" + "1" + ";" + dateFormat.format(cal.getTime()) + ";" +  
		  		audio + ";" + humidity + ";" + atmPress + ";" + temperature + ";" + luminosity;
				System.out.println(message);
				passdata();	
					
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
		}
	}
	
		// Ignore all the other eventTypes, but you should consider the other ones.
	
	public void passdata() 
	{
		Thread t=new Thread()
		{
			public void run() 
			{
				updateSensorData.update(audio, humidity, atmPress, temperature, luminosity, sensorId);	

				try {Thread.sleep(1000000);} catch (InterruptedException ie) {}
			}
		};
		t.start();	
	}
	 public static boolean getIsRunning() {
	        boolean isRunning=true;
			return isRunning;
	    }
//	public static void main(String[] args) throws Exception {
//		// private static String URL = "http://localhost:8080/TestDynamic/rest/";
//		String URLGet = "http://localhost:8080/EJBSensorCity/rest/sensor/type/temperature/get?id=";
//		final String URLGetList = "http://localhost:8080/EJBSensorCity/rest/sensor/type/temperature/get/temperature";
//		final String URLPost = "http://localhost:8080/EJBSensorCity/rest/sensor/type/temperature";
//		String URLDel = "http://localhost:8080/EJBSensorCity/rest/sensor/type/temperature/del?id=";
//		
//		SerialTest main = new SerialTest();
//		
//		
//		main.initialize();
//		Thread t=new Thread() {
//			public void run() {
//				//the following line will keep this app alive for 1000 seconds,
//				//waiting for events to occur and responding to them (printing incoming messages to console).
//				try {Thread.sleep(1000000);} catch (InterruptedException ie) {}
//			}
//		};
//		t.start();
//		System.out.println("Started");
//		
//		new Thread(new Runnable() {
//          @Override
//          public void run() {
//              while (getIsRunning()) {
//                  //System.out.println(i);
//                 if(temp != 0) {
//					Update up = new Update(URLPost);
//					up.execute(1,temp);
//					Get get = new Get(URLGetList);
//					get.executeList();
//				}
//                  try {
//                      Thread.sleep(10000);
//                  } catch (InterruptedException e) {
//                      System.err.println(e.getMessage());
//                  }
//              }
//
//          }
//      }).start();
//	}
}