package ognl;

import java.io.PrintStream;

public class OgnlTest1 {
	/**
	 * 
	 * 
	 */

	public static void main(String[] args) throws OgnlException {
		Student stu = new Student("Jack", 20);
		Teacher tea = new Teacher("Scott", 40);

		OgnlContext context = new OgnlContext();
		context.put("student", stu);
		context.put("teacher", tea);

		PrintStream out = System.out;
		out.println(Ognl.getValue("name", context, stu));
		out.print(Ognl.getValue("name", context, tea));

		out.print(Ognl.getValue("student.name", context));
		out.print(Ognl.getValue("student.score", context));

		out.print(Ognl.getValue("teacher.name", context));
		out.print(Ognl.getValue("teacher.salary", context));

	}
}
