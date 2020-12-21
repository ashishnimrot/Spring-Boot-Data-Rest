package com.alten.springbootdatarest.utils;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class DBPhysicalNamingStrategyImpl extends PhysicalNamingStrategyStandardImpl {

	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
		String tableName = name.getText() + "_tbl";
		return super.toPhysicalTableName(Identifier.toIdentifier(tableName), context);
	}
	
	
}
