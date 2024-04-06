package ee.telestickers.backend.customer;

public record CustomerAddRequest(Integer tgId, String firstname, String lastname, String email, Countries country, String address, Integer postcode, String phoneNumber) {
}
