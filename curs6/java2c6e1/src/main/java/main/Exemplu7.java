package main;

import db.Bere;
import db.Bere_;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/*
    Criteria API - un set de API prin care se pot defini interogari in mod programatic
 */
public class Exemplu7 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c6PU");
        var em = emf.createEntityManager();

        // SELECT b FROM Bere b WHERE b.nume = 'Stejar'

        CriteriaBuilder cb = em.getCriteriaBuilder();
        // CriteriaBuilder - clasa care construieste clauzele interogarii: equal, greaterThan, notNull, ...

        CriteriaQuery<Bere> query = cb.createQuery(Bere.class);

        Root<Bere> b = query.from(Bere.class);

        // SELECT b FROM Bere b WHERE          b.nume = 'Stejar'
        query.select(b).        where(cb.equal(b.get(Bere_.nume), "Stejar"));

//        String nume = null;
//        Integer id = null;
//
//        Predicate whereClause = cb.conjunction(); // 1 = 1
//
//        if (nume != null) {
//            whereClause = cb.and(
//                    whereClause,
//                    cb.equal(b.get("nume"), nume)
//            );
//        }
//
//        if (id != null) {
//            whereClause = cb.and(
//                    whereClause,
//                    cb.equal(b.get("id"), nume)
//            );
//        }
//
//        query.where(whereClause); // WHERE 1 = 1

        TypedQuery<Bere> q = em.createQuery(query);

        List<Bere> beri = q.getResultList();

        beri.forEach(System.out::println);

        em.close();
        emf.close();
    }
}
