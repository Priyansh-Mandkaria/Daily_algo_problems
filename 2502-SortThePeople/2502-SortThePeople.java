// Last updated: 7/10/2025, 8:52:57 AM
class Solution {
  public String[] sortPeople(String[] names, int[] heights) {
    Person[] people = new Person[names.length];
    for (int i = 0; i < names.length; i++) {
      people[i] = new Person(names[i], heights[i]);
    }
    Arrays.sort(people, (p1, p2) -> Integer.compare(p2.height, p1.height));
    String[] sortedNames = new String[names.length];
    for (int i = 0; i < people.length; i++) {
      sortedNames[i] = people[i].name; // Access the name property of the Person 
    }
    return sortedNames;
  }
  static class Person {
    String name;
    int height;
    Person(String name, int height) {
      this.name = name;
      this.height = height;
    }
  }
}
