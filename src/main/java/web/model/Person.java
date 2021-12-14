package web.model;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="firstname")
    private String name;

    @Column(name="age")
    private byte age;

    @Column(name="email")
    private String email;


    public Person() {}
    public Person(long id, String name, byte age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public byte getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public long getId(){return id;}

    public void setAge(byte age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String toString(){return name + " " + age + " " + email + " id = " + id;}
}
