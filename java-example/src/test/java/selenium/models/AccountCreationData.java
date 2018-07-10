package selenium.models;

public class AccountCreationData {

    public String firstName;
    public String lastName;
    public String address1;
    public String postcode;
    public String city;
    public String country;
    public String email;
    public String phone;
    public String password;

    public AccountCreationData(
            String firstName,
            String lastName,
            String address1,
            String postcode,
            String city,
            String country,
            String email,
            String phone,
            String password, String s){

        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.postcode = postcode;
        this.city = city;
        this.country = country;
        this.email = email;
        this.phone = phone;
        this.password = password;

    }

    public AccountCreationData(String firstName,
                               String lastName,
                               String address1,
                               String postcode,
                               String city,
                               String country,
                               String email,
                               String phone,
                               String password) {
    }
}
