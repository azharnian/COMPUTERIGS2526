def mystery(list):
    max = list[0]
    index = 0
    count = 0

    for item in list:
        if item > max:
            max = item
            index = count
        count = count + 1
    
    return index

list1 = [11, 35, 6]
print(mystery(list1))