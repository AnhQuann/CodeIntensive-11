import java.util.Date;

public class Student {
    String name;
    Date birthdate;
    String code;

    public Student() {
        this.name = "Nguyen Van A";
        this.birthdate = new Date();
        this.code = "se121212";
    }

    public void print() {
        System.out.println(this.name);
        System.out.println(this.birthdate);
        System.out.println(this.code);
    }
}

