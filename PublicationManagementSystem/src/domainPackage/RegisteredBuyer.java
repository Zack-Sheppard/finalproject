package domainPackage;

import java.util.ArrayList;

public class RegisteredBuyer extends Buyer implements PromotionObserver{

    ArrayList<Document> promotions;
    Subject promotionHunter;

    @Override
    public void update(ArrayList<Document> promo) {
        this.promotions=promo;
    }

    public void subscribe(Subject s){
        promotionHunter= s;
        s.register(this);
    }

    public void unsubscribe(Subject s){
        s.unregister(this);
    }

	
}
