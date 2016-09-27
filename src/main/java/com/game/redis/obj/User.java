package com.game.redis.obj;

import org.springframework.stereotype.Component;


@Component
public class User extends BasePo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3206056132054242745L;
	public static final String OBJECT_KEY = "USER";  
	  
    public User() {  
    }  
  
    public User(long id) {  
    }  
  
    public User(long id, String name) {  
        this.id = id;  
        this.name = name;  
    }  
  
    private long id;  
  
    private String name;  
  
    public long getId() {  
        return id;  
    }  
  
    public void setId(long id) {  
        this.id = id;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public String toString() {  
        return "User [id=" + id + ", name=" + name + "]";  
    }  
  
    public String getKey() {  
        return OBJECT_KEY+".id.";  
    }  
    
    @Override
    public String getObjectKey() {  
        return getKey()+getId();  
    }
}
