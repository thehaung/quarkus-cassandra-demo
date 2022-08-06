package vn.thehaung.service;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import com.datastax.oss.driver.api.querybuilder.select.SelectFrom;
import vn.thehaung.dao.FruitDao;
import vn.thehaung.model.Fruit;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.bindMarker;
import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.selectFrom;

/**
 * @author : Hau Nguyen
 * @from : 8/6/22
 **/
@ApplicationScoped
public class FruitService {

    private final CqlSession session;
    @Inject
    FruitDao fruitDao;

    public FruitService(CqlSession session) {
        this.session = session;
    }

    public void save(Fruit fruit) {
        fruitDao.update(fruit);
    }

    public List<Fruit> getAll() {
        return fruitDao.findAll().all();
    }

    public Fruit findOne(String name) {

        PreparedStatement preparedSelectUser = session.prepare("SELECT * FROM fruit WHERE name = ?");

        // At runtime:
        Row row = session.execute(preparedSelectUser.bind(name)).one();

        if (null == row) {
            return null;
        }

        return new Fruit(row.getString("name"), row.getString("description"));
    }
}