package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.CityService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.core.utilities.results.SuccessResult;
import com.gorkem.hrms.dataAccess.abstracts.CityDao;
import com.gorkem.hrms.entities.concretes.City;
import org.springframework.stereotype.Service;

@Service
public class CityManager implements CityService {

    private final CityDao cityDao;

    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public Result add(City city) {
        this.cityDao.save(city);
        return new SuccessResult(Messages.successfullyAdded);
    }

    @Override
    public City findByCityName(String city) {
        return this.cityDao.findByCityName(city);
    }
}
