package edu.ping.damian.examen.develop.item;

import java.util.ArrayList;
import java.util.List;

public class Sneaker implements Item {
    private String style = "";
    private String name = "";
    private int sale = 0;
    private int ask = 0;
    private int bid = 0;
    private List<Offer> lista = new ArrayList<Offer>();

    public Sneaker(String style, String name){
        this.style = style;
        this.name = name;
    }

    String getStyle(){
        return this.style;
    }
    String getName(){
        return this.name;
    }
    @Override
    public int getSale(){
        return this.sale;
    }
    @Override
    public int getBid(){
        return this.bid;
    }
    @Override
    public int getAsk(){
        return this.ask;
    }
    @Override
    public void setSale(int sale) {
        this.sale = sale;
    }
    @Override
    public void setAsk(int ask){
        this.ask = ask;
    }
    @Override
    public void setBid(int bid){
        this.bid = bid;
    }
    @Override
    public void add(Offer offer){
        this.lista.add(offer);
    }
    @Override
    public List<Offer> offers(){
        return this.lista;
    }
    @Override
    public String toString(){
        return this.getName()+"\n\t\t"+this.getStyle();
    }
}
