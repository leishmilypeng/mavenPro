package com.lp.biz.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lp.biz.service.ITmUserService;
import com.lp.common.dao.BaseDao;
import com.lp.common.service.impl.BaseServiceImpl;
import com.lp.entity.TmUser;

@Service("testUserService")
public class TestUserServiceImpl extends BaseServiceImpl<TmUser> implements ITmUserService {

	public void test() {
		// TODO Auto-generated method stub

	}

	public List<TmUser> testUserCache() {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseDao getDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
