public class ObserverDesignPatternMain {
    public static void main(String[] args) {
        NewsAgency newsAgency=new NewsAgency();

        NewsChannel aajTak=new AajTak();
        NewsChannel ndtv=new NDTV();
        NewsChannel publicTV=new PublicTV();
        NewsChannel tv9=new TV9();

        newsAgency.addObserver(aajTak);
        newsAgency.addObserver(ndtv);
        newsAgency.addObserver(publicTV);
        newsAgency.addObserver(tv9);

        //changing the state of publisher or Observable and it will be notified to all the subscribers
        newsAgency.updateNewsChannelswithNewNews("Rain at 2:00 pm");
    }
}
