package com.spenterise.saytam.Model;

public class Category{

    private String Name;
    private String Image;
    private String Prices;


       public Category(){

       }

        public Category(String name, String image, String prices) {
            Name = name;
            Image = image;
            Prices = prices;
        }


        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getImage() {
            return Image;
        }

        public void setImage(String image) {
            Image = image;
        }

        public String getPrices() {
            return Prices;
        }

        public void setPrices(String prices) {
            Prices = prices;
        }
}
