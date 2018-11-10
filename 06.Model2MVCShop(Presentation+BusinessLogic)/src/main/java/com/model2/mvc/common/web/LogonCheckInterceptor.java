package com.model2.mvc.common.web;

import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.User;

/*
 * FileName : LogonCheckInterceptor.java
 *  �� Controller ȣ���� interceptor �� ���� ��ó��/��ó��/�Ϸ�ó���� ����
 *  	- preHandle() : Controller ȣ���� ��ó��   
 * 			(true return ==> Controller ȣ�� / false return ==> Controller ��ȣ�� ) 
 *  	- postHandle() : Controller ȣ�� �� ��ó��
 *    	- afterCompletion() : view ������ ó��
 *    
 *    ==> �α����� ȸ���̸� Controller ȣ�� : true return
 *    ==> �� �α����� ȸ���̸� Controller �� ȣ�� : false return
 */
public class LogonCheckInterceptor extends HandlerInterceptorAdapter {

	/// Field
	private static Properties wording;
	public static void setProperty(Properties wordingProp) {
		wording=wordingProp;
	}
	/// Constructor
	public LogonCheckInterceptor() {
		System.out.println("\nCommon :: " + this.getClass() + "\n");
	}

	/// Method
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("\n[ LogonCheckInterceptor start........]");

		// ==> �α��� ����Ȯ��
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");

		// ==> �α����� ȸ���̶��...
		if (user != null) {
			// ==> �α��� ���¿��� ���� �Ұ� URI
			String uri = request.getRequestURI();
			if (uri.indexOf("addUserView") != -1 || uri.indexOf("addUser") != -1 || uri.indexOf("loginView") != -1
					|| uri.indexOf("login") != -1 || uri.indexOf("checkDuplication") != -1) {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				System.out.println("[ �α��� ����.. �α��� �� ���ʿ� �� �䱸.... ]");
				System.out.println("[ LogonCheckInterceptor end........]\n");
				return false;
			}

			System.out.println("[ �α��� ���� ... ]");
			System.out.println("[ LogonCheckInterceptor end........]\n");
			return true;
		} else { // ==> �� �α����� ȭ���̶��...
					// ==> �α��� �õ� ��.....
			String uri = request.getRequestURI();
			if (uri.indexOf("addUserView") != -1 || uri.indexOf("addUser") != -1 || uri.indexOf("loginView") != -1
					|| uri.indexOf("login") != -1 || uri.indexOf("checkDuplication") != -1
					|| uri.indexOf("listProduct") != -1 || uri.indexOf("getProduct") != -1) {
				System.out.println("[ �α� �õ� ���� .... ]");
				System.out.println("[ LogonCheckInterceptor end........]\n");
				return true;
			}

			request.getRequestDispatcher("/index.jsp").forward(request, response);
			System.out.println("[ �α��� ���� ... ]");
			System.out.println("[ LogonCheckInterceptor end........]\n");
			return false;
		}
	}

	public boolean postHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("postHandle start");

		List<Product> products = (List<Product>) request.getAttribute("list");

		for (Product product : products) {
			if (product != null) {
				System.out.println("getProTranCode: " + product.getProTranCode().trim());
				System.out.println("wording: " + wording.getProperty(product.getProTranCode().trim()));
				product.setProTranCode(wording.getProperty(product.getProTranCode().trim()));
			}
		}

		return true;
	}
}// end of class