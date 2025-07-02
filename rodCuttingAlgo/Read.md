# Rod Cutting Problem

Given a rod of length `n` inches and an array `price[]`, where `price[i]` denotes the value of a piece of length `i`, your task is to determine the **maximum value obtainable** by cutting up the rod and selling the pieces.

> **Note:**  
> - `n = size of price`  
> - `price[]` is a **1-indexed** array (i.e., `price[1]` gives price of length-1 piece)

---

## 🧩 Problem Explanation

The goal is to cut the rod in such a way that the total sum of prices is maximized. You can cut the rod into any number of pieces, or not cut it at all.

---

## 📥 Example Inputs and Outputs

### Example 1:
```text
Input:  price[] = [1, 5, 8, 9, 10, 17, 17, 20]
Output: 22
