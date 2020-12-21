package com.alten.springbootdatarest.utils;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.UUIDGenerationStrategy;

public class MySQLUUIDGenerationStrategy implements UUIDGenerationStrategy {

	@Override
	public int getGeneratedVersion() {
// TODO Auto-generated method stub
		return 2;
	}
	

	@Override
	public UUID generateUUID(SharedSessionContractImplementor session) {
// TODO Auto-generated method stub
		return ((Session) session).doReturningWork(connection -> {
			try (Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("select UUID()")) {
				while (resultSet.next()) {
					System.out.println(resultSet.getObject(1));
					return (UUID) UUID.fromString((String) resultSet.getObject(1));
				}
			}
			throw new IllegalArgumentException("Can't fetch a new UUID");
		});
	}

}
