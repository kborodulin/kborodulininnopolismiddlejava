package ru.innopolis.dz_10.task_1;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private static final String CHARSET_NAME = "Cp1251";
    private Socket сlientSocket;
    private String clientName;
    private String message;
    private BufferedReader readMessage;
    private BufferedWriter writeMessage;

    public ClientHandler(Socket сlientSocket) throws IOException {
        this.сlientSocket = сlientSocket;
        this.writeMessage = new BufferedWriter(new OutputStreamWriter(сlientSocket.getOutputStream(), CHARSET_NAME));
        this.readMessage = new BufferedReader(new InputStreamReader(сlientSocket.getInputStream(), CHARSET_NAME));
    }

    public String getClientName() {
        return clientName;
    }

    @Override
    public void run() {
        try {
            // Считаем имя клиента
            clientName = readMessage.readLine();
            System.out.println("Участник " + clientName + " зашел в чат!!!");
            while (сlientSocket.getInputStream().read() != -1) {
                // Считываем сообщение от клиента
                message = readMessage.readLine();

                // Выход из чата
                if ("quit".equals(message)) {
                    System.out.println("Участник " + clientName + " вышел из чата!!!");
                    Server.clients.remove(this);
                }

                // Массовая рассылка сообщений клиентам
                if (!message.startsWith(":")) {
                    for (ClientHandler handlerMass : Server.clients) {
                        handlerMass.writeMessage.write(clientName + ": " + message);
                        handlerMass.writeMessage.newLine();
                        handlerMass.writeMessage.flush();
                    }
                }

                // Личная рассылка сообщений клиенту
                if (message.startsWith(":")) {
                    for (ClientHandler handlerPerson : Server.clients) {
                        if (message.startsWith(":" + handlerPerson.getClientName())) {
                            handlerPerson.writeMessage.write(clientName + ": " + message);
                            handlerPerson.writeMessage.newLine();
                            handlerPerson.writeMessage.flush();
                            break;
                        }
                    }
                }
            }
            Server.clients.remove(this);
            writeMessage.close();
            readMessage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}