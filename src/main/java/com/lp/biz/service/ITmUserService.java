package com.lp.biz.service;

import java.util.List;

import com.lp.common.service.IBaseService;
import com.lp.entity.TmUser;

public interface ITmUserService extends IBaseService<TmUser> {
	public void test();
	
	public List<TmUser> testUserCache();
}
