class Ordered_Array():
    def __init__(self):
        self.array = []
        self.num_items = 0

    def __len__(self):
        return(self.num_items)
    
    def display(self):
        print(self.array, '\n')

    def insert_element(self, record):
        print(f'Inserting {record}')
        index = 0
        while index < len(self.array) and self.array[index] < record:
            index += 1

        self.array.insert(index, record)
        self.num_items += 1
    
    def get(self, index):
        return(self.array[index])
    
    def find(self, record):
        low, high = 0, self.num_items

        while low <= high:
            mid = (low + high) // 2
            if self.array[mid] == record:
                print(f'Record {record} is at index {mid}')
                return True
            elif self.array[mid] < record:
                low = mid + 1
            else:
                high = mid - 1
        
        print(f'Record {record} not found in array')
    
    def delete(self, record):
        index  = self.find(record)
        
        if index != -1:
            del self.array[index]
            return True
        else:
            print(f'Record {record} not in array')
            return False
        

array = Ordered_Array()
array.insert_element(4)
array.display()
array.insert_element(7)
array.display()
array.insert_element(6)
array.display()
array.insert_element(1)
array.display()
array.insert_element(10)
array.display()

print(f'The array is {len(array)} element{"s" if len(array) > 1 else ""} long')

array.find(4)
array.find(5)

array.delete(4)
print(f'Array after record deletion:')
array.display()

