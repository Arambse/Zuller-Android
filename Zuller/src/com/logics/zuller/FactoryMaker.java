package com.logics.zuller;

public class FactoryMaker {

	public ParsingFactory getFactory(String factoryName){
		if (factoryName == "AttractionFactory")
			return new AttractionFactory();
		return null;
	}
}
