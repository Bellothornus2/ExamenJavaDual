package edu.ping.damian.examen.develop.criteria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import edu.ping.damian.examen.develop.item.Bid;
import edu.ping.damian.examen.develop.item.Item;
import edu.ping.damian.examen.develop.item.Offer;

public class MaxBid implements Criteria{
    public MaxBid(){
        //constructor vacio
    };

    @Override
    public List<Offer> checkCriteria(Item item){
        
        List<Offer> bids = item.offers().stream().filter(n -> n instanceof Bid).collect(Collectors.toList()); //cojo los bids
        List<Integer> criteriaBids = bids.stream().map(n -> n.value()).collect(Collectors.toList());  //cojo los valores
        Integer max  = Collections.max(criteriaBids); //encunetro el maximo
        List<Offer> criteriaBidsMax = new ArrayList<Offer>();
        for (Offer offer : bids) {
            if (offer.value() == max){
                criteriaBidsMax.add(offer);
            }
        }
        return criteriaBidsMax;
    }
}
