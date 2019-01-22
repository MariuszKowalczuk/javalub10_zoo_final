package pl.sdacademy.animals.bear;

public class BearHibernatingException extends RuntimeException{
    public BearHibernatingException() {
        super();
        System.out.println("Stary niedźwiedź mocno śpi");
    }
}
