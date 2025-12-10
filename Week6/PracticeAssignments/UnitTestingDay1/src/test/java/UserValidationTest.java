import com.revature.assignments.utils.UserValidation;
import com.revature.assignments.utils.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserValidationTest {
    private UserValidation validator;

    @BeforeEach
    public void setup() {
        validator = new UserValidation();
    }

    @Test
    void validateEmailNullThrowException() {
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {validator.validateEmail(null);});
        Assertions.assertTrue(ex.getMessage().contains("Email cannot be null"));
    }
    @Test
    void validateEmailEmptyThrowException() {
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {validator.validateEmail("");
        });
        Assertions.assertTrue(ex.getMessage().contains("Email cannot be empty"));
    }
    @Test
    void validateEmailContainAtThrowException(){
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {validator.validateEmail("asdfjhasd");
        });
        Assertions.assertTrue(ex.getMessage().contains("Email must contain @"));
    }
    @Test
    void validateEmailContainAtBeforeAfterThrowException() {
        Assertions.assertAll("Email has invalid format",
                () -> Assertions.assertThrows(IllegalArgumentException.class,
                        () -> validator.validateEmail("@asjd")),
                () -> Assertions.assertThrows(IllegalArgumentException.class,
                        () -> validator.validateEmail("asdasd@"))
                );
    }

    @Test
    void validatePasswordNullThrowException() {
        ValidationException ex = Assertions.assertThrows(
                ValidationException.class,
                () -> {validator.validatePassword(null);}
        );
        Assertions.assertTrue(ex.getMessage().contains("Password cannot be null"));
    }
    @Test
    void validatePasswordShortThrowException() {
        ValidationException ex = Assertions.assertThrows(
                ValidationException.class,
                () -> {validator.validatePassword("asdasdh");}
        );
        Assertions.assertTrue(ex.getMessage().contains("Password must be at least 8 characters"));
    }
    @Test
    void validatePasswordNoUpperException() {
        ValidationException ex = Assertions.assertThrows(
                ValidationException.class,
                () -> {validator.validatePassword("asdashjd");}
        );
        Assertions.assertTrue(ex.getMessage().contains("Password must contain an uppercase letter"));
    }
    @Test
    void validatePasswordNoLowerException() {
        ValidationException ex = Assertions.assertThrows(
                ValidationException.class,
                () -> {validator.validatePassword("ASKDAASKD");}
        );
        Assertions.assertTrue(ex.getMessage().contains("Password must contain a lowercase letter"));
    }

    @Test
    void validateAgeNonNegativeThrowException() {
        IllegalArgumentException ex = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {validator.validateAge(-1);}
        );
        Assertions.assertTrue(ex.getMessage().contains("Age cannot be negative"));
    }
    @Test
    void validateAgeZeroThrowException() {
        IllegalArgumentException ex = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {validator.validateAge(151);}
        );
        Assertions.assertTrue(ex.getMessage().contains("Age cannot exceed 150"));
    }
}
