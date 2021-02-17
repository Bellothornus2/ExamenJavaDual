package edu.ping.damian.examen.develop.criteria;

import java.util.List;
import java.util.stream.Collectors;

import edu.ping.damian.examen.develop.item.Item;
import edu.ping.damian.examen.develop.item.Offer;
import edu.ping.damian.examen.develop.item.Sale;

public class Sales implements Criteria {
    
    @Override
    public List<Offer> checkCriteria(Item item){
        List<Offer> criteria = item.offers().stream().filter(n -> n instanceof Sale).collect(Collectors.toList());
        return criteria;
    }
}
