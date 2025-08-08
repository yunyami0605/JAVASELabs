package workshop.animal.entity;

public class Cat extends Animal implements Pet {
	private String name;

	public Cat(String name) {
		super(4);
		this.name = name;
	}
	
	public Cat() {
		//super(4);
		this("");
	}	
	
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;		
	}

	@Override
	public void play() {
		System.out.println("pl!");
		
	}

	@Override
	public void eat() {
		System.out.println("eat!");		
	}
	
	
}