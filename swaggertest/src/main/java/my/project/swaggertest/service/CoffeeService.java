package my.project.swaggertest.service;
import my.project.swaggertest.dao.CoffeeDAO;
import my.project.swaggertest.dto.CoffeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {

    @Autowired
    private CoffeeDAO dao;

    public List<CoffeeDTO> selectCoffee(){
        return dao.selectCoffee();
    }

    public int insertCoffee(CoffeeDTO dto){
        return dao.insertCoffee(dto);
    }

    public CoffeeDTO selectCoffeeOne(String id) { return dao.selectCoffeeOne(id); }

}
