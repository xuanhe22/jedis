package com.game.redis.server;

import com.game.redis.obj.User;
import com.game.redis.util.ConnectUtil;
import com.game.redis.util.GlobalUtil;

public class TestServer {

	public static void main( String[] args )  
    {
		GlobalUtil.init();
		User user = new User(100001, "中国O(∩_∩)O哈哈~■D\\/(#‵′)凸╭∩╮（︶︿︶）╭∩╮鄙视你！とてちΟΞξοξчШъЫ┏┳┓┫■⊹⊰⋚⋌⋛⊱㊣㈱№※♀卍卐♂№▤▧░");
		ConnectUtil.setData(user);
		user = new User(100001, "什么鬼？？？？？？");
		ConnectUtil.setData(user);
		User tmp = ConnectUtil.getData(User.class, 100002);
		 System.out.println("id== "+tmp.getId()+"; name== "+tmp.getName());
    }
}
