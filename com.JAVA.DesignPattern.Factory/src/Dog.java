public class Dog implements Animal{
    @Override
    public String canTalk() {
        return this.getClass()+" I am a Dog Barking";
    }
}
