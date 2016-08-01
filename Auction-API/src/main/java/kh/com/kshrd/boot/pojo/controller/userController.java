
package kh.com.kshrd.boot.pojo.controller;


import java.util.ArrayList;
import kh.com.kshrd.boot.pojo.entity.User;
import kh.com.kshrd.boot.pojo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KUYLIM
 */
@RestController
@RequestMapping(value = "/api/user")
public class userController {
    
    @Autowired
    private userService usrService;
    
    @RequestMapping(value="/get", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ArrayList<User> getUsers(){
	ArrayList<User> user = usrService.getUsers();
	return user;
    }
    
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public void delete(@PathVariable("id") int id)
    {
        usrService.remove(id);      
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public void add(@RequestBody User usr)
    {  
        usrService.save(usr);
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, produces = "application/json")
    public void edit(@RequestBody User stu)
    {
        usrService.update(stu);    
    }
    
    @RequestMapping(value="/search/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User search(@PathVariable("id") int id){
	User user = usrService.search(id);
	return user;
    }
}
