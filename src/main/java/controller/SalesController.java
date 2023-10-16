package controller;

import Domain.Products;
import Domain.Sales;
import Services.RespostaEndPoint;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SalesController {
    private  static List<Sales> salesList = new ArrayList<>();
    static RespostaEndPoint res = new RespostaEndPoint();
    public static class produtos implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "";
            JSONObject responseJson = new JSONObject();

            if ("GET".equals(exchange.getRequestMethod())) {
//
            } else if ("POST".equals(exchange.getRequestMethod())) {
                try (InputStream resquestBody = exchange.getRequestBody()) {
                    JSONObject json = new JSONObject(new String(resquestBody.readAllBytes()));

                    Sales sales = new Sales(
                            json.getString("name"),
                            json.getString("produts"),
                            json.getString("valor"),
                            json.getBoolean("finishedSale"),
                            json.getDouble("discount"),
                            json.getString("dateSale")
                    );

                    salesList.add(sales);

                    res.enviarResponseJson(exchange, sales.toJson(), 200);
                    System.out.println("salesList" + sales.toJson());
                } catch (Exception e) {
                    response = "erro";
                    String resposta = e.toString();
                    res.enviarResponseJson(exchange, responseJson, 200);
                }
            } else if ("PUT".equals(exchange.getRequestMethod())) {
                response = "essa e a rota de Poducts Put";
                RespostaEndPoint.enviarResponseJson(exchange, responseJson, 200);
            } else if ("DELETE".equals(exchange.getRequestMethod())) {
                response = "essa e a rota de Poducts Delete";
                RespostaEndPoint.enviarResponseJson(exchange, responseJson, 200);
            }else {
                response = "ERRO" + "o metodo utilizado foi "+ exchange.getRequestMethod();
                RespostaEndPoint.enviarResponseJson(exchange, responseJson, 200);
            }
        }}
}
