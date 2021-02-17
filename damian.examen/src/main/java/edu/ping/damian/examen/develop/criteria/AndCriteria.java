package edu.ping.damian.examen.develop.criteria;

import java.util.List;

import edu.ping.damian.examen.develop.item.Item;
import edu.ping.damian.examen.develop.item.Offer;
import edu.ping.damian.examen.develop.item.Sneaker;

public class AndCriteria implements Criteria {
    private Criteria criteria = null;
    private Criteria otherCriteria = null;

    public AndCriteria(Criteria firstCriteria, Criteria secondCriteria){
        this.criteria = firstCriteria;
        this.otherCriteria = secondCriteria;
    }

    @Override
    public List<Offer> checkCriteria(Item item){
        List<Offer> firstCriteriaOutput = this.criteria.checkCriteria(item);
        List<Offer> secondCriteriaOutput = this.otherCriteria.checkCriteria(item);
        firstCriteriaOutput.retainAll(secondCriteriaOutput);
        return firstCriteriaOutput;
    }

}
