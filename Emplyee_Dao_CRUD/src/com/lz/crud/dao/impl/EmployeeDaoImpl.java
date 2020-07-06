package com.lz.crud.dao.impl;

import com.lz.crud.dao.IEmployeeDao;
import com.lz.crud.domain.Employee;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName EmployeeDaoImpl 接口实现
 * @Description: 员工CRUD
 * @Author: zzz
 **/
public class EmployeeDaoImpl implements IEmployeeDao {
    private final String url = "jdbc:mysql://localhost:3306/lz?characterEncoding=utf-8";
    private final String name = "root";
    private final String pwd = "123456";
    private int i = 0;
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private final List<Employee> employeeList = new ArrayList<>();

    @Override
    public String insert(Employee employee) {
//        int update = 0;
//        Connection conn = null;
//        PreparedStatement pst = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection(url, name, pwd);
            String sql = "insert into employee(name,age,sex,salary) values(?,?,?,?)";
            //预编译语句
            pst = conn.prepareStatement(sql);
            pst.setString(1, employee.getName());
            pst.setInt(2, employee.getAge());
            pst.setString(3, employee.getSex());
            pst.setBigDecimal(4, employee.getSalary());
            //执行语句
            i = pst.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //释放流资源
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return i > 0 ? "插入数据成功" : "插入数据失败";
    }

    @Override
    public String delete(Long id) {
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接对象
            conn = DriverManager.getConnection(url, name, pwd);
            String sql = "delete from employee where id= ?";
            //预编译语句
            pst = conn.prepareStatement(sql);
            //为？设值
            pst.setLong(1, id);
            //执行语句
            i = pst.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            //释放流资源
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return i > 0 ? "删除数据成功" : "删除数据失败";
    }

    @Override
    public String update(Employee employee) {

        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection(url, name, pwd);
            //预编译语句
            String sql = "update employee set name=?,age=?,sex=?,salary=? where id=?";
            pst = conn.prepareStatement(sql);
            //设值
            pst.setString(1, employee.getName());
            pst.setInt(2, employee.getAge());
            pst.setString(3, employee.getSex());
            pst.setBigDecimal(4, employee.getSalary());
            pst.setLong(5, employee.getId());
            //执行语句
            i = pst.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //释放流资源
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return i > 0 ? "修改数据成功" : "修改数据失败";
    }

    @Override
    public Employee selectOne(Long id) {
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection(url, name, pwd);
            //预编译语句
            String sql = "select * from employee where id=?";
            pst = conn.prepareStatement(sql);
            //设值
            pst.setLong(1, id);
            //执行语句
            rs = pst.executeQuery();
            if (rs.next()) {
                long rid = rs.getLong("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String sex = rs.getString("sex");
                BigDecimal salary = rs.getBigDecimal("salary");
                return new Employee(rid, name, age, sex, salary);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            //释放流资源
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public List<Employee> selectList() {
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection(url, name, pwd);
            //预编译语句
            String sql = "select * from employee";
            pst = conn.prepareStatement(sql);
            //执行语句
            rs = pst.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String sex = rs.getString("sex");
                BigDecimal salary = rs.getBigDecimal("salary");
                employeeList.add((new Employee(id, name, age, sex, salary)));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            //释放流资源
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return employeeList;
    }
}
