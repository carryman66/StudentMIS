/**
 * @author Foo
 * @version 1.0
 */
public class Student {
    private int id;
    private String name;
    private int age;
    private String gender;

    /**
     * 打印学生个人信息
     */
    public void showStudent() {
        System.out.println("学生编号：" + id + "  学生姓名：" + name + "  学生年龄：" + age + "  学生性别：" + gender);
    }

    public Student() {
    }

    public Student(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
