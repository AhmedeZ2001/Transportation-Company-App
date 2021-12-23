/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se;

/**
 * @author Ahmed Abdelnaser
 * @author Omar Abdallah 20190771
 * @author Abdallah Mohamed 20190327
 * @author Nour Hosny 20190589
 */
public class client extends User implements Register, Login {

    public client(String userName, String pohne, String password) {
        super(userName, pohne, password);
     

    }
    public boolean hasRight(){
        for(int i=0 ; i< dataBase.getInstance().clients_List.size() ;i++){
            if(dataBase.getInstance().clients_List.get(i).getUserName().equals(this.userName))
                return true;
        }
        return false;
    }
    
    public void request (String src, String des)
    {
        if(this.hasRight()){
            ride r = new ride (src, des);
            dataBase.getInstance().clients_List.remove(this);
        }
        else
        {
            System.out.println("You're suspended or not registered");
        }
    }

    @Override
    public boolean Register() {
        for(int i=0 ; i<dataBase.getInstance().clients_List.size();i++){
            if(dataBase.getInstance().clients_List.get(i).userName.equals(this.userName) ){
                System.out.println("username is taken");
                return false ;
        }
        }
        dataBase.getInstance().clients_List.add(this);
        System.out.println("Client Registered Successfully");
        return true;
    }

    @Override
    public User login(String name, String pass) {
  
        if (Admin.getInstance().validateDetiles(name, pass))
             {
                 System.out.println("Client Login Successfully");
                 return this;
             }
        else
             return null;
  
    }
    
    public void giveRate(int r, driver d)
    {
        
        boolean x = true;
        for (int i =0; i < dataBase.getInstance().drivers_List.size(); i++)
        {
            if (dataBase.getInstance().drivers_List.get(i).getUserName().equalsIgnoreCase(d.getUserName()))
            {
                dataBase.getInstance().drivers_List.get(i).rating_List.put(this.userName, r);
                dataBase.getInstance().drivers_List.get(i).setAvg(r);
                x = false;
                System.out.println ("rating");
            }
        }
        if (x)
           System.out.println ("failed");

        
    }
 


    
}
