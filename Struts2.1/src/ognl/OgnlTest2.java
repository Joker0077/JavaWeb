package ognl;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OgnlTest2 {
/**
 * 
 * @param args
 * @throws OgnlException
 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws OgnlException {
		PrintStream out = System.out;
		OgnlBean bean = new OgnlBean();
		
		OgnlContext context = new OgnlContext();
		context.put("bean", bean);
	/**
	 * 
	 */
out.println(Ognl.getValue("Hello", context));
out.print(Ognl.getValue("A", context));
out.print(Ognl.getValue("A", context));
out.print(Ognl.getValue("true", context));
out.print(Ognl.getValue("null", context));
/**
 * 
 */
out.print(Ognl.getValue("#name='zhangsan'", context));
out.print(Ognl.getValue("bean.property", context));
out.print(Ognl.getValue("bean.method(", context));
/**
 * 
 */
	out.print(Ognl.getValue("@com.dashe.struts2.OgnlBean@staticProperty", context));
	out.print(Ognl.getValue("@com.dashe.struts2.OgnlBean@staticMethod(", context));
	/**
	 * 
	 */
	out.print(Ognl.getValue("(new java.lang.String(\"Instance a new object!\")).toString()", context));
	/**
	 * 获取bean中的元素
	 */
	out.print(Ognl.getValue("bean.getArray()[0]", context));
	out.print(Ognl.getValue("bean.array[0]", context));
	/**
	 * List
	 * 
	 */
	out.println(Ognl.getValue("bean.getList()[0]", context));
	out.print(Ognl.getValue("bean.list[0]", context));
	/**
	 * map
	 */
	out.print(Ognl.getValue("bean.getMap()['home']", context));
	out.print(Ognl.getValue("bean.map['home']", context));
	out.print(Ognl.getValue("bean.getMap().office", context));
	out.print(Ognl.getValue("bean.map.office", context));
	/**
	 * shuzu
	 */
	int[] array = (int[])Ognl.getValue("new int[]{0,1,2,3,4,5}", context);
	out.println(Arrays.toString(array));
	/**
	 * List
	 */
	List list =(List)Ognl.getValue("(0,1,2,3,4,5)", context);
	out.println(list);
	/**
	 * map
	 */
	Map map =(Map)Ognl.getValue("#{'key1':'value1', 'key2':'value2', 'key3':'value3'}", context);
	out.println(map);
	/**
	 * 
	 * fangzhi list
	 */
	List<Teacher> teacherList = new ArrayList<Teacher>();
	teacherList.add(new Teacher("Jack1",2000));
	teacherList.add(new Teacher("Jack2",2200));
	teacherList.add(new Teacher("Jack3",2300));
	teacherList.add(new Teacher("Jack4",2400));
	teacherList.add(new Teacher("Jack5",2500));
	teacherList.add(new Teacher("Jack6",2800));
	context.put("teacherList", teacherList);
	//
	out.println(Ognl.getValue("teacherList.{name}", context));
	out.println(Ognl.getValue("teacherList.{#this.name.toUpperCase()}", context));
	out.println(Ognl.getValue("teacherList.{#this.salary>2500?#this.salary:#this.salary+99}", context));
	
	//
	out.println(Ognl.getValue("teacherList.{?#this.salary?2500}", context));
	out.println(Ognl.getValue("teacherList.{?#this.salary?2500}[0]", context));
	out.println(Ognl.getValue("teacherList.{^#this.salary?2500}", context));
	out.println(Ognl.getValue("teacherList.{$#this.salary?2500}", context));
	
	}

}
