package com.iparsables.zuller;

import java.net.URL;
import java.util.Date;

import com.google.gson.JsonObject;

import android.R.integer;
import android.R.string;
import android.location.Address;


public abstract class Attraction implements IParsable,IDisplayable {

	
	private String _id;
	private String name;
	private URL logo;
	private String[] images;
	private int minAge;
	private Address adress;
	private Date date;
	private int weight;
	private String phoneNumber;
	private String[] music;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public URL getLogo() {
		return logo;
	}
	public void setLogo(URL logo) {
		this.logo = logo;
	}
	public String[] getImages() {
		return images;
	}
	public void setImages(String[] images) {
		this.images = images;
	}
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	public Address getAdress() {
		return adress;
	}
	public void setAdress(Address adress) {
		this.adress = adress;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String[] getMusic(){
		return music;
	}
	public void setMusic(String[] music){
		this.music = music;
	}
	
		
	}
