public class PasswordStrengthMeter {
    public PasswordStrength meter(String password) {
        if (password == null || password.isEmpty()) return PasswordStrength.INVALID;
        int metCounts = getMetCounts(password);

        if (metCounts <= 1) return PasswordStrength.WEAK;
        if (metCounts == 2) return PasswordStrength.NORMAL;

        return PasswordStrength.STRONG;
    }

    private int getMetCounts(String password) {
        int metCounts = 0;

        if (password.length() >= 8) metCounts++;
        if (meetsContainingNumberCriteria(password)) metCounts++;
        if (meetsContainingUppercaseCriteria(password)) metCounts++;
        return metCounts;
    }

    private static boolean meetsContainingUppercaseCriteria(String password) {
        boolean containsUpp = false;
        for (char ch : password.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                containsUpp = true;
            }
        }
        return containsUpp;
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
