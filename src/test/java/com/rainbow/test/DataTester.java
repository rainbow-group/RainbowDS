package com.rainbow.test;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rainbow.common.data.ModuleDAO;

/**
 * @author Ray
 */
public class DataTester {
	final static Logger logger = LogManager.getLogger(DataTester.class);
	public static void main(String[] s) {
		ModuleDAO dao = new ModuleDAO();
		List<String> list = dao.getModulesByUid(2L);
		logger.info(list);
	
	}

}
