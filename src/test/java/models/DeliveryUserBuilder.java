package models;

public class DeliveryUserBuilder {
    private DeliveryUser newUser;
    public DeliveryUserBuilder() {

        newUser = new DeliveryUser();
    }

    public DeliveryUserBuilder withFirstName (String value) {
        newUser.userName = value;
        return this;
    }
    public DeliveryUserBuilder withLastName (String value) {
        newUser.lastName = value;
        return this;
    }
    public DeliveryUserBuilder withPostalCode (String value) {
        newUser.postalCode = value;
        return this;
    }

    public DeliveryUser build() {
        return newUser;
    }

}

