/**
 * @author Foo
 * @version 1.0
 */
public interface StudentDao {
    /**
     * 打印全部的界面和进行逻辑操作
     */
    void mainUI();

    /**
     * 添加学生信息逻辑
     */
    void add();

    /**
     * 查询学习信息逻辑
     */
    void select();


    /**
     * 删除学生信息逻辑
     */

    void delete();

    /**
     * 修改学习信息逻辑
     */
    void update();


    /**
     * 判断系统中是否存在学生信息
     * @return true存在，false不存在
     */
    boolean existStudent();


    /**
     * 根据id查询学生
     *
     *
     * @param id 查询的学生id
     * @return 学生对象，如果没有学生，返回null
     */
    Student selectOne(int id);


    /**
     * 判断指定id是否存在且唯一
     *
     * @param id 指定id
     * @return true 表示存在且唯一，false表示不唯一或不存在
     */
    boolean isOne(int id);


    /**
     * 添加一名学生信息
     *
     * @param student 添加的学生
     * @return ture表示添加成功，false表示添加失败
     */
    boolean add(Student student);

    /**
     * 根据id删除学生信息
     *
     * @param id 删除的学生id
     * @return true表示删除成功，false表示删除失败
     */
    boolean delete(int id);


    /**
     * 打印所有学生信息
     */
    void selectAll();

    /**
     * 根据年龄查询，打印所有符合年龄限制的学生信息
     *
     * @param start 查询的开始年龄
     * @param end   查询的结束年龄
     */
    void selectByAge(int start, int end);



}
