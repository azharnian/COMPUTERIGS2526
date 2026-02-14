def getAdd(*args):
    if not args:
        return 0
    sum = 0
    for item in args:
        sum += item
    return sum

if __name__ == "__main__":
    print(getAdd(2, 3, 4))
    print(getAdd(1, 2.0, 4))
    print(getAdd())