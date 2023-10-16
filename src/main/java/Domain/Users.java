package Domain;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Users {
    int id = 0;
    public static String name = "";
    public static String lastName = "";

    public static String email = "";

    public static String passeword  ="";

    public static String cpf = "";
    public void Users(){
    }

    public Users(String name, String lastName, String email,String passeword, String cpf){

        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.passeword = passeword;
        this.cpf = cpf;
    }

    //getters and setters
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getlastName(){
        return lastName;
    }
    public void setlastName(String lastName){
        this.lastName = lastName;
    }
    public String getemail(){
        return email;
    }
    public void setemail(String email){
        this.email = email;
    }
    public String getpasseword(){
        return passeword;
    }
    public void setpasseword(String passeword){
        this.passeword = passeword;
    }
    public String getcpf(){
        return cpf;
    }
    public void setcpf(String cpf){
        this.cpf = cpf;
    }

    public JSONObject toJson(){
        JSONObject json = new JSONObject();
        json.put("name", Users.name);
        json.put("lastName", Users.lastName);
        json.put("email", Users.email);
        json.put("passeword", Users.passeword);
        json.put("cpf", Users.cpf);
        return json;
    }
    public static Users getUser(int index, List<Users> usersList) {

        if (index >= 0 && index < usersList.size()) {
            return usersList.get(index);
        }else {
            return null;
        }

    }
    public static List<Users> getAllUser(List<Users> usersList){

        return usersList;
    }
    }
