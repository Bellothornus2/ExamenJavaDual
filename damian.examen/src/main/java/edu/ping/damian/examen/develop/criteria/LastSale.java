package edu.ping.damian.examen.develop.criteria;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import edu.ping.damian.examen.develop.item.Item;
import edu.ping.damian.examen.develop.item.Offer;
import edu.ping.damian.examen.develop.item.Sale;

public class LastSale implements Criteria{
    
    @Override
    public List<Offer> checkCriteria(Item item) {
        List<Offer> criteria = item.offers().stream().filter(n -> n instanceof Sale).collect(Collectors.toList());
        Offer lastSale = criteria.get(criteria.size()-1);
        List<Offer> lastSaleList = new ArrayList<Offer>();
        lastSaleList.add(lastSale);
        return lastSaleList;
    }
}
