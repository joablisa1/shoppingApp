/**
 * 
 */
package com.shoppingcat.shoppingApp.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lisa
 *
 */
public class WebUtils
{
	private WebUtils() {
	}
	public static final String IMAGES_PREFIX = "/product/images/";
	public static final String IMAGES_DIR = "C:/jcart/products/";
	
	public static String getURLWithContextPath(HttpServletRequest request)
	{
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
	}
}
