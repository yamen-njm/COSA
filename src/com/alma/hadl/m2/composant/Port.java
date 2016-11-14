package com.alma.hadl.m2.composant;

import com.alma.hadl.m2.util.Callable;

public abstract class Port extends Callable {
	
	public String getNom() {
		return getClass().getSimpleName();
	}
	
}
