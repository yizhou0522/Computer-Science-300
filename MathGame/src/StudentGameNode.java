

public class StudentGameNode
{
	public Object object;
	public static StudentGameNode fromObject(Object p0) { return new StudentGameNode((StudentGameNode)null,p0); }
	private StudentGameNode(StudentGameNode ignore, Object p1) { object = p1; } // ignore avoids collisions with existing constructors

	// pass through constructors
	public StudentGameNode(Object p0) throws GraderException { object = Student.construct("GameNode", new Object[] {p0}); }

	// pass through methods
	public int getNumber() throws GraderException { return (int) Student.callMethod(object, "getNumber"); }
	public void applyOperator(Object p0) throws GraderException { Student.callMethod(object, "applyOperator", new Object[] {p0}); }
	public Object getNext() throws GraderException { return (Object) Student.callMethod(object, "getNext"); }
	public void setNext(Object p0) throws GraderException { Student.callMethod(object, "setNext", new Object[] {p0}); }

	// field accessors and methods
	public void _number(int value) throws GraderException { Student.setField(object, "number", value); }
	public int _number() throws GraderException { return (int) Student.getField(object, "number"); }

	public void _next(Object value) throws GraderException { Student.setField(object, "next", value); }
	public Object _next() throws GraderException { return (Object) Student.getField(object, "next"); }

}

