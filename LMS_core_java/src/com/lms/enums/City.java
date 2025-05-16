package com.lms.enums;

public enum City {
	MUMBAI,PUNE,CHENNAI
}
/*
 * values() : iterates and gives all the cities
 * valueOf(<value>) : tell u if this is a legitimate value
 * 
 * how can i convert enums to List 
 * List<City> list = new ArrayList<>(Arrays.asList(cities));
 * 
 * to make a list of String out of enum:
 * List<String> list = new ArrayList<>(); 
 * for(City city :cities){
 * 		list.add(city.toString());
 * }
 */