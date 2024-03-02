package springDemo.SpringDemo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springDemo.SpringDemo.Model.User;
import springDemo.SpringDemo.Service.UserService;


/*
  1. Endpoints
 */
@RestController
public class UserController {

    /*
    1 . Post Api ("/add/{name}"
    2.Input
    3. Input types
       - int
       - String
       - array input
       - sc.nextInt();
    4 .Input
       - @PathVariable("name") // single input
       - @RequestBody // container input (class input)
       - @RequestParam("name1") name1 , ("name2") name2) // multiple inputs
     */

    public UserService userService = new UserService();

    @PostMapping("/add")
    public  String add(@RequestBody User user){

        String res = userService.add(user);

        return res;
    }


    @GetMapping("/get/{key}")
    public ResponseEntity getUser(@PathVariable("key") Integer key) throws Exception{

        try {
           User user =  userService.getUser(key);
           return  new ResponseEntity(user , HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Integer id) throws Exception{

        try
        {
            return new ResponseEntity(userService.deleteUser(id),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
