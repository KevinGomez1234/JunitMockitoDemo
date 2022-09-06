package co.kevingomez.collectionsdemo;

public class Car implements Comparable<Car>{
	private String make;
	private String model;

	public Car() {}
	public Car(String make, String model) {
		this.make = make;
		this.model = model;
	}
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public int compareTo(Car o) {
		if(o.getModel() == null || o.getModel().length() == 0 || getModel().length() == 0)
			return 0;
		if (o.getModel().compareTo(getModel()) > 0)
			return -1;
		else 
			return 1;
	}
	
	@Override
	public String toString() {
		return "This cars model " + this.model;
	}

}
