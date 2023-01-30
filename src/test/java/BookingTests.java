import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.Entities.Booking;
import org.example.Entities.BookingDates;
import org.example.Entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class BookingTests {
    private static Faker faker;
    private static RequestSpecification request;

    private static Booking booking;
    private static BookingDates bookingDates;
    private static User user;

    @BeforeAll
    public static void Setup(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        faker = new Faker();
        user = new User(
                faker.name().username(),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().safeEmailAddress(),
                faker.internet().password(),
                faker.phoneNumber().toString()
        );

        bookingDates = new BookingDates("2018-01-02", "2018-03-02");

        booking = new Booking(
                user.getFirstname(),
                user.getLastname(),
                (float)faker.number().randomDouble(2, 50, 100000),
                true,
                bookingDates,
                "Breakfast"
        );

        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new ErrorLoggingFilter());
    }

    @BeforeEach
    void setRequest(){
        request = given()
                .config(RestAssured
                        .config()
                        .logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
                .contentType(ContentType.JSON)
                .auth().basic("admin", "password123");
    }

    @Test
    public void getBookingById_returnOk(){
        Response response = request.when().get("/booking").then().extract().response();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.statusCode());
    }






}
