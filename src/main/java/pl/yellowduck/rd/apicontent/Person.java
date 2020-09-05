package pl.yellowduck.rd.apicontent;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

  private String firstname;
  private String surname;

  public Person(String firstname, String surname) {
    this.firstname = firstname;
    this.surname = surname;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getSurname() {
    return surname;
  }
}
