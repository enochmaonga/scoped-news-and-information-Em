package Dao;

import Models.Departments;
import Models.Users;

import java.util.List;

public class Sql2oDepartmentsDao {
    package dao;
    import models.Departments;
	import models.News;
	import models.Users;
	import java.util.List;

    public interface DepartmentsDao {


        //create a department
        void add(Departments department);
        void addUserToDepartment(Users user, Departments department);
        //read


        List<Departments> getAll();

        Departments findById(int id);

        List<Users> getAllUsersInDepartment(int department_id);

        List<models.News> getDepartmentNews(int id);
        //update news from the departments

        //delete
        void clearAll();


    }

}
