package com.zuller.logics;

public class FactoryMaker {

	static public ParsingFactory getFactory(String factoryName){
		if (factoryName == "AttractionFactory")
			return new AttractionFactory();
		return null;
	}
}
