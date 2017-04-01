/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bikeweb.helper;

import com.bikeweb.entity.Bike;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Lam Nguyen
 */
public class BikeHelper extends GenericHelper<Bike, Integer> {

    public List<Bike> getBikeByCategoryId(int categoryId) {
        List<Bike> bikes = null;
        try {
            org.hibernate.Transaction tx = getSession().beginTransaction();
            Criteria q = creatteEntityCriteia();
            q.add(Restrictions.eq("category.categoryId", categoryId));
            bikes = (List<Bike>) q.list();
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bikes;
    }

}
