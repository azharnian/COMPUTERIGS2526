def binary_search(arr, n):
    # counter = 0 # pass counter
    left = 0
    right = len(arr) - 1
    while left <= right:
        mid = (right + left) // 2 #floor
        # counter += 1
        if arr[mid] == n:
            return mid
        elif arr[mid] > n:
            right = mid - 1
        else:
            left = mid + 1
    return -1
        


def linear_search(arr, n):
    for i in range(len(arr)) :
        if arr[i] == n:
            return i
    return -1

arr = [2, 3, 11, 35, 600, 901, 1034, 2200, 2459, 3444]
print(binary_search(arr, 11)) #2
print(linear_search(arr, 11))