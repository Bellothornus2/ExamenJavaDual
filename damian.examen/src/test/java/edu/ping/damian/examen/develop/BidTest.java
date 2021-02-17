package edu.ping.damian.examen.develop;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import edu.ping.damian.examen.develop.criteria.AndCriteria;
import edu.ping.damian.examen.develop.criteria.Asks;
import edu.ping.damian.examen.develop.criteria.Bids;
import edu.ping.damian.examen.develop.criteria.Criteria;
import edu.ping.damian.examen.develop.criteria.LastSale;
import edu.ping.damian.examen.develop.criteria.Max;
import edu.ping.damian.examen.develop.criteria.Min;
import edu.ping.damian.examen.develop.criteria.MinAsk;
import edu.ping.damian.examen.develop.criteria.Sales;
import edu.ping.damian.examen.develop.criteria.Size;
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
    public void getLastSales(){
        Sale sale = new Sale("6", 356);
        sneaker.add(sale);
        sneaker.add(new Sale("9.5", 352));
        sneaker.add(new Sale("9.5", 404));
        sneaker.add(new Sale("13", 360));
        Sale lastSale = new Sale("13", 372);
        sneaker.add(lastSale);

        Ask ask = new Ask("13", 228);
        sneaker.add(ask);
        sneaker.add(new Ask("6", 600));
        sneaker.add(new Ask("9.5", 333));
        sneaker.add(new Ask("9.5", 340));
        sneaker.add(new Ask("13", 330));
        sneaker.add(new Ask("13", 330));
        
        Criteria lastSaleCriteria = new LastSale();
        
        List<Offer> actualSale = lastSaleCriteria.checkCriteria(sneaker);
        //sneaker.setSale(actualSale.isEmpty()? 0 : actualSale.get(0).value());

        Assert.assertEquals(lastSale, actualSale.get(0));
    }

    @Test
    public void getSizeAndSales(){
        Sale sale = new Sale("6", 356);
        sneaker.add(sale);
        sneaker.add(new Sale("9.5", 352));
        sneaker.add(new Sale("9.5", 404));
        sneaker.add(new Sale("13", 360));
        Sale lastSale = new Sale("13", 372);
        sneaker.add(lastSale);

        Ask ask = new Ask("13", 228);
        sneaker.add(ask);
        sneaker.add(new Ask("6", 600));
        sneaker.add(new Ask("9.5", 333));
        sneaker.add(new Ask("9.5", 340));
        sneaker.add(new Ask("13", 330));
        sneaker.add(new Ask("13", 330));
        
        Criteria size = new Size("9.5");

        Criteria sales = new Sales();
        Criteria andSizeSales = new AndCriteria(size, sales);

        List<Offer> sizeSales = andSizeSales.checkCriteria(sneaker);

        Assert.assertEquals(2, sizeSales.size());
    }

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

    @Test
    public void getMinSizeAndAsks(){
        Sale sale = new Sale("6", 356);
        sneaker.add(sale);
        sneaker.add(new Sale("9.5", 352));
        sneaker.add(new Sale("9.5", 404));
        sneaker.add(new Sale("13", 360));
        Sale lastSale = new Sale("13", 372);
        sneaker.add(lastSale);

        Ask ask = new Ask("13", 228);
        sneaker.add(ask);
        sneaker.add(new Ask("6", 600));
        Ask whatWeWant = new Ask("9.5", 333);
        sneaker.add(whatWeWant);
        sneaker.add(new Ask("9.5", 340));
        sneaker.add(new Ask("13", 330));
        sneaker.add(new Ask("13", 330));
        
        Criteria size = new Size("9.5");
        Criteria asks = new Asks();
        Criteria sizeMinAsk = new Min(size, asks);
        List<Offer> sizeAsk = sizeMinAsk.checkCriteria(sneaker);

        Assert.assertEquals(whatWeWant, sizeAsk.get(0));
    }
}
