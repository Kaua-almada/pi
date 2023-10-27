package controller;
import Domain.Users;
import Services.RespostaEndPoint;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UsersController {

    public static class Usuarios implements HttpHandler {
        RespostaEndPoint res = new RespostaEndPoint();
        List<Users> usersList = new ArrayList<>();
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "";
            JSONObject responseJson = new JSONObject();
            if ("GET".equals(exchange.getRequestMethod())) {
                List<Users> getAllFromArray = Users.getAllUser(usersList);
                Users usersJson = new Users();

                if(!getAllFromArray.isEmpty()){
                    for(Users users : getAllFromArray){
                    System.out.println("name: " + users.getName());
                    System.out.println("last name: " + users.getlastLastname ());
                    System.out.println("email: " + users.getemail());
                    System.out.println("passeword: " + users.getpasseword());
                    System.out.println("cpf: " + users.getcpf());
                    System.out.println();
                    System.out.println("-------------------------");
                    System.out.println();
                    }
                    res.enviarResponseJson(exchange, usersJson.arraytoJson(getAllFromArray), 200);
                }
                else{
                    System.out.println("erroooo");
                }
            } else if ("POST".equals(exchange.getRequestMethod())) {
                try (InputStream resquestBody = exchange.getRequestBody()){
                    JSONObject json = new JSONObject(new String(resquestBody.readAllBytes()));

                    Users user = new Users(
                            json.getString("name"),
                            json.getString("lastName"),
                            json.getString("email"),
                            json.getString("passeword"),
                            json.getString("cpf")
                    );
                    usersList.add(user);

                    System.out.println("usersList" + user.toJson());

                    res.enviarResponseJson(exchange, user.toJson(), 200);
                }catch(Exception e){
                    response = e.toString();
                    System.out.println(response);
                    String resposta  = e.toString();
                    res.enviarResponseJson(exchange, responseJson, 200);
//
                }
            } else if ("PUT".equals(exchange.getRequestMethod())) {
                response = "essa e a rota de Poducts Put";
                res.enviarResponse(exchange, response, 200);
            } else if ("DELETE".equals(exchange.getRequestMethod())) {
                response = "essa e a rota de Poducts Delete";
                res.enviarResponse(exchange, response, 200);

            }else if ("OPTIONS".equals(exchange.getRequestMethod())){
                exchange.sendResponseHeaders(200,-1);
                exchange.close();
                return;
            }
            else {
                response = "ERRO" + "o metodo utilizado foi "+ exchange.getRequestMethod();
                res.enviarResponse(exchange, response, 405);
            }
        }
    }
}
