package com.qicheng.old.tool;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelfRequestProcessor {
	public SelfRequestProcessor() {
	}

	protected boolean processPreprocess(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("gb2312");
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}
		return true;
	}
}
