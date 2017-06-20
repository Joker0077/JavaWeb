package com.hxd.bean;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class User {
		private int id;
		private String name;
		private String age;
		private String phone;
		public User(){
			
			
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		
}
