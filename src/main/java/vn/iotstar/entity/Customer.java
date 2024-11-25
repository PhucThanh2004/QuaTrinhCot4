package vn.iotstar.entity;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@lombok.Builder
public class Customer {
	
	private String id;
	private String name;
	private String phoneNumber;
	private String email;

}