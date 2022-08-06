package vn.thehaung.dao;

import com.datastax.oss.driver.api.core.PagingIterable;
import com.datastax.oss.driver.api.mapper.annotations.Dao;
import com.datastax.oss.driver.api.mapper.annotations.Select;
import com.datastax.oss.driver.api.mapper.annotations.Update;
import vn.thehaung.model.Fruit;

/**
 * @author : Hau Nguyen
 * @from : 8/6/22
 **/

@Dao
public interface FruitDao {

    @Update
    void update(Fruit fruit);

    @Select
    PagingIterable<Fruit> findAll();

    @Select
    Fruit findOne(String name);
}
