class find_median():
    def __init__(self, array):
        self.array = array
        self.array.sort()

    def median(self):
        length = len(self.array)

        if length % 2 == 1:
            return self.array[length // 2]
        
        else:
            middle1 = self.array[length // 2 - 1]
            middle2 = self.array[length // 2]

            return (middle1 + middle2) / 2
        

sorted_array = find_median([4, 5, 2, 7, 8, 1, 10, 15, 12, 14, 20])

print(f'Sorted Array: {sorted_array.array}')
print(f'Median Element: {sorted_array.median()}')