## 🧮 Longest Common Substring

**Problem**  
You are given two strings `s1` and `s2`. Your task is to find the **length of the longest common substring** between the given strings.

### ✨ Examples

#### Example 1:
- **Input:**  
  `s1 = "ABCDGH"`  
  `s2 = "ACDGHR"`  
- **Output:**  
  `4`  
- **Explanation:**  
  The longest common substring is `"CDGH"` with a length of `4`.

#### Example 2:
- **Input:**  
  `s1 = "abc"`  
  `s2 = "acb"`  
- **Output:**  
  `1`  
- **Explanation:**  
  The longest common substrings are `"a"`, `"b"`, and `"c"`, all having length `1`.

#### Example 3:
- **Input:**  
  `s1 = "YZ"`  
  `s2 = "yz"`  
- **Output:**  
  `0`  
- **Explanation:**  
  The strings do not have any common substrings considering case sensitivity.

---

### 🔒 Constraints
- `1 <= s1.length(), s2.length() <= 10^3`
- Both strings may contain **upper and lower case alphabets**.
- The comparison is **case-sensitive**.
