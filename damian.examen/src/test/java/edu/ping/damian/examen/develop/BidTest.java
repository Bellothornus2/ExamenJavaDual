package edu.ping.damian.examen.develop;

import org.junit.Assert;
import org.junit.Test;

import edu.ping.damian.examen.develop.criteria.Asks;
import edu.ping.damian.examen.develop.criteria.Bids;
import edu.ping.damian.examen.develop.criteria.Criteria;
import edu.ping.damian.examen.develop.item.Ask;
import edu.ping.damian.examen.develop.item.Bid;
import edu.ping.damian.examen.develop.item.Item;
import edu.ping.damian.examen.develop.item.Sneaker;

public class BidTest {
    private Item sneaker = new Sneaker("5.5", "Hola");

    @Test
    public void getBids(){
        Bid bid = new Bid("13", 550);
        sneaker.add(bid);
        sneaker.add(new Bid("6", 200));
        sneaker.add(new Bid("9.5", 479));
        sneaker.add(new Bid("13", 338));
        sneaker.add(new Bid("9.5", 480));
        Ask ask = new Ask("13", 288);
        sneaker.add(ask);
        sneaker.add(new Ask("6", 600));
        sneaker.add(new Ask("9.5", 333));
        sneaker.add(new Ask("9.5", 340));
        sneaker.add(new Ask("13", 330));
        
        Criteria bids = new Bids();
        int size = bids.checkCriteria(sneaker).size();
        Assert.assertEquals(5, size);
    }
    @Test
    public void getAsks(){
        Bid bid = new Bid("13", 550);
        sneaker.add(bid);
        sneaker.add(new Bid("6", 200));
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
        
        Criteria asks = new Asks();
        int size = asks.checkCriteria(sneaker).size();
        Assert.assertEquals(6, size);
    }
}
