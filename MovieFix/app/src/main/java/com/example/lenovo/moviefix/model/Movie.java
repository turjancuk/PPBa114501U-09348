package com.example.lenovo.moviefix.model;

public class Movie {
    private int id;
    private String judul;
    private String rating;
    private String status;

    public Movie(String string, String cursorString){
    }

    public Movie(String judul, String rating, String status){
        this.judul = judul;
        this.rating = rating;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getJudul(){return judul;}
    public void setJudul(String judul){this.judul=judul;}

    public String getRating(){return rating;}
    public void setRating(String rating){this.rating=rating;}

    public String getStatus(){return status;}
    public void setStatus(String status){this.status=status;}

}
