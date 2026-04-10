scores = [96, 93, 90, 100, 92, 90]
x = int(input())

found = False
for item in scores:
    if item == x:
        found = True
        break
    else:
        found = False

print(found)