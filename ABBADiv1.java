package com.company;

public class ABBADiv1 {
    public String canObtain(String initial, String target) {
        boolean result = canObtainInner(initial, target);

        return result ? "Possible" : "Impossible";
    }

    private boolean canObtainInner(String s, String target) {
        if (s.length() == target.length()) {
            return s.equals(target);
        }

        boolean result = false;
        String hA = applyHypothesisA(s);
        String hAReversed = reverse(hA);
        if (target.contains(hAReversed) || target.contains(hA)) {
            result = canObtainInner(hA, target);
        }

        if (!result) {
            String hB = applyHypothesisB(s);
            result = canObtainInner(hB, target);
        }

        return result;
    }

    private String applyHypothesisA(String s) {
        return s + "A";
    }

    private String applyHypothesisB(String s) {
        return "B" + new StringBuilder(s).reverse().toString();
    }

    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
