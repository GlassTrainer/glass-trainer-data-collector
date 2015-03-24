package arduino.app;

import arduino.services.main.DataHandlerThread;
import arduino.services.main.SerialPortConnection;
import arduino.threads.TimerThread;

/**
 * @author Serhat CAN
 *
 */
public class App {

	public static void main(String[] args) {

		SerialPortConnection connection = new SerialPortConnection();
		connection.initialize();

		TimerThread timerThread = new TimerThread(5);
		timerThread.start();

		DataHandlerThread dataHandlerThread = new DataHandlerThread(
				"dataHandlerThread");
		dataHandlerThread.start();

	}

}
