## 🎒 Problem: 0/1 Knapsack

**Difficulty:** Medium  
**Points:** 4  

---

### 📝 Problem Statement:

Given `n` items, each with a specific weight and value, and a knapsack with a capacity of `W`, the task is to put the items in the knapsack such that:

- The sum of weights of the items ≤ `W`
- The sum of values of the selected items is **maximized**

🔒 **Note:**
- You can either place an item **entirely** in the bag or **leave it out** entirely.
- Each item is available in **single quantity**.

---

### 📥 Input

- `W`: Integer representing the knapsack capacity.
- `val[]`: Array of integers representing the values of the items.
- `wt[]`: Array of integers representing the weights of the items.

---

### 📤 Output

- Return the **maximum total value** that can be accommodated in the knapsack.

---

### 📚 Examples

#### Example 1:
```
Input:  W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1]
Output: 3
```
**Explanation:** Choose the last item (value = 3, weight = 1).

---

#### Example 2:
```
Input:  W = 3, val[] = [1, 2, 3], wt[] = [4, 5, 6]
Output: 0
```
**Explanation:** Every item exceeds the knapsack's capacity.

---

#### Example 3:
```
Input:  W = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 2, 3]
Output: 80
```
**Explanation:** Choose the third item (value = 30, weight = 2) and the last item (value = 50, weight = 3).

---

### 🔒 Constraints

- `2 ≤ val.length = wt.length ≤ 10^3`  
- `1 ≤ W ≤ 10^3`  
- `1 ≤ val[i] ≤ 10^3`  
- `1 ≤ wt[i] ≤ 10^3`