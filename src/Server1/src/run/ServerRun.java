package run;


import controller.CheckAlive;
import controller.ServerCtr;

public class ServerRun {
    public static void main(String[] args) {
        System.out.println("TCP server đang chạy!");
        CheckAlive my1 = new CheckAlive();
        ServerCtr my2 = new ServerCtr();
        my1.start();
        my2.start();
    }
}

