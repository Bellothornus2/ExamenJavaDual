package edu.ping.damian.examen.develop;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import edu.ping.damian.examen.develop.criteria.Bids;
import edu.ping.damian.examen.develop.criteria.Criteria;
import edu.ping.damian.examen.develop.criteria.Max;
import edu.ping.damian.examen.develop.criteria.Size;
import edu.ping.damian.examen.develop.item.Bid;
import edu.ping.damian.examen.develop.item.Item;
import edu.ping.damian.examen.develop.item.Offer;
import edu.ping.damian.examen.develop.item.Sale;
import edu.ping.damian.examen.develop.item.Sneaker;

public class MaxSizeAndBidsTest {
    private Item sneaker = new Sneaker("5.5", "Hola");
    
    @Test
    public void getMaxSizeAndBids(){
        Sale sale = new Sale("6", 356);
        sneaker.add(sale);
        sneaker.add(new Sale("9.5", 352));
        sneaker.add(new Sale("9.5", 404));
        sneaker.add(new Sale("13", 360));
        Sale lastSale = new Sale("13", 372);
        sneaker.add(lastSale);

        Bid bid = new Bid("13", 550);
        sneaker.add(bid);
        sneaker.add(new Bid("6", 550));
        sneaker.add(new Bid("9.5", 479));
        sneaker.add(new Bid("13", 338));
        Bid whatWeWant = new Bid("9.5", 480);
        sneaker.add(whatWeWant);
        
        Criteria size = new Size("9.5");
        Criteria bids = new Bids();
        Criteria sizeMaxBid = new Max(size, bids);
        List<Offer> sizeBid = sizeMaxBid.checkCriteria(sneaker);

        Assert.assertEquals(whatWeWant, sizeBid.get(0));
    }
}
