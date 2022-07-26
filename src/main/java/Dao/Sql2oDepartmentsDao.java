package Dao;


import models.Departments;
import org.Sql2o.Sql2oException;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


public class Sql2oDepartmentsDao implements Sql2oDepartmentsDao.DepartmentsDao {
    private final Sql2o sql2o;


    public Sql2oDepartmentsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public Sql2oDepartmentsDao() {
        super();
    }


    @Override
    public void add(Departments department) {
        try (Connection con = sql2o.open()) {
            String sql = "INSERT INTO departments (name,description,size) VALUES (:name,:description,:size)";
            int id = (int) con.createQuery(sql, true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setId(id);


        } catch (Sql2oException e) {
            System.out.println(e);
        }
    }
}