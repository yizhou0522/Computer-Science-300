

public class AccessControlTest {


  /*
   * Testing main. Runs each test and prints which (if any) failed.
   */
  public static void main(String[] args) {
    int fails = 0;
    if (!testLogin1()) {
      System.out.println("testLogin1 [bad username] failed");
      fails++;
    }
    if (!testAddUser1()) {
      System.out.println("testAddUser1 failed");
      fails++;
    }
    if (!testRemoveUser1()) {
      System.out.println("testRemoveUser1 failed");
      fails++;
    }
    if (!testResetPassword1()) {
      System.out.println("testResetPassword1  failed");
      fails++;
    }
    if (!testTakeAdmin1()) {
      System.out.println("testTakeAdmin1 [bad username with default password] failed");
      fails++;
    }
    if (fails == 0)
      System.out.println("All tests passed!");
  }

  public static boolean testLogin1() {
    AccessControl ac = new AccessControl();
    String user = "probablyNotInTheSystem1234";
    String pw = "password";
    return !AccessControl.isValidLogin(user, pw); // isValidLogin should return false
  }

  /*
   * Create a new AccessControl and do not log in an admin. Verify that addUser(String username)
   * returns false and that the new user is not added.
   * 
   * @return boolean test passed
   */
  public static boolean testAddUser1() {

    AccessControl ac = new AccessControl();
    ac.setCurrentUser("admin");
    ac.takeAdmin("admin");
    String user = "alexi";
    boolean addUserReport = ac.addUser(user);
    if (addUserReport)
      return false; // addUserReport should be false
    // Make sure user wasn't added anyway
    return !AccessControl.isValidLogin(user, "changeme");
  }

  public static boolean testRemoveUser1() {

    AccessControl ac = new AccessControl();
    ac.setCurrentUser("admin");
    ac.removeUser("admin");// remove"admin" username from user arraylist
    return !AccessControl.isValidLogin("admin", "changeme");// so "admin" username cannot login

  }

  public static boolean testTakeAdmin1() {

    AccessControl ac = new AccessControl();
    ac.setCurrentUser("admin");// isadmin

    ac.takeAdmin("isadmin");// intends to take adminstrative power from "isadmin"
    return !ac.resetPassword("isadmin");// so "isadmin" should not have such power to execute
                                        // resetPassword method

  }

  /**
   * 
   * @return
   */
  public static boolean testResetPassword1() {

    AccessControl ac = new AccessControl();
    ac.setCurrentUser("admin");
    ac.resetPassword("admin");// new password, which is DEFAULT_PASSWORD
    return !AccessControl.isValidLogin("admin", "root");// old password should not be allowed to login

  }

}
