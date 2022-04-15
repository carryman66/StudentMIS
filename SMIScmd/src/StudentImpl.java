import java.util.Scanner;

/**
 * @author Foo
 * @version 1.0
 */
public class StudentImpl implements StudentDao {
    static final Scanner scanner = new Scanner(System.in);
    static String userInput;

    static Student[] students = new Student[10];

    @Override
    public void mainUI() {
        while (true) {
            System.out.println("****************学生管理系统****************");
            System.out.println("1.添加学生信息");
            System.out.println("2.删除学生信息");
            System.out.println("3.修改学生信息");
            System.out.println("4.查询学生信息");
            System.out.println("5.退出学生信息");
            System.out.print("输入您的选择：");
            userInput = scanner.next();
            if ("1".equals(userInput)) {
                add();
            } else if ("2".equals(userInput)) {
                delete();
            } else if ("3".equals(userInput)) {
                update();
            } else if ("4".equals(userInput)) {
                select();
            } else if ("5".equals(userInput)) {
                System.out.println("退出系统...");
                break;
            }
        }

    }

    @Override
    public void add() {
        System.out.println("****************添加学生信息****************");
        System.out.println("输入学生ID：");
        int id = scanner.nextInt();
        System.out.println("输入学生姓名：");
        String name = scanner.next();
        System.out.println("输入学生年龄：");
        int age = scanner.nextInt();
        System.out.println("输入学生性别：");
        String gender = scanner.next();
        Student student = new Student(id, name, age, gender);
        if (!isOne(student.getId())) {
            boolean add = add(student);
            if (add) {
                System.out.println("添加成功！");
            } else {
                System.out.println("添加失败！");
            }
        } else {
            System.out.println("id已经存在了，请重新输入！");
        }

    }

    @Override
    public void select() {
        if (existStudent()) {
            while (true) {
                System.out.println("****************查询学生信息****************");
                System.out.println("1.查询所有学生信息");
                System.out.println("2.根据年龄查询学生信息");
                System.out.println("3.取消查询");
                userInput = scanner.next();
                if ("1".equals(userInput)) {
                    selectAll();
                } else if ("2".equals(userInput)) {
                    System.out.println("输入查询的起始年龄：");
                    int startAge = scanner.nextInt();
                    System.out.println("输入查询的结束年龄：");
                    int endAge = scanner.nextInt();
                    if (startAge > 1 && startAge < 100) {
                        selectByAge(startAge, endAge);
                    } else {
                        System.out.println("您输入的年龄有误！");
                    }
                } else if ("3".equals(userInput)) {
                    System.out.println("取消了查询");
                    break;
                } else {
                    System.out.println("请输入1-3！");
                }
            }
        } else {
            System.out.println("请添加后查询！");
        }
    }

    @Override
    public void delete() {
        if (existStudent()) {
            System.out.println("****************删除学生信息****************");
            System.out.println("请输入您要删除的学生信息的学生ID：");
            int id = scanner.nextInt();
            Student student = selectOne(id);
            if (student == null) {
                System.out.println("您要删除的学生不存在！");
            } else {
                student.showStudent();
                System.out.println("您确定要删除吗？y/n");
                String next = scanner.next();
                if (next.equals("y")) {
                    boolean delete = delete(id);
                    if (delete) {
                        System.out.println("删除成功！");
                    } else {
                        System.out.println("删除失败！");
                    }
                } else {
                    System.out.println("取消删除");
                }
            }
        } else {
            System.out.println("请添加后删除！");
        }
    }

    @Override
    public void update() {
        if (existStudent()) {
            System.out.println("****************修改学生信息****************");
            System.out.println("请输入您要修改的学生信息的学生ID：");
            int id = scanner.nextInt();
            Student student = selectOne(id);
            if (student == null) {
                System.out.println("您要修改的学生不存在！");
            } else {
                student.showStudent();
                System.out.println("您确定要修改吗？y/n");
                String next = scanner.next();
                if (next.equals("y")) {
                    System.out.println("输入修改后的姓名：");
                    String name = scanner.next();
                    System.out.println("输入修改后的年龄：");
                    int age = scanner.nextInt();
                    System.out.println("输入修改后的性别：");
                    String gender = scanner.next();
                    student.setName(name);
                    student.setAge(age);
                    student.setGender(gender);
                    System.out.println("修改成功！");
                } else {
                    System.out.println("取消修改学生信息");
                }
            }
        } else {
            System.out.println("请添加后修改！");
        }
    }

    @Override
    public void selectAll() {
        for (Student student : students) {
            if (student != null) {
                student.showStudent();
            }
        }
    }

    @Override
    public void selectByAge(int start, int end) {
        for (Student student : students) {
            if (student != null) {

                if (student.getAge() >= start && student.getAge() < end) {
                    student.showStudent();
                }
            }
        }

    }

    @Override
    public boolean existStudent() {
        boolean f = false;
        for (Student student : students) {
            if (student != null) {
                f = true;
                break;
            }
        }
        return f;
    }


    @Override
    public boolean isOne(int id) {
        for (Student student : students) {
            if (student != null) {
                if (student.getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean add(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                return true;
            }
        }
        System.out.println("管理系统人数到达上线，需要扩容！！！！！");
        return false;
    }

    @Override
    public boolean delete(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (students[i].getId() == id) {
                    students[i] = null;
                    return true;
                }
            }
        }

        return false;
    }


    @Override
    public Student selectOne(int id) {
        for (Student student : students) {
            if (student != null) {
                if (student.getId() == id) {
                    return student;
                }
            }
        }
        return null;
    }
}
