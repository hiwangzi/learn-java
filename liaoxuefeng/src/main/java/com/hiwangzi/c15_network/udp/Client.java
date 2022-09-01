package com.hiwangzi.c15_network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {
        DatagramSocket ds = new DatagramSocket();
        ds.connect(InetAddress.getLocalHost(), 6666);
        for (int i = 0; i < 4; i++) {
            // send
            String cmd = new String[]{"date", "time", "datetime", "hello"}[i];
            byte[] data = cmd.getBytes(StandardCharsets.UTF_8);
            DatagramPacket packet = new DatagramPacket(data, data.length);
            ds.send(packet);
            // receive 2 times
            byte[] buffer = new byte[1024];
            packet = new DatagramPacket(buffer, buffer.length);
            ds.receive(packet);
            String resp = new String(packet.getData(), packet.getOffset(), packet.getLength());
            System.out.println(cmd + " >>> " + resp);
            byte[] buffer2 = new byte[1024];
            packet = new DatagramPacket(buffer2, buffer2.length);
            ds.receive(packet);
            String resp2 = new String(packet.getData(), packet.getOffset(), packet.getLength());
            System.out.println(cmd + " 2>>> " + resp2);
            Thread.sleep(2000);
        }
        ds.disconnect();
        System.out.println("disconnected.");
    }
}
