package com.rainbow.core.data.jdbc;

import java.lang.reflect.Field;
import java.sql.ResultSet;

import com.rainbow.common.util.StrUtil;
import com.rainbow.core.annotation.Column;

/**
 * @author Ray
 *
 *         Sep 15, 2015
 */
public class BaseRepository extends BaseConnection {

	protected void fillData(Object object, ResultSet rs) {
		Class clz = object.getClass();
		Field[] fields_pub = clz.getFields();
		Field[] fields_pri = clz.getDeclaredFields();

		Field[] fields = new Field[fields_pub.length + fields_pri.length];
		System.arraycopy(fields_pub, 0, fields, 0, fields_pub.length);
		System.arraycopy(fields_pri, 0, fields, fields_pub.length, fields_pri.length);

		for (Field f : fields) {
			try {
				String columnName = f.getAnnotation(Column.class).name();
				Object rsValue = null;
				if (columnName != null && !columnName.equals("")) {
					Class fieldType = Class.forName(getFieldTypeClassName(f));
					if (rs.getObject(columnName) != null) {
						rsValue = ResultSet.class.getDeclaredMethod(getRsMethodNameByFieldType(f), String.class)
								.invoke(rs, columnName);
					}

					object.getClass().getMethod(getObjectSetMethodbyField(f), fieldType).invoke(object, rsValue);
				}

			} catch (Exception e) {
				continue;
			}

		}
	}

	private String getRsMethodNameByFieldType(Field field) {
		String fildType = field.getGenericType().toString();

		fildType = StrUtil.toUpperCaseFirstOne(fildType.substring(fildType.lastIndexOf(".") + 1).toLowerCase());

		if (fildType.equalsIgnoreCase("Integer")) {
			fildType = "Int";
		}

		String methodName = "get" + fildType;

		return methodName;
	}

	private String getFieldTypeClassName(Field field) {
		String fildType = field.getGenericType().toString().replace("class ", "");

		return fildType;
	}

	private String getObjectSetMethodbyField(Field field) {
		String fieldName = field.getName();
		fieldName = StrUtil.toUpperCaseFirstOne(fieldName.substring(fieldName.lastIndexOf(".") + 1));

		String methodName = "set" + fieldName;

		return methodName;
	}
}
