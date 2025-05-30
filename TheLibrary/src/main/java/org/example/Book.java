package org.example;

public class Book {
   private int id;
   private String isbn;
   private String title;
   private boolean isCheckedOut;
   private String checkedOutTo;


   //contructors


    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    //getter & setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }
    public void checkIn(){
        isCheckedOut = false;
        checkedOutTo = "";
    }
    public void isCheckedOut(String name){
        isCheckedOut = true;
        checkedOutTo = name;
    }
    public void returnBook() {
        isCheckedOut = false;
        checkedOutTo = null;
    }


}
