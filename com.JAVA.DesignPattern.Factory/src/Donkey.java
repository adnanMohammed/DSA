public class Donkey implements Animal{
    @Override
    public String canTalk() {
        return this.getClass()+" I am a Donkey Doggling";
    }
}
