package edu.ping.damian.examen.develop;

import edu.ping.damian.examen.develop.criteria.Criteria;
import edu.ping.damian.examen.develop.criteria.MaxBid;
import edu.ping.damian.examen.develop.item.Ask;
import edu.ping.damian.examen.develop.item.Bid;
import edu.ping.damian.examen.develop.item.Item;
import edu.ping.damian.examen.develop.item.Offer;
import edu.ping.damian.examen.develop.item.Sneaker;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class MaxBidTest {
    private Item sneaker = new Sneaker("5.5", "Hola");

    @Test
    public void getMaxBid(){
        Bid bid = new Bid("13", 550);
        sneaker.add(bid);
        sneaker.add(new Bid("6", 550));
        sneaker.add(new Bid("9.5", 479));
        sneaker.add(new Bid("13", 338));
        sneaker.add(new Bid("9.5", 480));
        Ask ask = new Ask("13", 288);
        sneaker.add(ask);
        sneaker.add(new Ask("6", 600));
        sneaker.add(new Ask("9.5", 333));
        sneaker.add(new Ask("9.5", 340));
        sneaker.add(new Ask("13", 330));
        sneaker.add(new Ask("13", 330));
        
        Criteria maxBid = new MaxBid();
        List<Offer> maximum = maxBid.checkCriteria(sneaker);
        //sneaker.setBid(maximum.isEmpty()? 0 : maximum.get(0).value());
        int size = maximum.size();
        Assert.assertEquals(2, size);
    }
}
