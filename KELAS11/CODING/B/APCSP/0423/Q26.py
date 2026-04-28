
def ave(scoreList):
    total = 0
    count = 0

    for item in scoreList:
        total += item
        count += 1

    return total/count

nums = [90, 87, 90, 67]
print(ave(nums))