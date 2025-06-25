## 🧩 Problem: Partitions with Given Difference

**Difficulty:** Medium  
**Accuracy:** 36.76%  
**Submissions:** 185K+  
**Points:** 4  
**Average Time:** 20 minutes  

---

### 📝 Problem Statement:

Given an array `arr[]`, partition it into two subsets (possibly empty) such that each element must belong to **only one** subset. Let the sum of the elements of these two subsets be `sum1` and `sum2`.

Given a difference `d`, count the number of partitions in which:

- `sum1 ≥ sum2`
- `sum1 - sum2 = d`

---

### 📥 Input

- `arr[]`: An array of integers.
- `d`: A non-negative integer representing the desired difference between the subset sums.

---

### 📤 Output

- Return the **number of valid partitions** satisfying the conditions.

---

### 📚 Examples

#### Example 1:
```
Input:  arr[] = [5, 2, 6, 4], d = 3  
Output: 1  
```
**Explanation:**  
There is only one possible partition:  
- Subset 1: {6, 4} → sum = 10  
- Subset 2: {5, 2} → sum = 7  
- Difference = 10 - 7 = 3 ✅

---

#### Example 2:
```
Input:  arr[] = [1, 1, 1, 1], d = 0  
Output: 6  
```
**Explanation:**  
Choose any 2 elements to form each subset:  
- Total valid combinations = 6

---

#### Example 3:
```
Input:  arr[] = [1, 2, 1, 0, 1, 3, 3], d = 11  
Output: 2  
```

---

### 🔒 Constraints

- `1 <= arr.length <= 50`  
- `0 <= d <= 50`  
- `0 <= arr[i] <= 6`