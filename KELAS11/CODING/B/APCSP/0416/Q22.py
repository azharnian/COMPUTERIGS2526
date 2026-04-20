def mystery():
    a = True
    b = not False
    c = True

    d = ""

    if a == True and b == True:
        d += "Cherry Wood"
    if a == True or c == True:
        d += "Apple"
    if a == True and c == False:
        d += "Maple"

    return d

print(mystery())

