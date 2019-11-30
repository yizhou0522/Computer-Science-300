

public class StudentGameTests
{
	public Object object;
	public static StudentGameTests fromObject(Object p0) { return new StudentGameTests((StudentGameTests)null,p0); }
	private StudentGameTests(StudentGameTests ignore, Object p1) { object = p1; } // ignore avoids collisions with existing constructors

	// pass through constructors
	public StudentGameTests() throws GraderException { object = Student.construct("GameTests"); }

	// pass through methods
	public static void main(Object p0) throws GraderException { Student.callMethod("GameTests", "main", new Object[] {p0}); }
	public static boolean test2() throws GraderException { return (boolean) Student.callMethod("GameTests", "test2"); }
	public static boolean test1() throws GraderException { return (boolean) Student.callMethod("GameTests", "test1"); }
	public static boolean test3() throws GraderException { return (boolean) Student.callMethod("GameTests", "test3"); }
	public static boolean test4() throws GraderException { return (boolean) Student.callMethod("GameTests", "test4"); }

	// field accessors and methods
}

