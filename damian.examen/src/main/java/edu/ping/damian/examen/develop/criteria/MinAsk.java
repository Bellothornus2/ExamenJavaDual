package edu.ping.damian.examen.develop.criteria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import edu.ping.damian.examen.develop.item.Ask;
import edu.ping.damian.examen.develop.item.Item;
import edu.ping.damian.examen.develop.item.Offer;

public class MinAsk implements Criteria {
    
    @Override
    public List<Offer> checkCriteria(Item item){
        
        List<Offer> bids = item.offers().stream().filter(n -> n instanceof Ask).collect(Collectors.toList()); //cojo los bids
        List<Integer> criteriaAsks = bids.stream().map(n -> n.value()).collect(Collectors.toList());  //cojo los valores
        Integer min  = Collections.min(criteriaAsks); //encunetro el maximo
        List<Offer> criteriaAsksMax = new ArrayList<Offer>();
        for (Offer offer : bids) {
            if (offer.value() == min){
                criteriaAsksMax.add(offer);
            }
        }
        return criteriaAsksMax;
    }
}
