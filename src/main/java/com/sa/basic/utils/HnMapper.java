package com.sa.basic.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;


public interface HnMapper<T> extends Mapper<T>, InsertListMapper<T> {

}
