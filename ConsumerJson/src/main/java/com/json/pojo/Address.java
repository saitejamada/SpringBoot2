package com.json.pojo;

public class Address {

		String street;
		String suite;
		String city;
		String  zipcode;
		Geoprahphy geo;
		
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getSuite() {
			return suite;
		}
		public void setSuite(String suite) {
			this.suite = suite;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getZipcode() {
			return zipcode;
		}
		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}
		public Geoprahphy getGeo() {
			return geo;
		}
		public void setGeo(Geoprahphy geo) {
			this.geo = geo;
		}
		public Address(String street, String suite, String city, String zipcode, Geoprahphy geo) {
			super();
			this.street = street;
			this.suite = suite;
			this.city = city;
			this.zipcode = zipcode;
			this.geo = geo;
		}
		public Address() {
			super();
		}
		@Override
		public String toString() {
			return "Address [street=" + street + ", suite=" + suite + ", city=" + city + ", zipcode=" + zipcode
					+ ", geo=" + geo + "]";
		}
		
}
