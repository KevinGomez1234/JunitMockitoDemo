package co.kevingomez.jacksondemo;
/*
 * POJO cannot implement / extend anything / have outside annotations
 * Java bean has all properties private, has a public no argument constructor, and implements serializable
 * */
class PersonD{
	private String name;
	private String dob;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	
	
}