# 3-4

guests = ["andi", "bob", "cindy"]
print("Hi",guests[0],"you are invited dinner!")
print(f"Hi {guests[1]} you are invited dinner!")
print(f"Hi {guests[2]} you are invited dinner!")

# 3-5
print(f"{guests[2]} is not able to make the dinner with us.")
guests[2] = "gilbert"
print(f"So we are inviting {guests[2]}")

# 3-6
print("Hey, we found a big table, so we invite more")
guests.insert(0, "feyman");
guests.insert(2, "felix");
guests.append("fred");
print(f"{guests[0]}")
print(f"{guests[1]}")
print(f"{guests[2]}")
print(f"{guests[3]}")
print(f"{guests[4]}")
print(f"{guests[5]}")

# 3-7
print("")
guests.pop()
guests.pop()
guests.pop()
guests.pop()

print(f"{guests[0]}")
print(f"{guests[1]}")

del guests[1]
del guests[0]
# or
# del guests[0]
# del guests[0]

print(guests)