package ss12_dsa_stack_quece.exec.demerging_uses_queue;

import java.util.*;

public class DemergingQueue {
    private static Queue<Person> personQueueNu = new PriorityQueue<>();
    private static Queue<Person> personQueueNam = new PriorityQueue<>();
    public static void main(String[] args) {
        Person person1= new Person("Vi","Female",1,1,1995);
        Person person2= new Person("Ngọc","Female",12,1,2000);
        Person person3= new Person("Hải","Male",10,10,1997);
        Person person4= new Person("Dụng","Male",7,8,1993);
        reorganizePerson(person1);
        reorganizePerson(person2);
        reorganizePerson(person3);
        reorganizePerson(person4);
        if (!personQueueNu.isEmpty()){
            for (Person person: personQueueNu){
                System.out.println(person.toString());
            }
        }
        if (!personQueueNam.isEmpty()){
            for (Person person: personQueueNam){
                System.out.println(person.toString());
            }
        }
    }
    private static void reorganizePerson(Person person){
        if (Objects.equals(person.getGender(), "Male")){
            personQueueNam.add(person);
        } else if (Objects.equals(person.getGender(), "Female")){
            personQueueNu.add(person);
        }
    }
}
