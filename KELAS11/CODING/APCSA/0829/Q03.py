class Tree:

    def __init__(self, n=None, h=None, r=None):
        self.name = n
        self.height = h
        self.rate_of_growth = r

    def __repr__(self):
        return f"This tree has name, and it's {self.name} ..."
        

tree_1 = Tree("akasia", 200, 0.2)
tree_2 = Tree(300, 0.3)
tree_3 = Tree("mahoni")
print(tree_1)
print(tree_2)
print(tree_3)