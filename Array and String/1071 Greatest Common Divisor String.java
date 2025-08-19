class Solution { 
    public String gcdOfStrings(String str1, String str2) {

        // Step 1: Check if str1 + str2 equals str2 + str1.
        // Why? Because for two strings to have a common divisor,
        // their concatenations in both orders must match.
        // Example: str1 = "ABAB", str2 = "AB"
        //   str1+str2 = "ABABAB"
        //   str2+str1 = "ABABAB" → matches, so possible.
        // Counterexample: str1 = "ABC", str2 = "AB"
        //   str1+str2 = "ABCAB"
        //   str2+str1 = "ABABC" → not equal, so no gcd string exists.
        String a = str1.concat(str2);
        String b = str2.concat(str1);
        if (!a.equals(b)){
            return ""; 
        }
        else{
            // Step 2: If concatenations match, then a gcd string exists.
            // The length of that string must be the gcd of the lengths
            // of str1 and str2.
            int gcd;
            if (str1.length() < str2.length()){
                gcd = findGCD(str2.length(), str1.length());
            } else{
                gcd = findGCD(str1.length(), str2.length());
            }

            // Step 3: Return the prefix of str1 with length gcd.
            // This works because we already confirmed both strings
            // are made up of repetitions of this substring.
            return str1.substring(0,gcd);
        }
    }   

    // Helper: Euclidean Algorithm to find GCD of two numbers
    public int findGCD(int a, int b){
        int x = b;
        while (x != 0){ 
            x = a % b; 
            a = b;
            b = x;
        }
        return a; 
    }
}


/*
    Rubber Duck Walkthrough (Explaining the Thought Process):

    - The problem: Find the largest string X that divides both str1 and str2,
      meaning both str1 and str2 are built by repeating X.

    - Step 1: Check concatenation property.
        If str1 + str2 != str2 + str1, then no such string X exists.
        Why? Because the order of repetition wouldn’t line up.

    - Step 2: Use GCD of lengths.
        If a gcd string exists, its length must divide both str1.length
        and str2.length. That’s exactly what GCD gives us.

    - Step 3: Extract substring.
        Return str1.substring(0, gcd) as the gcd string.
        This works because:
            • The substring repeats to form str1.
            • The substring repeats to form str2.
        And we know this is consistent because of Step 1’s concatenation check.

    - Example:
        str1 = "ABABAB", str2 = "ABAB"
        str1+str2 = "ABABABABAB"
        str2+str1 = "ABABABABAB" → matches.
        gcd(len(str1), len(str2)) = gcd(6,4) = 2
        str1.substring(0,2) = "AB"
        Answer = "AB"

    - Complexity:
        Checking concatenation: O(n + m).
        Euclidean algorithm: O(log(min(n,m))).
        Overall: O(n + m).

    Difficulty rating: 7/10
    Time spent: ~50 minutes (with AI hints)
*/
