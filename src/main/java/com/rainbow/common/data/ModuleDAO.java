package com.rainbow.common.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rainbow.core.data.mybatis.BaseDAO;
import com.rainbow.core.data.mybatis.vo.SimpleBean;

public class ModuleDAO extends BaseDAO{

	public ModuleDAO() {
		super();
	}
	
	public List<String> getModulesByUid(Long uid){
		List<String> modules = new ArrayList<String>();
		
		SqlSession session = sqlSessionFactory.openSession();
		List<SimpleBean> result = session.selectList("findModulesByUid", uid);
		
		if(result!=null && !result.isEmpty()){
			for(SimpleBean module : result){
				modules.add(module.getName());
			}
		}
		
		return modules;
		
	}
}
