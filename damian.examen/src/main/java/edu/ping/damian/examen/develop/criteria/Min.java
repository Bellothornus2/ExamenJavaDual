package edu.ping.damian.examen.develop.criteria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import edu.ping.damian.examen.develop.item.Item;
import edu.ping.damian.examen.develop.item.Offer;

public class Min implements Criteria {
    private Criteria criteria = null;
    private Criteria otherCriteria = null;
    public Min(Criteria firstCriteria, Criteria secondCriteria){
        this.criteria = firstCriteria;
        this.otherCriteria = secondCriteria;
    }

    @Override
    public List<Offer> checkCriteria(Item item){
        List<Offer> firstCriteriaOutput = this.criteria.checkCriteria(item);
        List<Offer> secondCriteriaOutput = this.otherCriteria.checkCriteria(item);
        firstCriteriaOutput.retainAll(secondCriteriaOutput);

        List<Integer> criteriaBids = firstCriteriaOutput.stream().map(n -> n.value()).collect(Collectors.toList());  //cojo los valores
        Integer min  = Collections.min(criteriaBids); //encunetro el minimo
        List<Offer> output = new ArrayList<Offer>();
        for (Offer offer : firstCriteriaOutput) {
            if (offer.value() == min){
                output.add(offer);
            }
        }
        return output;
    }
}
