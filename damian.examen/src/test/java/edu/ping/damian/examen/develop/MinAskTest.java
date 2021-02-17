package edu.ping.damian.examen.develop;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import edu.ping.damian.examen.develop.criteria.Criteria;
import edu.ping.damian.examen.develop.criteria.MinAsk;
import edu.ping.damian.examen.develop.item.Ask;
import edu.ping.damian.examen.develop.item.Bid;
import edu.ping.damian.examen.develop.item.Item;
import edu.ping.damian.examen.develop.item.Offer;
import edu.ping.damian.examen.develop.item.Sneaker;

public class MinAskTest {
    private Item sneaker = new Sneaker("5.5", "Hola");

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
}
