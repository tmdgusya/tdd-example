import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PasswordStrengthMeterTest {

    PasswordStrengthMeter meter = new PasswordStrengthMeter();


    @Test
    void meetsAllCriteria_Then_Strong() {
        var result = meter.meter("ab12!@AB");
        assertEquals(PasswordStrength.STRONG, result);
        var resul2 = meter.meter("abc!Add1");
        assertEquals(PasswordStrength.STRONG, resul2);
    }

    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        PasswordStrength result = meter.meter("ab12!@A");
        assertEquals(PasswordStrength.NORMAL, result);
    }

    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal() {
        PasswordStrength result = meter.meter("ab!@ABqwer");
        assertEquals(PasswordStrength.NORMAL, result);

        PasswordStrength result2 = meter.meter("ab!@A12Bqwer");
        assertEquals(PasswordStrength.STRONG, result2);
    }
}
