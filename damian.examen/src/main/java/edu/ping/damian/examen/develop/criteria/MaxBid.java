package edu.ping.damian.examen.develop.criteria;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import edu.ping.damian.examen.develop.item.Item;
import edu.ping.damian.examen.develop.item.Offer;

public class MaxBid implements Criteria{
    public MaxBid(){}

    @Override
    public List<Offer> checkCriteria(Item item){
        Collections.max(item.offers());
        List<Offer> criteria = item.offers().stream().filter(n -> n.value()).collect(Collectors.toList());
        return criteria;
    }
}
