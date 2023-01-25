# cook your dish here
def gcd(a,b):
    if not b:
        return a
    else:
        return gcd(b,a%b)
for _ in range(int(input())):
    l=list(map(int, input().split()))
    l.sort(reverse=True)
    a = gcd(l[0],l[1])
    print(a, (int)(l[0]/a*l[1]))
    
