

public class StudentGameOperator
{
	public Object object;
	public static StudentGameOperator fromObject(Object p0) { return new StudentGameOperator((StudentGameOperator)null,p0); }
	private StudentGameOperator(StudentGameOperator ignore, Object p1) { object = p1; } // ignore avoids collisions with existing constructors

	// pass through constructors
	public StudentGameOperator(char p0) throws GraderException { object = Student.construct("GameOperator", new Object[] {p0}); }

	// pass through methods
	public String _toString() throws GraderException { return (String) Student.callMethod(object, "toString"); }
	public int apply(int p0, int p1) throws GraderException { return (int) Student.callMethod(object, "apply", new Object[] {p0, p1}); }
	public static Object getFromChar(char p0) throws GraderException { return (Object) Student.callMethod("GameOperator", "getFromChar", new Object[] {p0}); }

	// field accessors and methods
	public static void _ALL_OPERATORS(Object value) throws GraderException { Student.setField("GameOperator", "ALL_OPERATORS", value); }
	public static Object _ALL_OPERATORS() throws GraderException { return (Object) Student.getField("GameOperator", "ALL_OPERATORS"); }

	public void _operator(char value) throws GraderException { Student.setField(object, "operator", value); }
	public char _operator() throws GraderException { return (char) Student.getField(object, "operator"); }

}

