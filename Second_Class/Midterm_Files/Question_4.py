def odd_even_sort(array):
    even_indices = list(range(0, len(array)-1, 2))
    odd_indices = list(range(1, len(array)-1, 2))
    sorted = False
    while not sorted:
        sorted = True

        for index in odd_indices:
            if array[index] > array[index + 1]:
                array[index], array[index + 1] = array[index + 1], array[index]
                sorted = False

        for index in even_indices:
            if array[index] > array[index + 1]:
                array[index], array[index + 1] = array[index + 1], array[index]
                sorted = False

    return array


array = [0, 1, 4, 6, 2, 5, 3, 9, 7, 8, 20, 15, 13, 16]
print(f'Original Array: {array}')
sorted_array = odd_even_sort(array)
print(f'Sorted Array: {sorted_array}')