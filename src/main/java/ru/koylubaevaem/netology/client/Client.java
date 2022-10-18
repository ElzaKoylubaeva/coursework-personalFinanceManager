package ru.koylubaevaem.netology.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Client {

    private static final int PORT = 8989;//порт к которому хотим подсоединится

    private static final String LOCALHOST = "127.0.0.1"; // <- адрес по которому располагается наш сервер,всегда

    private static Random random = new Random();

    public static void main(String[] args) {
        try (
                Socket clientSocket = new Socket(LOCALHOST, PORT);//создаем клиентский сокет
                PrintWriter out = new PrintWriter(
                        clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()))) {
            long sum = 200 + random.nextInt(200);
//            String json = "{\"title\": \"булка\", \"date\": \"2022.02.08\", \"sum\": " + sum + "}";
//            String json = "{\"title\": \"колбаса\", \"date\": \"2022.02.08\", \"sum\": " + sum + "}";
            String json = "{\"title\": \"тапки\", \"date\": \"2022.02.08\", \"sum\": " + sum + " }";
//            String json = "{\"title\": \"мыло\", \"date\": \"2022.02.08\", \"sum\": " + sum + "}";
//            String json = "{\"title\": \"футболка\", \"date\": \"2022.02.08\", \"sum\": " + sum + "}";
            System.out.println("Send data: " + json);
            out.println(json); // city to send
            String result = in.readLine();// status(ok or not ok)
            System.out.println("Result: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
