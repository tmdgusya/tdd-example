public class PasswordStrengthMeter {
    public PasswordStrength meter(String password) {
        if (password == null || password.isEmpty()) return PasswordStrength.INVALID;
        if (password.length() < 8) {
            return PasswordStrength.NORMAL;
        }

        if (!meetsContainingNumberCriteria(password)) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }

    private boolean meetsContainingNumberCriteria(String password) {
        boolean containsNum = false;

        for (char ch : password.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                containsNum = true;
                break;
            }
        }

        return containsNum;
    }
}
