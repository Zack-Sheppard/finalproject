package domainPackage;

import java.util.ArrayList;

public class PromotionHunter implements Subject {
    public ArrayList<Document> promotions;
    public ArrayList<PromotionObserver> observers;

    public PromotionHunter(ArrayList<PromotionObserver> observers, ArrayList<Document> promotions){
        this.observers= observers;
        this.promotions= promotions;

    }


    @Override
    public void register(PromotionObserver o) {
        observers.add(o);
        o.update(promotions);
    }

    @Override
    public void unregister(PromotionObserver o) {
        observers.remove(o);

    }

    @Override
    public void notifyAllObservers() {

        for (int i=0; i<observers.size();i++){
            observers.get(i).update(promotions);
        }

    }

    public void addToPromotions(Document doc){
        promotions.add(doc);
        notifyAllObservers();
    }

    public void removeFromPromotions(Document doc){
        promotions.remove(doc);
    }
}
