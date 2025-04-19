import java.util.ArrayList;
import java.util.List;
//publisher,Observables
public class NewsAgency {

    private String news;
    List<NewsChannel> newsChannelsList=new ArrayList<>();

    //add Subscribers or Observers
    public void addObserver(NewsChannel newsChannel){
        newsChannelsList.add(newsChannel);
    }

    //remove Subscribers or Observers
    public void removeObserver(NewsChannel newsChannel){
        newsChannelsList.remove(newsChannel);
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    //notifying the subscribers
    public void updateNewsChannelswithNewNews(String news){
        setNews(news);
        for (NewsChannel newsChannel : newsChannelsList) {
            newsChannel.updateNews(news);
        }
    }
}
