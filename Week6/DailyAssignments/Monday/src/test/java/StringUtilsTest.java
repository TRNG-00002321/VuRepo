/*
Assignment :
Task 1: Test `reverse()`
Task 2: Test `isEmpty()`
Task 3: Test `findFirst()` with Null Handling
Task 4: Test `split()` with Array Assertions
Task 5: Master `assertAll()`
Write a single test that validates a `User` object using `assertAll`:
*/

import com.revature.assignments.model.User;
import com.revature.assignments.utils.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


public class StringUtilsTest {
    @Test
    public void testReverse(){
        String result = StringUtils.reverse("Hello");
        assertEquals("olleH", result);
        assertEquals("", StringUtils.reverse(""));
        assertNull(StringUtils.reverse(null));
    }

    @Test
    public void testIsEmpty(){
        assertTrue(StringUtils.isEmpty(""));
        assertTrue(StringUtils.isEmpty(null));
        assertFalse(StringUtils.isEmpty("Hello"));
    }

    @Test
    public void findFirst(){
        String[] items = {"apple", "banana", "apricot"};

        assertEquals("apple", StringUtils.findFirst(items, "ap"));
        assertEquals("banana", StringUtils.findFirst(items, "ba"));
        assertNull(StringUtils.findFirst(items, "z"));
        assertNull(StringUtils.findFirst(null, "a"));
    }

    @Test
    public void split(){
        String[] result = StringUtils.split("a,b,c,d", ",");
        assertArrayEquals(new String[]{"a", "b", "c", "d"}, result);
    }

    @Test
    public void assertAll(){
        String csv = "Vu,Phan,24,vuphan1101@gmail.com";
        User user = StringUtils.parseUser(csv);

        Assertions.assertAll(
                () -> assertEquals("Vu", user.getFirstName()),
                () -> assertEquals("Phan", user.getLastName()),
                () -> assertEquals(24, user.getAge()),
                () -> assertEquals("vuphan1101@gmail.com", user.getEmail())
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    public void isBlank_blankInputs_returnsTrue(String input) {
        assertTrue(StringUtils.isBlank(input));
    }
}
