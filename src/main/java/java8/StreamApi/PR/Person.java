package java8.StreamApi.PR;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
  private String name;
  private int age;
  private Sex sex;
  private List<Cat> catList;

  public Person(String name, int age, Sex sex) {
    this.name = name;
    this.age = age;
    this.sex = sex;
    catList = new ArrayList<>();
  }

  public Person(String name, int age, Sex sex, List<Cat> catList) {
    this.name = name;
    this.age = age;
    this.sex = sex;
    this.catList = catList;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public Sex getSex() {
    return sex;
  }

  public List<Cat> getCatList() {
    return catList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return age == person.age
      && Objects.equals(name, person.name)
      && sex == person.sex
      && Objects.equals(catList, person.catList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age, sex, catList);
  }

  @Override
  public String toString() {
    return "Person{"
      + "name='" + name + '\''
      + ", age=" + age
      + ", sex=" + sex
      + ", catList=" + catList
      + '}';
  }

  public enum Sex {
    MAN, WOMAN
  }
}
