Animals = [
    "Gooty Tarantula", "Golden Bandicoot", "Nothern Hairy Nosed Wombat",
    "Southeast Asia's Javan Rhino"
]

temp = Animals[3]
Animals[3] = Animals[0]
Animals[0] = temp

print(Animals)