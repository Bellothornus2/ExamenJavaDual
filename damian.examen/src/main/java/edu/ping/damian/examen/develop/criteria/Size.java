package edu.ping.damian.examen.develop.criteria;

import java.util.ArrayList;
import java.util.List;

import edu.ping.damian.examen.develop.item.Item;
import edu.ping.damian.examen.develop.item.Offer;

public class Size implements Criteria {
    String size = "";
    public Size(String size){
        this.size = size;
    }

    @Override
    public List<Offer> checkCriteria(Item item) {
        List<Offer> sizeOfferList = new ArrayList<Offer>();
        for (Offer offers : item.offers()) {
            if (offers.size() == this.size){
                sizeOfferList.add(offers);
            }
        }
        return sizeOfferList;
    }
}
