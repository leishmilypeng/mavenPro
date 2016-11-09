package com.lp.framework.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.DispatcherServlet;

import com.lp.framework.utils.EntityManagerHelper;

public class UserDispatcherServlet extends DispatcherServlet {

	private static final long serialVersionUID = 2452892285152753976L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 实现自定义控制
		EntityManager em = EntityManagerHelper.getEntityManager();
		boolean error = false;
		try {
			em.getTransaction().begin();
			String method = request.getMethod();
			if (method.equalsIgnoreCase(RequestMethod.PATCH.name())) {
				processRequest(request, response);
			} else {
				super.service(request, response);
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			error = true;
		} finally {
			EntityManagerHelper.closeEntityManager();
			if (error) {
				response.sendRedirect(request.getContextPath()
						+ "/page/error.jsp");
			}
		}
	}
}
