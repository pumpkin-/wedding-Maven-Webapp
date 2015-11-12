package com.diy.weedingsecretary.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 泛型类，基础的DAO接口
 * @Author:	Byron
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-2-25
 */
public interface BaseDao<T> {
	public List<T> find(T entity);
	public T get(Serializable id);
	public int insert(T entity);
	public int update(T entity);
	public int delete(Serializable id);
	public int delete(Serializable[] ids);
}
