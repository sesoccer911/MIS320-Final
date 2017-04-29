/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author sgreen
 */
public class FilmHelper {

    Session session = null;

    public FilmHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

//method to retrive the films where the film id is between a certain range specified by the variables startID and endID
    public List getFilmTitles(int startID, int endID) {
        List<Film> filmList = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Film as film where film.filmId between '" + startID + "' and '" + endID + "'");
            filmList = (List<Film>) q.list();
            tx.commit();
            tx = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filmList;
    }
        public List getFilmTitlesByCat(int catID) {
        List<Film> filmList = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("select film from FilmCategory as cat inner join cat.film film where cat.id.categoryId =" + catID);
            filmList = (List<Film>) q.list();
            tx.commit();
            tx = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filmList;
    }
        public List getFirstTenByCat(int catID){
            List<Film> filmList = getFilmTitlesByCat(catID);
            List<Film> tenFilms = new ArrayList<Film>();
            for(int i = 0; i < filmList.size () && i < 10; i++){
                tenFilms.add(filmList.get(i));
            }
            return tenFilms;
        }
        
//method that retrieves the actors in a particular film. The method constructs the query using filmId as the input variable

    public List getActorsByID(int filmId) {
        List<Actor> actorList = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Actor as actor where actor.actorId in (select filmActor.actor.actorId from FilmActor as filmActor where filmActor.film.filmId='" + filmId + "')");
            actorList = (List<Actor>) q.list();
            tx.commit();
            tx = null;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return actorList;
    }
//method to retrieve a list of categories according to filmId.

    public Category getCategoryByID(int filmId) {
        List<Category> categoryList = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Category as category where category.categoryId in (select filmCat.category.categoryId from FilmCategory as filmCat where filmCat.film.filmId='" + filmId + "')");
            categoryList = (List<Category>) q.list();
            tx.commit();
            tx = null;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return categoryList.get(0);
    }
//Add the following method to retrieve a single film according to filmId

    public Film getFilmByID(int filmId) {

        Film film = null;

        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Film as film where film.filmId=" + filmId);
            film = (Film) q.uniqueResult();
            tx.commit();
            tx = null;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return film;
    }
//method to retrieve the film language according to langId.    

    public String getLangByID(int langId) {

        Language language = null;

        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Language as lang where lang.languageId=" + langId);
            language = (Language) q.uniqueResult();
            tx.commit();
            tx = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return language.getName();
    }
}
