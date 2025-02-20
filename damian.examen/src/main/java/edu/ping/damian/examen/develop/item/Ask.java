package edu.ping.damian.examen.develop.item;

public class Ask implements Offer{
    private String size = "";
    private Integer ask = 0;

    public Ask(String size, int ask){
        this.size = size;
        this.ask = ask;
    }
    
    @Override
    public String size(){
        return this.size;
    }
    @Override
    public int value(){
        return this.ask;
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
