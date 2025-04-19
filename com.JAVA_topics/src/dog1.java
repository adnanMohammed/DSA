
public interface dog1 extends Bird1, Fish {

	@Override
	default void eat() {
		// TODO Auto-generated method stub
		Bird1.super.eat();
	}

}
