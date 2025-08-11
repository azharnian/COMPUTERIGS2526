def type_triangle(a, b, c):
    if a == b == c:
        return "Segitiga sama sisi"
    if a == b or b == c or a ==c:
        return "Segitiga sama kaki"
    return "Segitiga sembarang"