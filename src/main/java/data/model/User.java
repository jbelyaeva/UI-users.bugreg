package data.model;

public class User {

  private String name;
  private String email;
  private String password;

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public User withName(String name) {
    this.name = name;
    return this;
  }

  public User withEmail(String email) {
    this.email = email;
    return this;
  }

  public User withPassword(String password) {
    this.password = password;
    return this;
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
