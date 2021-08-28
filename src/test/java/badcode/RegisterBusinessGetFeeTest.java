package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterBusinessGetFeeTest {
    @Test
    @DisplayName("test register success with experience 1 year.")
    public void testRegisterSuccessWithExperienceOneYear() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        int actual = registerBusiness.getFee(1);
        assertEquals(500, actual);
    }

    @Test
    @DisplayName("test register success with experience 3 year.")
    public void testRegisterSuccessWithExperienceThreeYear() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        int actual = registerBusiness.getFee(3);
        assertEquals(250, actual);
    }

    @Test
    @DisplayName("test register success with experience 5 year.")
    public void testRegisterSuccessWithExperienceFiveYear() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        int actual = registerBusiness.getFee(5);
        assertEquals(100, actual);
    }

    @Test
    @DisplayName("test register success with experience 9 year.")
    public void testRegisterSuccessWithExperienceNineYear() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        int actual = registerBusiness.getFee(9);
        assertEquals(50, actual);
    }
}
