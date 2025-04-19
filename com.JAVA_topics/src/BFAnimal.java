
public class BFAnimal implements Bird1, Fish {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		Bird1.super.eat();
	}

}

class mainm{
	public static void main(String[] args) {
		Bird1 b=new BFAnimal();
		b.eat();
	}
}
