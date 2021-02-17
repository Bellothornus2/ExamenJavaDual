package edu.ping.damian.examen.develop;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import edu.ping.damian.examen.develop.criteria.Criteria;
import edu.ping.damian.examen.develop.criteria.LastSale;
import edu.ping.damian.examen.develop.item.Ask;
import edu.ping.damian.examen.develop.item.Item;
import edu.ping.damian.examen.develop.item.Offer;
import edu.ping.damian.examen.develop.item.Sale;
import edu.ping.damian.examen.develop.item.Sneaker;

public class LastSaleTest {
    private Item sneaker = new Sneaker("5.5", "Hola");

    
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
}
