package edu.ping.damian.examen.develop.item;

public class Bid implements Offer{
    private String size = "";
    private Integer bid = 0;

    public Bid(String size, int bid){
        this.size = size;
        this.bid = bid;
    }

    @Override
    public String size(){
        return this.size;
    }
    @Override
    public int value(){
        return this.bid;
    }
    @Override
    int compareTo(){

    }
    @Override
    String toString(){
        
    }
}
