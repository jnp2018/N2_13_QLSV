package controller;

/**
 *
 * @author quy`
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;

 
public class CheckAlive extends Thread {
    public void run(){
                System.out.println("Thread 2 đang chạy, tiến hành kiểm tra kết nối");
		System.out.println(isSocketAliveUitlitybyCrunchify("localhost",8080));
                System.out.println(isSocketAliveUitlitybyCrunchify("localhost",8081));
                System.out.println(isSocketAliveUitlitybyCrunchify("localhost",80));
                System.out.println(isSocketAliveUitlitybyCrunchify("localhost",81));
 
    }
 
	
	public static boolean isSocketAliveUitlitybyCrunchify(String hostName, int port2) {
		boolean isAlive = false;
 
		// Creates a socket address from a hostname and a port number
		SocketAddress s = new InetSocketAddress(hostName, port2);
		Socket socket = new Socket();
 
		// Timeout required - it's in milliseconds
		int timeout = 2000;
 
		System.out.println("HostName: " + hostName + ", port: " + port2);
		try {
			socket.connect(s, timeout);
			socket.close();
			isAlive = true;
 
		} catch (SocketTimeoutException exception) {
			System.out.println("SocketTimeoutException " + hostName + ":" + port2 + ". " + exception.getMessage());
		} catch (IOException exception) {
			System.out.println(
					"IOException - Không thể kết nối " + hostName + ":" + port2 + ". " + exception.getMessage());
		}
		return isAlive;
	}
 
	// Simple log utility
	private static void log(String string) {
		System.out.println(string);
	}
 
	// Simple log utility returns boolean result
	private static void log(boolean isAlive) {
		System.out.println("Còn kết nối hay không: " + isAlive + "\n");
	}
 
}

