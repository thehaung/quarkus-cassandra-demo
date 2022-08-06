package vn.thehaung.model.mapper;

import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.Mapper;
import vn.thehaung.dao.FruitDao;

/**
 * @author : Hau Nguyen
 * @from : 8/6/22
 **/

@Mapper
public interface FruitMapper {
    @DaoFactory
    FruitDao fruitDao();
}
