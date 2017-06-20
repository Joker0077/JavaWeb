package struts2ognl;

public class Address {
	private String country;
	private String city;
	private String street;

	public Address() {
		super();
	}
	public Address(String country, String city, String street) {
		super();
		this.country = country;
		this.city = city;
		this.street = street;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.country + "," + this.city + "," + this.street;
	}
}
