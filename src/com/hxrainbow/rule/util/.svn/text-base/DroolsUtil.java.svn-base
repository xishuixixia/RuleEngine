package com.hxrainbow.rule.util;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.compiler.DroolsParserException;
import org.drools.definition.KnowledgePackage;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;


/**
 * Drools工具类
 * 
 * @author guolei
 * @version 1.0
 * @created 2013-3-8 上午11:15:16
 * @history 
 * @see
 */
public class DroolsUtil {
	
	private static Map<String,KnowledgeBase> ruleMap = new ConcurrentHashMap<String, KnowledgeBase>(); //key：scene
	
	private DroolsUtil(){
	};
	
	private static class SingletonHolder {
		  static DroolsUtil instance = new DroolsUtil();
	}
	public static  DroolsUtil getInstance(){
		return SingletonHolder.instance;
	}
	
	/**
	 * 根据规则字符串重新编译规则，并将编译后的KnowledgeBase存入缓存
	 * 
	 * @param rule
	 * @return
	 * @throws DroolsParserException
	 * @throws IOException
	 * @author guolei
	 * @version 1.0
	 * @created 2013-5-2
	 */
	public StatefulKnowledgeSession getDrlSession(String rule,String scene) throws DroolsParserException {

		final KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		Reader strReader = null;
		try{
			strReader = new StringReader(rule);
			kbuilder.add(ResourceFactory.newReaderResource(strReader),ResourceType.DRL);
		}catch (Exception e) {
			try {
				strReader.close();//关闭流
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if (kbuilder.hasErrors()) {
			System.out.println(kbuilder.getErrors().toString());
			throw new RuntimeException("Unable to compile drool rules.");
		}
		Collection<KnowledgePackage> pkgs = kbuilder.getKnowledgePackages();
		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(pkgs);
		ruleMap.put(scene, kbase);
		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
		return ksession;
	}
	/**
	 * 根据场景获取缓存中的kbase,然后创建session，如果返回null，则表示缓存中没有
	 * 
	 * @param scene
	 * @return
	 * @throws DroolsParserException
	 * @throws IOException
	 * @author guolei
	 * @version 1.0
	 * @created 2013-5-2
	 */
	public StatefulKnowledgeSession getDrlSessionInCache(String scene){
		KnowledgeBase kbase =  ruleMap.get(scene);
		if(kbase == null){
			return null;
		}else{
			return kbase.newStatefulKnowledgeSession();
		}
	}

	/**
	 * 根据规则字符串重新编译规则，并将编译后的KnowledgeBase存入缓存
	 * 
	 * @param rule
	 * @return
	 * @throws DroolsParserException
	 * @throws IOException
	 * @author guolei
	 * @version 1.0
	 * @created 2013-5-2
	 */
	public int compileRule(String rule) throws DroolsParserException {

		final KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		Reader strReader = null;
		try{
			strReader = new StringReader(rule);
			kbuilder.add(ResourceFactory.newReaderResource(strReader),ResourceType.DRL);
		}catch (Exception e) {
			try {
				strReader.close();//关闭流
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if (kbuilder.hasErrors()) {
			System.out.println(kbuilder.getErrors().toString());
			return 1;
		}
		return 2;
	}
	
	
	/**
	 * 供其它部分调用，比如规则的修改和删除
	 * 
	 * @param key
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-19
	 */
	public static void removeRuleMap(String key){
		ruleMap.remove(key);
	}
	
	public static void removeRuleMap(){
		ruleMap.clear();
	}
}
