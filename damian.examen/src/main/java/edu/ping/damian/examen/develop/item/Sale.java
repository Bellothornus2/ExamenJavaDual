package edu.ping.damian.examen.develop.item;

public class Sale implements Offer{
    private String size = "";
    private Integer price = 0;

    public Sale(String size, int price){
        this.size = size;
        this.price = price;
    }

    @Override
    public String size(){
        return this.size;
    }
    @Override
    public int value(){
        return this.price;
    }
    @Override
    public int compareTo(Offer offer) {
        return 0;
    }
    @Override
    public String toString(){
        return "\t\t" + this.size() + "\t" + this.value()+"\n";
    }
}
