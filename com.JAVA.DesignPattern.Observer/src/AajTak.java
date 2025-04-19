//Concrete Observer
//subscriber
public class AajTak implements NewsChannel{

    private String news;
    @Override
    public void updateNews(Object news) {
        this.setNews((String) news);
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
