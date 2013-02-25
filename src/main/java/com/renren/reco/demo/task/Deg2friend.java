package com.renren.reco.demo.task;

import java.util.*;
import java.io.*;

public class Deg2friend {
	
	private  HashMap<String,Node> alluser = new HashMap<String,Node>();
	
    public HashMap<String, Node> getAlluser() {
		return alluser;
	}

	public void setAlluser(HashMap<String, Node> alluser) {
		this.alluser = alluser;
	}

	public static class Node {
        private String name;
        private HashMap  friend ;
        
        public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
        public HashMap getFriend() {
			return friend;
		}

		public void setFriend(HashMap friend) {
			this.friend = friend;
		}

		public Node(String name) {
            this.name = name;
            friend = new HashMap<String,Double>();
        }

        public String toString() {
            return name;
        }
        //一度好友的值始终为0
        public void addFirstFriend(Node temp){
        	if(!this.equals(temp))
        		friend.put(temp.toString(), 0);
        }
        //二度好友的值是共同好友的度量
        public void addSecondFriend(Node temp){
        	
        	if(friend.keySet().contains(temp.toString())){
            	Double name_t = (Double)friend.get(temp.toString());
            	if(!this.isFirst(temp)){
            		friend.put(temp.toString(),name_t.longValue()+1);
            	}
        	}
        	else{
        		friend.put(temp.toString(),1);
        	}

        }
        //输出所有好友
        public String allFriend() {
        	 Set<Map.Entry<String, Double>> set = friend.entrySet();
             for (Iterator<Map.Entry<String, Double>> it = set.iterator(); it.hasNext();) {
                 Map.Entry<String, Double> entry =  (Map.Entry<String, Double>)it.next();
                 System.out.println(entry.getKey() + "--->" + entry.getValue());
             }
            return name;
        }
        //判断是否为一度好友
        public boolean isFirst(Node temp){

        	if(friend.keySet().contains(temp.toString())){
        		Double name_t =(Double)(friend.get(temp.toString()));
        		if(name_t.longValue()<0.01)
        			return true;
        	}
        	return false;	
        }
         
    }
	
    
	//计算所有的二度好友
	public  void pushFriend(){
        Set<String> key = alluser.keySet();
        for (Iterator it = key.iterator(); it.hasNext();) {
            String sFirst = (String) it.next();
            Node me  = (Node)alluser.get(sFirst);
            Set<String> key2 = me.friend.keySet();
           
            for (Iterator it2 = key2.iterator(); it2.hasNext();) {
                String sSecond = (String) it2.next();
                Node hisfirst  = (Node)alluser.get(sSecond);
                for(Iterator it3 = it2;it3.hasNext(); ){
                	String sThird = (String)it3.next();
                	Node hisSecond  = (Node)alluser.get(sThird);
                	if(me.isFirst(hisSecond)&&me.isFirst(hisSecond)){
                		hisfirst.addSecondFriend(hisSecond);
                		hisSecond.addSecondFriend(hisfirst);
                		System.out.println(hisfirst+"+"+hisSecond+"@"+me);
                	}
                }
            }  
        }
		
    }
	
	
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Deg2friend we =  new Deg2friend();
		
		File file=new File("./resource/nodelist1");
		//取得当前路径
		if(!file.exists()||file.isDirectory())
		throw new FileNotFoundException();
		BufferedReader br=new BufferedReader(new FileReader(file));
		String temp=null;
		try {
			temp=br.readLine();
		} catch (IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(temp!=null){
			we.getAlluser().put((String)temp, new Node((String)temp));
		
		try {
			temp=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
//        alluser.put("A", new Node("A"));
//        alluser.put("B", new Node("B"));
//        alluser.put("C", new Node("C"));
//        alluser.put("D", new Node("D"));
		
		File filerelation=new File("./resource/relationlist1");
		//取得当前路径
		if(!file.exists()||file.isDirectory())
		throw new FileNotFoundException();
		BufferedReader br2=new BufferedReader(new FileReader(filerelation));
		temp=null;
		try {
			temp=br2.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(temp!=null){
		String[]  relation= temp.split(",");
		
	//	System.out.println(relation[0]+"||||"+relation[1]);
		if(we.getAlluser().containsKey(relation[0])&&we.getAlluser().containsKey(relation[1])){
			(we.getAlluser().get(relation[0].toString())).addFirstFriend(we.getAlluser().get(relation[1]));
			(we.getAlluser().get(relation[1].toString())).addFirstFriend(we.getAlluser().get(relation[0]));
		}
		try {
			temp=br2.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		



        Set<String> key = we.getAlluser().keySet();
        for (Iterator it = key.iterator(); it.hasNext();) {
            String s = (String) it.next();
            System.out.println(we.getAlluser().get(s));
            ((Node)we.getAlluser().get(s)).allFriend();
            
        }
        we.pushFriend();
        
        key = we.getAlluser().keySet();
        for (Iterator it = key.iterator(); it.hasNext();) {
            String s = (String) it.next();
            System.out.println(we.getAlluser().get(s));
            ((Node)we.getAlluser().get(s)).allFriend();
            System.out.println("__________");
            
        }
	}

	
	
}
