package com.rainbow.core.data.mybatis;

/**
 * @author Ray
 * Rainbow
 */
public class SimpleDAO extends BaseDAO{
	
	public SimpleDAO(String tableName) {
		super();
		this.table = tableName;
	}
	
	private String table;
	
//	public List<SimpleBean> getList(){
//		
//	}



	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}
	
}
