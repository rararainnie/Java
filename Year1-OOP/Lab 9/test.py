class square:
    def __init__(self, width, height):
        self.width = width
        self.height = height
        
    def __area(self): # Private method
        return self.width * self.height
    
square1 = square(3, 5)
print(square1.area())
