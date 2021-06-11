package App;

import Admin.Affiliation;
import Database.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User {

    protected long user_id, national_id;
    protected String first_name, last_name, password, email, address, date_of_birth;
    protected int phone_number;
    protected ArrayList<Affiliation> enrolled;

    public Boolean Authorized(String email, String password) throws SQLException {
        String query =  "select * from user where email='"+email+"' and password='"+password+"'";
        Connector login = new Connector();
        ResultSet result = login.read(query);
        if (result.next() == false) {
            login.end();
            return false;
        }
        login.end();
        return true;
    }
    // Getters

    public int getPhone_number() {
        return phone_number;
    }

    public ArrayList<Affiliation> getEnrolled() {
        return enrolled;
    }

    public long getNational_id() { return national_id; }

    public long getUser_id() {
        return user_id;
    }

    public String getAddress() {
        return address;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPassword() {
        return password;
    }

    // Setters

    public void setAddress(String address) { this.address = address; }

    public void setDate_of_birth(String date_of_birth) { this.date_of_birth = date_of_birth; }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNational_id(long national_id) {
        this.national_id = national_id;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setEnrolled(ArrayList<Affiliation> enrolled) {
        this.enrolled = enrolled;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
