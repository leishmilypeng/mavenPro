package com.lp.biz.service.impl;

import org.springframework.stereotype.Service;

import com.lp.biz.dao.TmScheduleJobDAO;
import com.lp.biz.service.ITmScheduleJobService;
import com.lp.common.dao.BaseDao;
import com.lp.common.service.impl.BaseServiceImpl;
import com.lp.entity.TmScheduleJob;

@Service
public class TmScheduleJobServiceImpl extends BaseServiceImpl<TmScheduleJob> implements
		ITmScheduleJobService {

	@Override
	public BaseDao getDao() {
		// TODO Auto-generated method stub
		return new TmScheduleJobDAO();
	}

	

}
