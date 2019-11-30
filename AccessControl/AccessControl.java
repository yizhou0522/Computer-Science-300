import java.util.ArrayList;
import java.util.Scanner;




public class AccessControl {

  private static ArrayList<User> users; // An ArrayList of valid users.
  private User currentUser; // Who is currently logged in, if anyone?
  private static final String DEFAULT_PASSWORD = "changeme";
  // Default password given to
  // new users or when we reset a user's password.

  /**
   * A no-parameter constructor, initialize the user arraylist.
   */
  public AccessControl() {
    users = new ArrayList<>();
    users.add(new User("admin", "root", true));
    currentUser = null;
  }

  /**
   * 
   * @param username is the user input of his/her username
   * @param password is the user input of his.her password
   * @return true if the given username and password pair is matched with the elements in the
   *         arraylist; false otherwise.
   */
  public static boolean isValidLogin(String username, String password) {
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username) && users.get(i).isValidLogin(password))
        return true;
    }
    return false;
  }

  /**
   * This method intends to change the current user's password
   * 
   * @param newPassword is the user input of his/her new password
   */
  public void changePassword(String newPassword) {

    currentUser.setPassword(newPassword);

  } //

  /**
   * This method intends to Log out the current user.
   */
  public void logout() {
    currentUser = null;
  }

  /**
   * A mutator you can use to write tests without simulating user input
   * 
   * @param username is the name tester want to set
   */
  public void setCurrentUser(String username) {
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username))
        currentUser = users.get(i);
    }

  }

  /**
   * This method intends to Create a new user With the default password and isAdmin==false
   * 
   * @param username is the adminstrator input of his/her username
   * @return true if the given username is unique in the user arraylist, false otherwise.
   */
  public boolean addUser(String username) {
    if (!currentUser.getIsAdmin()) {
      return false;
    } else {
      for (int i = 0; i < users.size(); i++)
        if (users.get(i).getUsername().equals(username))
          return false;
      users.add(new User(username, DEFAULT_PASSWORD, false));
      return true;
    }
  }

  /**
   * This method intends to Create a new user and specify their admin status
   * 
   * @param username is the adminstrator's input of username.
   * @param isAdmin is the adminstrator's setting of the account's adminstrator's rights
   * @return true if the given username is unique the user arraylist,false otherwise.
   */
  public boolean addUser(String username, boolean isAdmin) {
    if (!currentUser.getIsAdmin()) {
      return false;
    } else {
      for (int i = 0; i < users.size(); i++)
        if (users.get(i).getUsername().equals(username))
          return false;
      users.add(new User(username, DEFAULT_PASSWORD, isAdmin));
      return true;
    }
  } //

  /**
   * This method intends to Remove a user (names should be unique).
   * 
   * @param username is the adminstrator's input of username.
   * @return true if there is an exact username matched with given username in the arraylist, false
   *         otherwise.
   */
  public boolean removeUser(String username) {
    if (!currentUser.getIsAdmin()) {
      return false;
    } else {
      for (int i = 0; i < users.size(); i++)
        if (users.get(i).getUsername().equals(username)) {
          users.remove(users.get(i));
          i--;
          return true;
        }
      return false;
    }

  } //

  /**
   * This method intends to Give a user admin power.
   * 
   * @param username is the the adminstrator's input of username.
   * @return true if there is an exact username matched with given username in the arraylist, false
   *         otherwise.
   */
  public boolean giveAdmin(String username) {
    if (!currentUser.getIsAdmin()) {
      return false;
    } else {
      for (int i = 0; i < users.size(); i++)
        if (users.get(i).getUsername().equals(username)) {
          users.get(i).setIsAdmin(true);
          return true;
        }
      return false;
    }
  }

  //
  /**
   * This method intends to Remove a user's admin power.
   * 
   * @param username is the the adminstrator's input of username.
   * @return true if there is an exact username matched with given username in the arraylist, false
   *         otherwise.
   */
  public boolean takeAdmin(String username) {
    if (!currentUser.getIsAdmin()) {
      return false;
    } else {
      for (int i = 0; i < users.size(); i++)
        if (users.get(i).getUsername().equals(username)) {
          users.get(i).setIsAdmin(false);
          return true;
        }
      return false;
    }
  } //

  /**
   * This method intends to reset a user's password.
   * 
   * @param username is the the adminstrator's input of username.
   * @return true if there is an exact username matched with given username in the arraylist, false
   *         otherwise.
   */
  public boolean resetPassword(String username) {
    if (!currentUser.getIsAdmin()) {
      return false;
    } else {
      for (int i = 0; i < users.size(); i++)
        if (users.get(i).getUsername().equals(username)) {
          users.get(i).setPassword(DEFAULT_PASSWORD);
          return true;
        }
      return false;
    }
  }

  /**
   * Main driver loop. Prompt the user for login information calls the isValidLogin method. If the
   * login is valid, call the sessionScreen method
   * 
   * @param userInputScanner is an input scanner object in the main method.
   */
  public void loginScreen(Scanner userInputScanner) {

    String username1;
    String password1;
    while (true) {
      System.out.print("Enter your username: ");
      username1 = userInputScanner.nextLine();
      System.out.print("Enter your password: ");
      password1 = userInputScanner.nextLine();
      if (isValidLogin(username1, password1)) {
        System.out.println("Success in login");
        sessionScreen(username1, userInputScanner);

      } else
        System.out.println("Invalid login.");
    }
  } 

  /**
   * Set the currentUser Allows them to changePassword or logout If they are an admin, gives access
   * to admin methods
   * 
   * @param username is the username given by the loginScreen method
   * @param userInputScanner it the Scanner object given by the loginScreen method.
   */
  public void sessionScreen(String username, Scanner userInputScanner) {

    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        currentUser = users.get(i);//initialize the currentUser
      }
    }

    while (true) {
      System.out.print("Enter your command: ");
      String input;
      input = userInputScanner.nextLine().trim();
      String[] inputArray = input.split(" ");
      if (inputArray[0].equals("logout")) {
        logout();
        break;
      } else if (inputArray[0].equals("newpw")) {
        if (inputArray.length < 2)
          continue;// prevent user's disorder input, prevent arrayindexoutofbound exception
        changePassword(inputArray[1]);
      } else if (inputArray[0].equals("adduser") && inputArray.length == 2) {
        if (inputArray.length < 2)
          continue;
        addUser(inputArray[1]);

      } else if (inputArray[0].equals("adduser") && inputArray.length == 3) {
        if (inputArray.length < 3)
          continue;
        addUser(inputArray[1], Boolean.parseBoolean(inputArray[2]));

      } else if (inputArray[0].equals("rmuser")) {
        if (inputArray.length < 2)
          continue;
        removeUser(inputArray[1]);

      } else if (inputArray[0].equals("giveadmin")) {
        if (inputArray.length < 2)
          continue;
        giveAdmin(inputArray[1]);

      } else if (inputArray[0].equals("rmadmin")) {
        if (inputArray.length < 2)
          continue;
        takeAdmin(inputArray[1]);

      } else if (inputArray[0].equals("resetpw")) {
        if (inputArray.length < 2)
          continue;
        resetPassword(inputArray[1]);

      }

    }
  }

  /**
   * main method, intends to drive the whole progran
   * 
   */
  public static void main(String[] args) {
    AccessControl ac = new AccessControl();
    // If we have any persistent information to lead
    // this is where we load it.
    Scanner userIn = new Scanner(System.in);
    ac.loginScreen(userIn);
  }
}

