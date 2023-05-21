public class Girl extends Human{
    String cycle;

    String boyFriend;

    public Girl(String bf,String name,int age,String address) {
        super(name, age,address);
        this.boyFriend=bf;
    }

    public Girl(String cycle, String boyFriend) {
        this.cycle = cycle;
        this.boyFriend = boyFriend;
    }

    public void canDance(){

    }
}
