

public class StudentGameApplication {
  public Object object;

  public static StudentGameApplication fromObject(Object p0) {
    return new StudentGameApplication((StudentGameApplication) null, p0);
  }

  private StudentGameApplication(StudentGameApplication ignore, Object p1) {
    object = p1;
  } // ignore avoids collisions with existing constructors

  // pass through constructors
  public StudentGameApplication(Object p0, Object p1) throws GraderException {
    object = Student.construct("GameApplication", new Object[] {p0, p1});
  }

  // pass through methods
  public static void main(Object p0) throws GraderException {
    Student.callMethod("GameApplication", "main", new Object[] {p0});
  }

  public void play() throws GraderException {
    Student.callMethod(object, "play");
  }

  // field accessors and methods
  public void _in(Object value) throws GraderException {
    Student.setField(object, "in", value);
  }

  public Object _in() throws GraderException {
    return (Object) Student.getField(object, "in");
  }

  public void _rng(Object value) throws GraderException {
    Student.setField(object, "rng", value);
  }

  public Object _rng() throws GraderException {
    return (Object) Student.getField(object, "rng");
  }

  public void _gameList(Object value) throws GraderException {
    Student.setField(object, "gameList", value);
  }

  public Object _gameList() throws GraderException {
    return (Object) Student.getField(object, "gameList");
  }

  public void _moveCount(int value) throws GraderException {
    Student.setField(object, "moveCount", value);
  }

  public int _moveCount() throws GraderException {
    return (int) Student.getField(object, "moveCount");
  }

  public void _targetNumber(int value) throws GraderException {
    Student.setField(object, "targetNumber", value);
  }

  public int _targetNumber() throws GraderException {
    return (int) Student.getField(object, "targetNumber");
  }

}

