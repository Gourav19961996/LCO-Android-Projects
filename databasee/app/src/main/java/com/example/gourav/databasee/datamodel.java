package com.example.gourav.databasee;

public class datamodel {

  //  public String uid;

    public String name;
    public String contact;
    public String email;
    public String address;

    public datamodel( String name, String contact, String email, String address) {
       // this.uid = uid;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.address = address;
    }

//    public String getUid() {
//       // return uid;
//    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
