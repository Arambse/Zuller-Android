package com.logics.zuller;

import android.net.ParseException;

import com.iparsables.zuller.IParsable;

public interface ParsingFactory {

	public IParsable Parse(Object object);
}