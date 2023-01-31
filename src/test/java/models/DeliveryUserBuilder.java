package models;

public class DeliveryUserBuilder {
    private String firstName;
    private String lastName;
    private String postalCode;

    public static class Builder {
        private DeliveryUserBuilder newUser;

        public Builder() {
            newUser = new DeliveryUserBuilder();
        }

        public Builder withFirstName(String value) {
            newUser.firstName = value;
            return this;
        }
        public Builder withLastName(String value) {
            newUser.lastName = value;
            return this;
        }
        public Builder withPostalCode(String value) {
            newUser.postalCode = value;
            return this;
        }
        public DeliveryUserBuilder build(){
            return newUser;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }
}