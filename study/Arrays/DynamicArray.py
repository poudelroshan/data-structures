import ctypes

class DynamicArray:

    def __init__(self):
        self._size = 0
        self._capacity = 1
        self._arr = self._make_array(self._capacity)

    """ Returns the length of the array """
    def __len__(self):
        return self._size

    ''' Returns the item at index i '''
    def __getitem__(self, i):
        if not 0 <= i < self._size:
            raise IndexError("Index out of bound")
        return self._arr[i]

    ''' adds item to the end of the array '''
    def append(self, item):
        if self._size == self._capacity:
            self._resize(self._capacity * 2)
        self._arr[self._size] = item
        self._size += 1

    ''' private method to resize the array '''
    def _resize(self, c):
        temp = self._make_array(c)
        for i in range(self._size):
            temp[i] = self._arr[i]
        self._arr = temp
        self._capacity = c

    ''' private method to create an array of capacity c '''
    def _make_array(self, c):
        return (c * ctypes.py_object) ()

    ''' printing the array '''
    def __str__(self):
        temp = "["
        for i in range(self._size - 1):
            temp += str(self._arr[i]) + ", "
        temp += str(self._arr[self._size - 1]) + "]"
        return temp
        
if __name__ == "__main__":
    a = DynamicArray()

    for i in range(10):
        a.append(i)
        print(a[i])

