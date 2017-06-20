<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<caption>
			<strong>访问struts2的命名对象</strong>
		</caption>
		<tr>
			<th>OGNL表达式</th>
			<th>Java代码</th>
			<th>执行结果</th>
		</tr>
		<tr>
			<td>#parameters.greeting</td>
			<td>ActionContext.getContext.getParameters().get("greeting")</td>
			<td><s:property value="#parameters.greeting" /></td>
		</tr>
		<tr>
			<td>#request.personName</td>
			<td>ActionContext.getContext().getContextMap().get("personName")</td>
			<td><s:property value="#request.personName" /></td>
		</tr>
		<tr>
			<td>#request.personName</td>
			<td>ActionContext.getContext.getSession().get("personName")</td>
			<td><s:property value="#session.personName" /></td>
		</tr>
		<tr>
			<td>#application.personNmae</td>
			<td>ActionContext.getContext().getApplication().get("personName")</td>
			<td><s:property value="#application.personName" /></td>
		</tr>

		<tr>
			<td>#attr.personNmae</td>
			<td>(Map)ActionContext.getContext().get("attr").get("personName")</td>
			<td><s:property value="#attr.personName" /></td>
		</tr>
	</table>

	<p>
	<table border=1>
		<caption>访问列表</caption>
		<tr>
			<th>OGNL表达式</th>
			<th>Java代码</th>
			<th>执行结果</th>
		</tr>

		<tr>
			<td>person[0].name</td>
			<td>((OgnlAction)ActionContext.getValueStack().peek()).getPerson().get(0).getName()</td>
			<td><s:property value="person[0].name" /></td>
		</tr>

		<tr>
			<td>person[1].name</td>
			<td>((OgnlAction)ActionContext.getValueStack().peek()).getPerson().get(1).getName()</td>
			<td><s:property value="person[1].name" /></td>
		</tr>

		<tr>
			<td>person[2].name</td>
			<td>((OgnlAction)ActionContext.getValueStack().peek()).getPerson().get(2).getName()</td>
			<td><s:property value="person[2].name" /></td>
		</tr>

		<tr>
			<td>person.size</td>
			<td>((OgnlAction)ActionContext.getContext().getValueStack().peek()).getPerson().size()</td>
			<td><s:property value="person.size" /></td>
		</tr>

		<tr>
			<td>person.isEmpty</td>
			<td>((OgnlAction)ActionContext.getContext().getValueStack().peek()).getPerson().isEmpty()</td>
			<td><s:property value="person.isEmpty" /></td>
		</tr>
	</table>

	//
	<table border=1>
		<caption>访问数据</caption>
		<tr>
			<th>OGNL表达式</th>
			<th>Java代码</th>
			<th>执行结果</th>
		</tr>

		<tr>
			<td>person[0].aliases[0]</td>
			<td>((OgnlAction)ActionContext.getValueStack().peek()).getPerson().get().getAliases()[]</td>
			<td><s:property value="person[0].aliases[0]" /></td>
		</tr>

		<tr>
			<td>person[1].aliases[0]</td>
			<td>((OgnlAction)ActionContext.getValueStack().peek()).getPerson().get(1).getAliases()[1]</td>
			<td><s:property value="person[1].aliases[0]" /></td>
		</tr>
		<tr>
			<td>person[2].aliases[0]</td>
			<td>((OgnlAction)ActionContext.getValueStack().peek()).getPerson().get(2).getAliases()[1]</td>
			<td><s:property value="person[2].aliases[0]" /></td>
		</tr>
	</table>

	<p>
	<table border=1>
		<caption>访问map</caption>
		<tr>
			<th>OGNL表达式</th>
			<th>Java代码</th>
			<th>执行结果</th>
		</tr>

		<tr>
			<td>person[0].phones['home']</td>
			<td>((OgnlAction)ActionContext.getValueStack().peek()).getPerson().get(0).get("home")</td>
			<td><s:property value="persons['home']" /></td>
		</tr>

		<tr>
			<td>person[1].phones.office</td>
			<td>((OgnlAction)ActionContext.getValueStack().peek()).getPerson().get(1).getphones.get("office")</td>
			<td><s:property value="persons[1].phone.office" /></td>
		</tr>
		<tr>
			<td>person[2].phones.size</td>
			<td>((OgnlAction)ActionContext.getValueStack().peek()).getPerson().get(1).getphones.size()</td>
			<td><s:property value="persons[2].phone.size" /></td>
		</tr>
		<tr>
			<td>person[2].phones.isEmpty</td>
			<td>((OgnlAction)ActionContext.getValueStack().peek()).getPerson().get(1).getphones.isEmpty()</td>
			<td><s:property value="persons[2].phone.isEmpty" /></td>
		</tr>
	</table>
	<p />
	<h3>选择和投影</h3>
	<p>选择实例：person.{?#this.salary &gt; 4000}</p>
	<ul>
		<s:iterator value="persons.{?#this.salary>4000}">
			<li><s:property value="name" />
				<s:property value="salary" /></li>
	</ul>

	<p>投影事例：persons.(name)</p>
	<ul>
		<s:iterator value="persons.{getAge()}">
			<li><s:property /></li>
	</ul>
</body>
</html>