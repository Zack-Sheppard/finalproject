package domainPackage;

public interface Subject {
    void register(PromotionObserver o);
    void unregister(PromotionObserver o);
    void notifyAllObservers();
}
