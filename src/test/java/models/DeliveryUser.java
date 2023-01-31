package models;

import java.util.Objects;

public class DeliveryUser {
    public String userName;
    public String lastName;
    public String postalCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "DeliveryUser{" +
                "userName='" + userName + '\'' +
                ", password='" + lastName + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryUser that = (DeliveryUser) o;
        return Objects.equals(userName, that.userName) && Objects.equals(lastName, that.lastName) && Objects.equals(postalCode, that.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, lastName, postalCode);
    }
}
