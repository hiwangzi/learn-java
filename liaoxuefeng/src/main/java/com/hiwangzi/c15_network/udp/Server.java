package com.hiwangzi.c15_network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(6666);
        for (; ; ) {
            // receive
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            ds.receive(packet);
            String cmd = new String(
                    packet.getData(),
                    packet.getOffset(),
                    packet.getLength(),
                    StandardCharsets.UTF_8
            );
            // reply
            String resp = "bad command";
            switch (cmd) {
                case "date":
                    resp = LocalDate.now().toString();
                    break;
                case "time":
                    resp = LocalTime.now().withNano(0).toString();
                case "datetime":
                    resp = LocalDateTime.now().withNano(0).toString();
            }
            System.out.println(cmd + " >>> " + resp);
            byte[] data = resp.getBytes(StandardCharsets.UTF_8);
            packet.setData(data);
            // send 2 times
            ds.send(packet);
            ds.send(packet);
        }
    }
}
