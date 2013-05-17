package com.hxrainbow.rule.operating.service;

import java.util.List;
import java.util.Map;

/**
 * Drools动作接口
 *
 * @author guolei
 * @version 1.0
 * @created 2013-04-18 下午8:40:29
 * @history 
 * @see
 */
public interface IAction {

	public void execute(Map<String,Object> map,List<Map<String,Object>> result);
}
