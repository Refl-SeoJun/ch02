package org.zerock.jdbcex.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public enum MapperUtil {
	INSTANCE;
	
	private ModelMapper mapper;
	
	MapperUtil(){
		mapper = new ModelMapper();
		mapper
		.getConfiguration()
		.setFieldMatchingEnabled(true)
		.setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
		.setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	public ModelMapper getMapper() {
		return mapper;
	}
}
