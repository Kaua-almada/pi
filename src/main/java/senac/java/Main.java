package senac.java;

import Services.Servidor;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Servidor servidor = new Servidor();
        servidor.piServer();
        }
}
