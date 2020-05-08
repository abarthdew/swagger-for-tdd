package my.project.swaggertest.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import my.project.swaggertest.dto.CoffeeDTO;
import my.project.swaggertest.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
// TODO 4
@RequestMapping("/api")
public class BanapressoController {

    private final String EXTERNAL_URI_PREFIX = "/beverage";

    @Autowired
    private CoffeeService service;

    @ApiOperation(value = "음료 목록 불러오기", notes = "음료 목록을 불러옵니다")
    @GetMapping(value = EXTERNAL_URI_PREFIX)
    public ResponseEntity<Map<String,Object>> selectCoffee(){
        Map<String, Object> map = new HashMap<>();
        List<CoffeeDTO> coffee = service.selectCoffee();
        for(CoffeeDTO cof : coffee){
            map.put(cof.getId(), cof.getName());
        }
        return ResponseEntity.ok(map);
    }

    // TODO 5
    // TODO 6
    // TODO 7
    @GetMapping(value = EXTERNAL_URI_PREFIX + "/{id}")
    public ResponseEntity selectCoffeeOne(@PathVariable("id") String id){
        return ResponseEntity.ok(service.selectCoffeeOne(id));
    }

    @ApiOperation(value = "음료 등록하기", notes = "음료를 등록합니다")
    @PostMapping(value = EXTERNAL_URI_PREFIX + "/setCoffee")
    public ResponseEntity insertCoffee(
            @ApiParam(value = "음료 등록에 필요한 파라미터\n" +
                ", language : kor" , required = true)
            @RequestBody CoffeeDTO dto){
        return ResponseEntity.ok(service.insertCoffee(dto));
    }

}
