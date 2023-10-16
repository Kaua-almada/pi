package Services;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import controller.ProductsController;
import controller.SalesController;
import controller.UsersController;
import org.json.JSONObject;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Servidor {
    public static void piServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/api/users", new UsersController.Usuarios());
        server.createContext("/api/venda", new SalesController.produtos());
        server.createContext("/api/produtos", new ProductsController.produtos());
        server.setExecutor(null);
        System.out.println("Servidor iniciado");
        server.start();
    }
}
