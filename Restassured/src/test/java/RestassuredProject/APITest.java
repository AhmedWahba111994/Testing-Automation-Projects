package RestassuredProject;


import org.testng.annotations.Test;
import com.shaft.*;


import static io.restassured.RestAssured.given;

public class APITest {
    SHAFT.API driver;

    @Test(priority=1)
    public void Login(){
        given().log().all().when().post("https://api.development.qawafel.dev/backoffice/v1/login?email=ahmedwahba@qawafel.sa&password=Ahmedwahba@123").then().log().body();
    }



    @Test(priority = 2)
    public void otp(){
        given().queryParam("mobile","538989808").queryParam("otp","201111").when()
                .post("https://api.development.qawafel.dev/storefront/v1/customers/otp").then().log().body();
    }
    @Test(priority = 3)
    public void VerifyOtp(){
        given().queryParam("mobile","538989808").queryParam("otp","201111").when().post("https://api.development.qawafel.dev/storefront/v1/customers/verify-otp").then().log().body();
    }
    @Test(priority = 4)
    public void SuccessfulCustomerLogin(){
        given().when().get("https://api.development.qawafel.dev/storefront/v1/customers/me").then().log().body();

    }
    @Test(priority = 5)
    public void GetCustomerAddress(){
        given()
                .header("authorization","Bearer 5383|j3s6h9vftVvMufjyxPw2haswa8GNZlChOAHPjYMM")
                .header("mobile","538989808").header("otp","201111").when()
                .get("https://api.development.qawafel.dev/storefront/v1/customers/addresses").then().assertThat().statusCode(200).log().body();
    }
}
