package my.project.swaggertest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(tags = {"02. Price"}, description = "가격 관리")
@RequestMapping("/api")
public class PriceController {

    private final String EXTERNAL_URI_PREFIX = "/price";
    private final String TEST = "test";

    @Autowired
    private CoffeeService service;

    @ApiOperation(value = "가격 불러오기", notes = "음료 가격을 불러옵니다")
    @GetMapping(value = EXTERNAL_URI_PREFIX)
    public ResponseEntity<Map<String,Object>> selectPrice(){
        Map<String, Object> map = new HashMap<>();
        List<CoffeeDTO> coffee = service.selectCoffee();
        for(CoffeeDTO cof : coffee){
            map.put(cof.getName(), cof.getPrice());
        }
        return ResponseEntity.ok(map);
    }

    @ApiOperation(value = "가격 등록하기", notes = "음료 가격을 등록합니다")
    @PostMapping(value = EXTERNAL_URI_PREFIX + "/insertPrice")
    public ResponseEntity insertPrice(
            @ApiParam(value = "가격 등록에 필요한 파라미터\n" +
                ", language : kor" , required = true)
            @RequestBody CoffeeDTO dto){
        return ResponseEntity.ok(TEST);
    }

    @ApiOperation(value = "가격 수정하기", notes = "음료 가격을 수정합니다")
    @PutMapping(value = EXTERNAL_URI_PREFIX + "/updatePriceAll" + "/{id}")
    public ResponseEntity updatePriceAll(
            @ApiParam(value = "가격 수정에 필요한 파라미터\n" +
                    ", language : kor" , required = true)
            @PathVariable("id") String id,
            @RequestBody CoffeeDTO dto){
        return ResponseEntity.ok(TEST);
    }

    @ApiOperation(value = "가격 수정하기", notes = "음료 가격을 수정합니다")
    @PatchMapping(value = EXTERNAL_URI_PREFIX + "/updatePriceOne" + "/{id}")
    public ResponseEntity updatePriceOne(
            @ApiParam(value = "가격 수정에 필요한 파라미터\n" +
                    ", language : kor" , required = true)
            @PathVariable("id") String id,
            @RequestBody CoffeeDTO dto){
        return ResponseEntity.ok(TEST);
    }

    @ApiOperation(value = "가격 삭제하기", notes = "음료 가격을 삭제합니다")
    @DeleteMapping(value = EXTERNAL_URI_PREFIX + "/deletePrice" + "/{id}")
    public ResponseEntity deletePriceOne(
            @ApiParam(value = "가격 삭제에 필요한 파라미터\n" +
                    ", language : kor" , required = true)
            @PathVariable("id") String id){
        return ResponseEntity.ok(TEST);
    }
}
