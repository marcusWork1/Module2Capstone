package com.techelevator.tenmo.model;

public class Tenmo_user {


        private int id;
        private String username;
        private String password;
        private String role;


        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }


        @Override
        public String toString() {
            return "Tenmo_user: " +
                    "|user id: " + id +
                    "| |username:" + username.substring(0,1).toUpperCase() +  "" + username.substring(1) + "|\n"
                    + "________________________________________________";
        }

}
