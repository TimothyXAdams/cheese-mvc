package org.launchcode.models.data;

import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Timothy on 9/16/2017.
 */

@Repository
@Transactional
public interface CategoryDao extends CrudRepository<Category, Integer> {
}