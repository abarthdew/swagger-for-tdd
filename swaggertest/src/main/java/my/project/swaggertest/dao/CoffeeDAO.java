package my.project.swaggertest.dao;

import my.project.swaggertest.dto.CoffeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CoffeeDAO {

  @Autowired
  private JdbcTemplate template;

  public List<CoffeeDTO> selectCoffee() {
    String sql = "select * from coffee";
    return template.query(sql, new RowMapper<CoffeeDTO>() {
      @Override
      public CoffeeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        CoffeeDTO dto = new CoffeeDTO();
        dto.setId(rs.getString("id"));
        dto.setName(rs.getString("name"));
        dto.setPrice(rs.getInt("price"));
        return dto;
      }
    });
  }

  public CoffeeDTO selectCoffeeOne(String id) {
    String sql = "select * from coffee where id = ?";
    return template.queryForObject(sql, new Object[]{id}, (rs, rn) -> {
      CoffeeDTO dto = new CoffeeDTO();
      dto.setId(rs.getString("id"));
      dto.setName(rs.getString("name"));
      dto.setPrice(rs.getInt("price"));
      System.out.println(dto.getId());
      return dto;
    });
  }

  public int insertCoffee(CoffeeDTO dto) {
    String sql = "insert into coffee values (coffee_id_Seq.nextval, ?, ?)";
//        dto.setId("0000");
//        dto.setName("coffee");
//        dto.setPrice(3000);
    return template.update(sql, dto.getName(), dto.getPrice());
  }

}
