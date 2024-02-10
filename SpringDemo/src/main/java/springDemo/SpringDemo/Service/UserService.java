package springDemo.SpringDemo.Service;

import springDemo.SpringDemo.Model.User;
import springDemo.SpringDemo.Repository.UserRepository;

import java.util.HashMap;

/*
 1 .Logic implement
 */
public class UserService {

    UserRepository userRepository = new UserRepository();

    HashMap<Integer , User> db = userRepository.database;

    public  String add(User user) {

         // logic


        // user database add
        int key = user.getId();
        User user1 =  user;

        db.put(key , user1);

        return "user added successfully";
    }

    public User getUser(Integer key) throws Exception{

        if(db.containsKey(key) == true){
            return db.get(key);
        }

        throw  new Exception("user with " + key + " is not exist");

    }

    public User deleteUser(Integer id) throws Exception{

        if(db.containsKey(id)){

            User user = db.remove(id);

            return  user;
        }

        throw new Exception("user not found");
    }
}
