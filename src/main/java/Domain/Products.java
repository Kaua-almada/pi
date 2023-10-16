package Domain;

import org.json.JSONObject;

public class Products {
    int id = 0;
    public static String name = "";
    public static String factory = "";
    public static int quantity = 0;
    //contrutor
    public void Users(){
    }
    public Products(String name, String factory, int quantity){

        this.name = name;
        this.factory = factory;
        this.quantity = quantity;
    }

    //getters and setters
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getFactory(){
        return factory;
    }
    public void setFactory(String factory){
        this.factory = factory;
    }
    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public static JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", Products.name);
        json.put("factory", Products.factory);
        json.put("quantity", Products.quantity);
        return json;
    }
}



