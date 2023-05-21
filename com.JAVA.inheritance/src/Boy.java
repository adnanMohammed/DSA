public class Boy extends Human {
    String bike;
    String girlFriend;
    public Boy(){

    }
    public Boy(String gf,String name,int age,String address) {
        super(name,age,address);
        this.girlFriend=gf;
        super.age=age;
        super.canWork("male");
    }

    public Boy(String bike, String girlFriend) {
        this.bike = bike;
        this.girlFriend = girlFriend;
    }

     void canSing(){
        System.out.println("I am singing");
    }
}
