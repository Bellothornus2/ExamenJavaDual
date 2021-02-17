package edu.ping.damian.examen.develop.criteria;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import edu.ping.damian.examen.develop.item.Offer;
import edu.ping.damian.examen.develop.item.Bid;
import edu.ping.damian.examen.develop.item.Item;
public class Bids implements Criteria{
    
    public Bids(){
        //vacio
    }

    @Override
    public List<Offer> checkCriteria(Item item){
        List<Offer> criteria = item.offers().stream().filter(n -> n instanceof Bid).collect(Collectors.toList());
        return criteria;
    }
}