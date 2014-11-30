package arduino.services.main;

/**
 * @author Serhat CAN
 *
 */
public class DataHandlerThread extends Thread {
	
	Thread thread;
	String threadName;
	
	
	public DataHandlerThread(String name) {
		threadName = name;
		System.out.println("Thread starting...");
	}

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}
	
	@Override
	public synchronized void start() {
		// TODO Auto-generated method stub
		super.start();
	}
	
}
