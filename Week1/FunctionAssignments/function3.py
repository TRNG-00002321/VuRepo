# Given a number n, find the first digit of the number.

n = 53531
#firstDigit = int(str(n)[0])
#print(firstDigit)

firstDigit = n
while firstDigit >= 10:
    firstDigit = firstDigit // 10

print(firstDigit)

