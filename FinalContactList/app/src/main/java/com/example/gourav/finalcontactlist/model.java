package com.example.gourav.finalcontactlist;

public class model {

   public String uid,name,contact,email;

    public model() {
    }

    public model(String uid, String name, String contact, String email) {
        this.uid = uid;
        this.name = name;
        this.contact = contact;
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }
}
