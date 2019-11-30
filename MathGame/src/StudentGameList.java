

public class StudentGameList
{
	public Object object;
	public static StudentGameList fromObject(Object p0) { return new StudentGameList((StudentGameList)null,p0); }
	private StudentGameList(StudentGameList ignore, Object p1) { object = p1; } // ignore avoids collisions with existing constructors

	// pass through constructors
	public StudentGameList() throws GraderException { object = Student.construct("GameList"); }

	// pass through methods
	public String _toString() throws GraderException { return (String) Student.callMethod(object, "toString"); }
	public boolean contains(int p0) throws GraderException { return (boolean) Student.callMethod(object, "contains", new Object[] {p0}); }
	public void addNode(Object p0) throws GraderException { Student.callMethod(object, "addNode", new Object[] {p0}); }
	public void applyOperatorToNumber(int p0, Object p1) throws GraderException { Student.callMethod(object, "applyOperatorToNumber", new Object[] {p0, p1}); }

	// field accessors and methods
	public void _list(Object value) throws GraderException { Student.setField(object, "list", value); }
	public Object _list() throws GraderException { return (Object) Student.getField(object, "list"); }

}

