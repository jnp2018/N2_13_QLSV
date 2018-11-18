package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import model.Student;
import view.ServerView;

public class ServerCtr extends Thread {
   
    private int port;
    private String host;
    private ServerDAO dao;
    private ServerSocket myServer;
    private ArrayList<Socket> list;
   
    public void run() {
        System.out.println("Thread 1 đang chạy");
        port = 8888;
        host = "localhost";
        dao = new ServerDAO();
        list = new ArrayList<>();
        openSocket();
        while (true) {            
            try {
                Socket s = myServer.accept();
                list.add(s);
                execute(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
                
    }
    
    
    public void sendResult(String res){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(list.get(list.size()-1).getOutputStream());
            oos.writeObject(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void execute(Socket s){
        try {
            Student ss = receiveStudent(s);
            if(dao.addStudent(ss)){
                sendResult("ok");
                new ServerView().showMessage("Success!");
            } else{
                sendResult("failed");
                new ServerView().showMessage("Failed!");
            }
        } catch (Exception e) {
            sendResult("ok");
            new ServerView().showMessage("Success!");
            e.printStackTrace();
        }
    }
    
    public void openSocket(){
        try {
            myServer = new ServerSocket(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Student receiveStudent(Socket s){
        Student ss= null;
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            ss = (Student)ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ss;
    }
    
}
