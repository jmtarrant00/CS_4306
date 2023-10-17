class Array(object):

   def __init__(self, initialSize):    # Constructor
      self.array = [None] * initialSize  # The array stored as a list
      self.num_items = 0                # No items in array initially

 

   def __len__(self):                  # Special def for len() func
      return self.num_items             # Return number of items

   

   def get(self, n):                   # Return the value at index n
      if 0 <= n and n < self.num_items: # Check if n is in bounds, and
         return self.array[n]            # only return item if in bounds

   

   def set(self, n, value):            # Set the value at index n
      if 0 <= n and n < self.num_items: # Check if n is in bounds, and
         self.array[n] = value           # only set item if in bounds

      

   def insert(self, item):             # Insert item at end
      self.array[self.num_items] = item   # Item goes at current end
      self.num_items += 1               # Increment number of items

 

   def find(self, item):               # Find index for item
      for j in range(self.num_items):   # Among current items
         if self.array[j] == item:       # If found,
            return j                   # then return index to item

      return -1                        # Not found -> return -1

   

   def search(self, item):             # Search for item
      return self.get(self.find(item)) # and return item if found

 

   def delete(self, item):             # Delete first occurrence
      for j in range(self.num_items):   # of an item
         if self.array[j] == item:       # Found item
            self.num_items -= 1         # One fewer at end
            for k in range(j, self.num_items):  # Move items from
               self.array[k] = self.array[k+1]     # right over 1
            return True                # Return success flag

      return False     # Made it here, so couldn't find the item   

 

   def traverse(self, function=print): # Traverse all items
      for j in range(self.num_items):   # and apply a function
         function(self.array[j])