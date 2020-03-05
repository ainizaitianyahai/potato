package com.potato.entity;

import java.io.Serializable;
import java.util.Set;

public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Set<Menu> modules;

	public Set<Menu> getModules() {
		return modules;
	}

	public void setModules(Set<Menu> modules) {
		this.modules = modules;
	}
	
}
