package edu.ping.damian.examen.develop;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import edu.ping.damian.examen.develop.criteria.Asks;
import edu.ping.damian.examen.develop.criteria.Bids;
import edu.ping.damian.examen.develop.criteria.Criteria;
import edu.ping.damian.examen.develop.criteria.MaxBid;
import edu.ping.damian.examen.develop.criteria.MinAsk;
import edu.ping.damian.examen.develop.criteria.Sales;
import edu.ping.damian.examen.develop.item.Ask;
import edu.ping.damian.examen.develop.item.Bid;
import edu.ping.damian.examen.develop.item.Item;
import edu.ping.damian.examen.develop.item.Offer;
import edu.ping.damian.examen.develop.item.Sale;
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
    @Test
    public void getMinAsk(){
        Bid bid = new Bid("13", 550);
        sneaker.add(bid);
        sneaker.add(new Bid("6", 550));
        sneaker.add(new Bid("9.5", 479));
        sneaker.add(new Bid("13", 338));
        sneaker.add(new Bid("9.5", 480));
        Ask ask = new Ask("13", 228);
        sneaker.add(ask);
        sneaker.add(new Ask("6", 600));
        sneaker.add(new Ask("9.5", 333));
        sneaker.add(new Ask("9.5", 340));
        sneaker.add(new Ask("13", 330));
        sneaker.add(new Ask("13", 330));
        
        Criteria minAsk = new MinAsk();
        List<Offer> minimum = minAsk.checkCriteria(sneaker);
        //sneaker.setAsk(minimum.isEmpty()? 0 : minimum.get(0).value());
        int size = minimum.size();
        Assert.assertEquals(1, size);
    }

    @Test
    public void getSales(){
        Sale sale = new Sale("6", 356);
        sneaker.add(sale);
        sneaker.add(new Sale("9.5", 352));
        sneaker.add(new Sale("9.5", 404));
        sneaker.add(new Sale("13", 360));
        sneaker.add(new Sale("13", 372));

        Ask ask = new Ask("13", 228);
        sneaker.add(ask);
        sneaker.add(new Ask("6", 600));
        sneaker.add(new Ask("9.5", 333));
        sneaker.add(new Ask("9.5", 340));
        sneaker.add(new Ask("13", 330));
        sneaker.add(new Ask("13", 330));
        
        Criteria sales = new Sales();
        List<Offer> salesList = sales.checkCriteria(sneaker);

        Assert.assertEquals(5, salesList.size());
    }
}
