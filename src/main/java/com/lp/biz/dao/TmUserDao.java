package com.lp.biz.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.lp.common.dao.BaseDaoJpa;
import com.lp.entity.TmUser;
import com.lp.framework.utils.EntityManagerHelper;

public class TmUserDao extends BaseDaoJpa<TmUser>{
	
	public List<TmUser> getTmUserList(){
		EntityManager em = EntityManagerHelper.getEntityManager();
		StringBuffer sb = new StringBuffer();
		sb.append(" from TmUser tu where tu.id.entityCode='").append("HD521300").append("' ");
		List list = em.createQuery(sb.toString()).getResultList();
		return list;
	}
	
}
