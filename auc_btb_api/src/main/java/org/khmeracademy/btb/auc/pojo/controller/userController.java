
package org.khmeracademy.btb.auc.pojo.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.khmeracademy.btb.auc.pojo.entity.User;
import org.khmeracademy.btb.auc.pojo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//    public ArrayList<User> getUsers(){
//	ArrayList<User> user = usrService.getUsers();
//	return user;
//    }
    public ResponseEntity<Map<String, Object>> getUsers()
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            ArrayList<User> users = usrService.getUsers();
            if(!users.isEmpty())
            {
                map.put("DATA", users);
                map.put("STATUS", true);
                map.put("MESSAGE", "DATA FOUND!");
            }
            else
            {
                map.put("STATUS", true);
                map.put("MESSAGE", "DATA NOT FOUND");
            }
        }
        catch (Exception e)
        {
            map.put("STATUS", false);
            map.put("MESSAGE", "Error!");
            e.printStackTrace();
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
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
