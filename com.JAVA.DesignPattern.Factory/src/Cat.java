public class Cat implements Animal {
    @Override
    public String canTalk() {
        return this.getClass()+" I am a cat talking Meow";
    }
}
