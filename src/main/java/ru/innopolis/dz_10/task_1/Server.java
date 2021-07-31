package ru.innopolis.dz_10.task_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static final String SERVER_NAME = "127.0.0.1";
    public static final int SERVER_PORT = 8000;
    public static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.out.println("Чат запущен!!!");
        // Создадим серверный сокет
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT, 0, InetAddress.getByName(SERVER_NAME));
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                // Создадим клиентский сокет (ожидаем входа клиента в чат)
                Socket сlientSocket = serverSocket.accept();
                // Создадим клиентский обработчик и добавим его в список
                ClientHandler client = new ClientHandler(сlientSocket);
                clients.add(client);
                // Вход клиента в чат
                new Thread(client).start();
            }
        }
    }
}