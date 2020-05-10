package edu.nick.cursach.dao.Kilometrage.impls;

import edu.nick.cursach.dao.Kilometrage.interfaces.IKilometrageDao;
import edu.nick.cursach.dataSet.DataSet;
import edu.nick.cursach.model.FreightTransport;
import edu.nick.cursach.model.Kilometrage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KilometrageDaoImplFake implements IKilometrageDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Kilometrage save(Kilometrage kilometrage) {
        return null;
    }

    @Override
    public Kilometrage get(String id) {
        return null;
    }

    @Override
    public List<Kilometrage> getAll() {
        return dataSet.getKilometrages();
    }

    @Override
    public FreightTransport edit(Kilometrage kilometrage) {
        return null;
    }

    @Override
    public FreightTransport delete(String id) {
        return null;
    }
}
