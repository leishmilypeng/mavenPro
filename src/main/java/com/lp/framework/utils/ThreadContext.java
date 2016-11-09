package com.lp.framework.utils;

import javax.persistence.EntityManager;

public class ThreadContext {
    EntityManager manager;
	
	public ThreadContext()
    {
		manager = null;
    }

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
}
