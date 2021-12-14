package com.jian.pojo;


/**数据库实体类 可用注解起别名
 * @autHor jzj
 * @create 2021 12 11 14:48
 */
public class Admin {
    private int id;
    private String name;
   private  String password;

    public Admin() {
    }

    public Admin(int id, String name, String password) {
        this.id = id;
        this.name =name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaem() {
        return name;
    }

    public void setNaem(String naem) {
        this.name = naem;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", naem='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
