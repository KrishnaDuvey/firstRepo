package com.example.android.learningportal;

import static android.R.attr.name;

/**
 * Created by Krishna on 10/2/2016.
 */

public class Compact {
    int id;
    String fname,lname,pwd,email,dob,phno,cpwd;

    public void setId(int id)
    {
    this.id=id;

    }
    public int getId()
    {
        return this.id;

    }
    public void setfname(String fname)
    {

        this.fname=fname;
    }
    public String getFname()
    {

        return  this.fname;
    }



    public void setlname(String lname)
    {

        this.lname=lname;
    }
    public String getlname()
    {

        return  this.lname;
    }


    public void setemail(String email)
    {

        this.email=email;
    }
    public String getemail()
    {

        return  this.email;
    }

    public void setpwd(String pass)
    {

        this.pwd=pass;
    }
    public String getpwd()
    {

        return  this.pwd;
    }

    public void setcpwd(String cpass)
    {

        this.cpwd=cpass;
    }
    public String getcpwd()
    {

        return  this.cpwd;
    }
    public void setdob(String dob)
    {

        this.dob=dob;
    }
    public String getdob()
    {

        return  this.dob;
    }



    public void setphno(String phno)
    {

        this.phno=phno;
    }
    public String getphno()
    {

        return  this.phno;
    }



}
