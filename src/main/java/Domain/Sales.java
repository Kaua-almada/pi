package Domain;

import org.json.JSONObject;

public class Sales {
    public static int id = 0;
    public static String user = "";
    public static String produts = "";
    public static String valor =  "";
    public static boolean finishedSale = false;
    public static Double discount = 0.0;
    public static String dateSale = "";
    public void Users(){
    }
    public Sales(String user, String produts, String valor,boolean finishedSale, double discount, String dateSale){

        this.user = user;
        this.produts = produts;
        this.valor = valor;
        this.finishedSale = finishedSale;
        this.discount = discount;
        this.dateSale = dateSale;
    }
    //getters and setters
    public String getUser(){
        return user;
    }
    public void setUser(String user){
        this.user = user;
    }
    public String getProduts(){
        return produts;
    }
    public void setproduts(String produts){
        this.produts = produts;
    }
    public String getvalor(){
        return valor;
    }
    public void setValor(String valor){
        this.valor = valor;
    }
    public boolean getFinishedSale(){
        return finishedSale;
    }
    public void setfinishedSale(boolean finishedSale){
        this.finishedSale = finishedSale;
    }
    public Double getdiscount(){
        return discount;
    }
    public void setdiscount(Double discount){
        this.discount = discount;
    }
    public String getdateSale(){
        return dateSale;
    }
    public void setdateSale(Double discount){
        this.dateSale = dateSale;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", Sales.user);
        json.put("produts", Sales.produts);
        json.put("valor", Sales.valor);
        json.put("finishedSale", Sales.finishedSale);
        json.put("discount", Sales.discount);
        json.put("dateSale", Sales.dateSale);
        return json;
    }
}

