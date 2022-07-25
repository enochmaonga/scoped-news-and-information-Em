package Dao;


import Dao.Connection;
import models.Departments;
import models.News;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.Sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Sql2oDepartmentsDao implements DepartmentsDao {
    private final Sql2o sql2o;


    public Sql2oDepartmentsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
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