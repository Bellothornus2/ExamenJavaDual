package edu.ping.damian.examen.develop.criteria;

import java.util.List;
import edu.ping.damian.examen.develop.item.Offer;
import edu.ping.damian.examen.develop.item.Item;

public interface Criteria {

    List<Offer> checkCriteria(Item item);
    
}