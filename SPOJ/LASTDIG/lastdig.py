def binPow(a, b):
	if b==0:
		return 1
	res = pow(binPow(a, b//2),2)
	if b%2:
		res *= a
	return res%10
	
for _ in range(int(input())):
	l = list(map(int, input().split()))
	print(binPow(l[0], l[1])) 
