/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package dvdrental;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author nb
 */
public class FilmHelper {

    Session session = null;

    public FilmHelper() {
        initialize();
    }

    public void initialize() {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (org.hibernate.HibernateException he) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
    }

    public List getFilmTitles(int startID, int endID) {
        List<Film> filmList = null;
        try {
            initialize();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Film as film where film.filmId between '" + startID + "' and '" + endID + "'");
            filmList = (List<Film>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filmList;
    }

    public List getActorsByID(int filmId) {
        List<Actor> actorList = null;
        try {
            initialize();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Actor as actor where actor.actorId in (select filmActor.actor.actorId from FilmActor as filmActor where filmActor.film.filmId='" + filmId + "')");
            actorList = (List<Actor>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return actorList;
    }
    public List getFilmTitlesByCat(int catID) {
        
        List<Film> filmList = null;
        try {
            initialize();
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

    public Category getCategoryByID(int filmId) {
        List<Category> categoryList = null;
        try {
            initialize();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Category as category where category.categoryId in (select filmCat.category.categoryId from FilmCategory as filmCat where filmCat.film.filmId='" + filmId + "')");
            categoryList = (List<Category>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return categoryList.get(0);
    }

    public Film getFilmByID(int filmId) {

        Film film = null;

        try {
            initialize();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Film as film where film.filmId=" + filmId);
            film = (Film) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return film;
    }

    public String getLangByID(int langId) {

        Language language = null;

        try {
            initialize();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Language as lang where lang.languageId=" + langId);
            language = (Language) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return language.getName();
    }
}
