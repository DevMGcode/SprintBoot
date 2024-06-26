package com.melissa.csb.webapp.springbootweb.controllers;
import org.springframework.web.bind.annotation.RestController;
import com.melissa.csb.webapp.springbootweb.dto.ParamDto;
import com.melissa.csb.webapp.springbootweb.models.User;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/var")
public class PathVariableController {

  //escritas en application.properties

  @Value("${config.username}")
  private String username;

/*   @Value("${config.message}")
      private String message; 
*/
  //inyectar configuraciones
  @Value("${config.listOfValues}")
  private List<String> listOfValues;//automatica
  //private String [] listOfValues;
  
  @Value("${config.code}")
  private String code;
  
  @Value("#{'${config.listOfValues}'.toUpperCase().split(',')}")//string en arreglo-manual
  private List<String> valueList;
  
  @Value("#{'${config.listOfValues}'.toUpperCase()}")//string en arreglo-manual
  private String valueString;

  @Value("#{${config.valuesMap}}")
  private Map <String, Object> valuesMap;

  @Value("#{${config.valuesMap}.product}")
  private String product;

  @Value("#{${config.valuesMap}.price}")
  private Long price;

  @Autowired //por su tipo de dato lo inyecta
  private Environment environment;

  @GetMapping("/baz/{message}")
  public ParamDto baz(@PathVariable String message) {
    ParamDto param = new ParamDto();
    param.setMessage(message);
    return param;
    // http://localhost:8090/api/var/baz/mesa
    // más estandar el parametro en la ruta
  }

  @GetMapping("/mix/{product}/{id}")
  public Map<String, Object> mixPathVariable(@PathVariable String product, @PathVariable Long id) {
    Map<String, Object> json = new HashMap<>();
    json.put("product", product);
    json.put("id", id );

    return json;
    //http://localhost:8090/api/var/mix/mouse/25
  }

  @PostMapping("/create")
  public User create(@RequestBody User user){
    //Realizar con el usuario y guardar en la bd
    user.setName(user.getName().toUpperCase());
    return user;
  } 

/*  
  VALIDACION EN POSTMAN SOBRE EL POST -body-raw-json
  localhost:8090/api/var/create
  {
    "name": "Meli",
    "lastname": "Garcia",
    "email": "mg12dolce@gmail.com"
  } 
  
*/
@GetMapping("/values")
public  Map <String, Object> values(@Value("${config.message}") String message){
    Long code2= environment.getProperty("config.code",Long.class);
    Map <String, Object> json = new HashMap<>();
    json.put("username", username);
    json.put("code", code);
    json.put("code2", code2);
    //json.put("code2", Integer.valueOf(environment.getProperty("config.code")));
    json.put("message", message);
    json.put("message2", environment.getProperty("config.message"));
    json.put("listOfValues", listOfValues);
    json.put("valueList", valueList);
    json.put("valueString", valueString);
    json.put("valuesMap", valuesMap);
    json.put("product", product);
    json.put("price", price);
    return json;
    //localhost:8090/api/var/values
  }
  
}
