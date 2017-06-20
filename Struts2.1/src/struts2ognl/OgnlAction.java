package struts2ognl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import ognl.OgnlException;
import ognl.Student;
import ognl.Teacher;

public class OgnlAction extends ActionSupport {
   private static final long serialVersionUID = 1L;
   private String greeting;
   private List<Person> Persons = new ArrayList<Person>();
private List<Person> persons;
   
   private void initData(){
	   Address address1 = new Address("中国","合肥","滨湖区11号");
	   Address address2 = new Address("中国","上海","浦东区23号");
	   Address address3 = new Address("中国", "北京" ,"朝阳区55号");
	   
	   String[] alias1 ={"校长", "三"};
	   String[] alias2={"老李" , "小四"};
	   String[] alias3={"老王" ,"物业"};
	   
	   List<String> email1 = new ArrayList<String>();
	   email1.add("zhangsan@163.com");
	   email1.add("zhangsan@gmal.com");
	   List<String> email2 = new ArrayList<String>();
	   email2.add("lisi@163.com");
	   email2.add("lisi@qq.com");
	   List<String> email3 = new ArrayList<String>();
	   email3.add("wangwu@163.com");
	   email3.add("wangwu@qq.com");
	   
	   Map<String,String> phone1 = new HashMap<String,String>();
	   phone1.put("home", "545645644");
	   phone1.put("office", "8453");
	   Map<String,String> phone2 = new HashMap<String,String>();
	   phone2.put("home", "21435");
	   phone2.put("phone","845");
	   Map<String,String> phone3 = new HashMap<String,String>();
	   phone3.put("home","765432");
	   phone3.put("phone", "0987654");
	   
	   Person person1 = new Person("zhangsan",33,333,address1,alias1,email1,phone1);
	   Person person2 = new Person("lisi", 44 ,444,address2,alias2,email2,phone2);
	   Person person3 = new Person("wangwu",55,555,address3,alias3,email3,phone3);
	   
	   persons.add(person1);
	   persons.add(person2);
	   persons.add(person3);
   }
	
   
   @SuppressWarnings({"unchecked","rawtypes"})
   @Override
   public String execute() throws Exception{
	   initData();
	   valueStack1();
	   ActionContext actionContext =ActionContext.getContext();
	   Map request = actionContext.getContextMap();
	   Map session = actionContext.getContextMap();
	   Map application = actionContext.getApplication();
	   request.put("personName", persons.get(0).getName());
	   session.put("personName", persons.get(1).getName());
	   application.put("personName",persons.get(1).getName());
	   
	return SUCCESS;
   }
   
	public void valueStack1() throws OgnlException{
		Student stu = new Student("Jack",20);
		Teacher tea = new Teacher("Scott",40);
		
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.push(stu);
		System.out.println(valueStack.findValue("name"));
		valueStack.push(tea);
		System.out.println(valueStack.findValue("name"));
		System.out.println("...........................");
		System.out.println(valueStack.findValue("score"));
		System.out.println(valueStack.findValue("salary"));
		
		System.out.println("..........................");
		valueStack.setValue("name", "Rose");
		System.out.println(valueStack.findValue("name"));
		valueStack.setValue("score", "80");
		System.out.println(valueStack.findValue("score"));
		System.out.println("............................");		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private void valueStack() {
	// TODO Auto-generated method stub
	
}


	

