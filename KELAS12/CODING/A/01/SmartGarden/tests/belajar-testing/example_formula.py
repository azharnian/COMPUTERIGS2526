def calculate_root(x):
    if x < 0:
        raise ValueError("Number must be\
         non-negative")
    return x ** (0.5)

def calculate_divide(x, y):
    if y == 0:
        raise ZeroDivisionError("Ga bisa\
         dibagi 0 bro.")
    return x / y