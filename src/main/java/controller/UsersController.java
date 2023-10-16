package controller;
import Domain.Users;
import Services.RespostaEndPoint;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UsersController {
    static RespostaEndPoint res = new RespostaEndPoint();

    static List<Users> usersList = new ArrayList<>();


    public static class Usuarios implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "";
            JSONObject responseJson = new JSONObject();

            if ("GET".equals(exchange.getRequestMethod())) {
                List<Users> getAllFromArray = Users.getAllUser(usersList);

                if(!getAllFromArray.isEmpty()){
                    for(Users users : getAllFromArray ){System.out.println("name: " + users.getName());
                    System.out.println("last name: " + users.getlastName());
                    System.out.println("email: " + users.getemail());
                    System.out.println("passeword: " + users.getpasseword());
                    System.out.println("cpf: " + users.getcpf());
                    System.out.println();
                    System.out.println("-------------------------");
                    System.out.println();
                    }
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
                    response = "erro";
                    String resposta  = e.toString();
                    res.enviarResponseJson(exchange, responseJson, 200);
//
                }
//                response = "essa e a rota de Poducts post";
//                RespostaEndPoint.enviarResponseJson(exchange, responseJson);
            } else if ("PUT".equals(exchange.getRequestMethod())) {
                response = "essa e a rota de Poducts Put";
                res.EnviarResponse(exchange, response, 200);
            } else if ("DELETE".equals(exchange.getRequestMethod())) {
                response = "essa e a rota de Poducts Delete";
                res.EnviarResponse(exchange, response, 200);
            }else {
                response = "ERRO" + "o metodo utilizado foi "+ exchange.getRequestMethod();
                res.EnviarResponse(exchange, response, 405);
            }
        }
    }
}
