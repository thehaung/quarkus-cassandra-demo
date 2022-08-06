package vn.thehaung.service;

import vn.thehaung.dao.FruitDao;
import vn.thehaung.model.Fruit;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * @author : Hau Nguyen
 * @from : 8/6/22
 **/
@ApplicationScoped
@Named("FruitService")
public class FruitService {

    @Inject
    FruitDao fruitDao;

    public void save(Fruit fruit) {
        fruitDao.update(fruit);
    }

    public List<Fruit> getAll() {
        return fruitDao.findAll().all();
    }
}