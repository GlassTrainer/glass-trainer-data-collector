/**
 * 
 */
package arduino.threads;

/**
 * @author Serhat CAN
 *
 */
public class TimerThread extends Thread {

	Thread thread;
	String threadName = "TimerThread";
	Long milSec;
	
	
	public TimerThread(int minute) {
		this.milSec = (long) (minute * 1000 *60);
		System.out.println("Application will be alive for " + minute + " min");
	}

	@Override
	public void run() {
		System.out.println("Running " + threadName);
		try {
			Thread.sleep(milSec);
		} catch (InterruptedException ie) {
		}
	}

	@Override
	public synchronized void start() {
		System.out.println("Started");
		super.start();
	}
}
