package Domain;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class Users {
    int id = 0;
    public String name = "";
    public String lastName = "";

    public String email = "";

    public String passeword = "";

    public String cpf = "";


    public Users() {

    }


    public Users(String name, String lastName, String email, String passeword, String cpf) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.passeword = passeword;
        this.cpf = cpf;
    }

    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getlastLastname() {
        return lastName;
    }

    public void setlastLastname(String lastName) {
        this.lastName = lastName;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getpasseword() {
        return passeword;
    }

    public void setpasseword(String passeword) {
        this.passeword = passeword;
    }

    public String getcpf() {
        return cpf;
    }

    public void setcpf(String cpf) {
        this.cpf = cpf;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("lastName", lastName);
        json.put("email", email);
        json.put("passeword", passeword);
        json.put("cpf", cpf);
        return json;
    }

    public static Users getUser(int index, List<Users> usersList) {

        if (index >= 0 && index < usersList.size()) {
            return usersList.get(index);
        } else {
            return null;
        }

    }

    public static List<Users> getAllUser(List<Users> usersList) {

        return usersList;
    }

    public JSONObject arraytoJson(List<Users> usersListArray) {
        JSONObject json = new JSONObject();

        if (!usersListArray.isEmpty()) {
            var keyJson = 0;
            for (Users users : usersListArray) {
                JSONObject valorJson = new JSONObject();
                valorJson.put("name", users.getName());
                valorJson.put("lastName", users.getlastLastname());
                valorJson.put("email", users.getemail());
                valorJson.put("passeword", users.getpasseword());
                valorJson.put("cpf", users.getcpf());
                json.put(String.valueOf(keyJson), valorJson);

                keyJson++;
            }
            return json;
        }else {
            return null;
        }

    }
}
