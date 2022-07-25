package Dao;


import Models.Department_News;
import models.News;

import java.sql.Connection;
import java.util.List;


public class Sql2oNewsDao<Sql2o> implements NewsDao {
    private final Sql2o sql2o;


    public Sql2oNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void addNews(News news) {
        try (Connection con = sql2o.open()) {
            String sql = "INSERT INTO news (news_type,department_id,user_id,title,description) VALUES (:news_type," +
                    ":department_id,:user_id,:title,:description)";
            int id = (int) con.createQuery(sql, true)
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            news.setId(id);


        } catch (Sql2oException e) {
            System.out.println(e);
        }


    }


    @Override
    public void addDepartmentNews(Department_News department_news) {
        try (Connection con = sql2o.open()) {
            String sql = "INSERT INTO news (news_type,department_id,user_id,title,description) VALUES (:news_type," +
                    ":department_id,:user_id,:title,:description)";
            int id = (int) con.createQuery(sql, true)
                    .bind(department_news)
                    .executeUpdate()
                    .getKey();
            department_news.setId(id);


        } catch (Sql2oException e) {
            System.out.println(e);
        }


    }


    @Override
    public List<News> getAll() {
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM news";
            return con.createQuery(sql, true)
                    .executeAndFetch(News.class);


        }
    }
}



