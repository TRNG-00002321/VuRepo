# Given a string s, and a pattern p. You need to find if p exists in s or not and
# return the starting index of p in s. If p does not exist in s then -1 will be returned.
# Here p and s both are case-sensitive.

s = "Revature Training"
p = "Train"
found_index = -1

for i in range(len(s)):
    slice_of_s = s[i:i+len(p)]

    if p == slice_of_s:
        found_index = i
        break

print(found_index)

