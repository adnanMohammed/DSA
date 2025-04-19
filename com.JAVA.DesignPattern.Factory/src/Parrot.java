public class Parrot implements Animal{
    @Override
    public String canTalk() {
        return this.getClass()+" I am a Parrot Squirling";
    }
}
