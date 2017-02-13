import com.db4o.ObjectContainer;
import com.db4o.query.Query;
import com.sun.org.apache.xpath.internal.operations.And;
import com.sun.org.apache.xpath.internal.operations.Equals;

import java.lang.reflect.Field;

/**
 * Created by x3727349s on 09/02/17.
 */
public class Person {

    public Person(){ }

    public Person(String firstName, String lastName, int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String value) { firstName = value; }

    public String getLastName() { return lastName; }
    public void setLastName(String value) { lastName = value; }

    public int getAge() { return age; }
    public void setAge(int value) { age = value; }

    public String toString()
    {
        return
                "[Person: " +
                        "firstName = " + firstName + " " +
                        "lastName = " + lastName + " " +
                        "age = " + age +
                        "]";
    }

    public boolean equals(Object rhs)
    {
        if (rhs == this)
            return true;

        if (!(rhs instanceof Person))
            return false;

        Person other = (Person)rhs;
        return (this.firstName.equals(other.firstName) &&
                this.lastName.equals(other.lastName) &&
                this.age == other.age);
    }

    private String firstName;
    private String lastName;
    private int age;

}
