package controller;

import Domain.Products;
import Services.RespostaEndPoint;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ProductsController {
    private static List<Products> productsList = new ArrayList<>();
    static RespostaEndPoint res = new RespostaEndPoint();
    public static class produtos implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "";
            JSONObject responseJson = new JSONObject();

            responseJson.put("name", Products.name);
            responseJson.put("factory", Products.factory);
            responseJson.put("quantity", Products.quantity);

            if ("GET".equals(exchange.getRequestMethod())) {
//                response = "essa e a rota de Poducts get";
                RespostaEndPoint.enviarResponseJson(exchange, responseJson, 200);
//                responseEndPoint.EnviarResponse(exchange, response);
            } else if ("POST".equals(exchange.getRequestMethod())) {
                try (InputStream resquestBody = exchange.getRequestBody()){
                    JSONObject json = new JSONObject(new String(resquestBody.readAllBytes()));

                Products products = new Products(
                        json.getString("name"),
                        json.getString("factory"),
                        json.getInt("quantity")
                );
                productsList.add(products);
                res.enviarResponseJson(exchange, products.toJson(), 200);
                System.out.println("productslist" + products.toJson());
                }catch(Exception e){
                    response = "erro";
                    String resposta  = e.toString();
                    res.enviarResponseJson(exchange, responseJson, 200);
//
                }

                RespostaEndPoint.enviarResponseJson(exchange, responseJson, 200);
            } else if ("PUT".equals(exchange.getRequestMethod())) {
                response = "essa e a rota de Poducts Put";
                RespostaEndPoint.enviarResponseJson(exchange, responseJson, 200);
            } else if ("DELETE".equals(exchange.getRequestMethod())) {
                response = "essa e a rota de Poducts Delete";
                RespostaEndPoint.enviarResponseJson(exchange, responseJson, 200);
            }else {
                response = "ERRO" + "o metodo utilizado foi "+ exchange.getRequestMethod();
                RespostaEndPoint.enviarResponseJson(exchange, responseJson, 405);
            }
        }}
}
