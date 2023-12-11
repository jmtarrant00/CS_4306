import numpy as np
def back_substitution(U, y):
  x = np.zeros(y.shape)
  n = U.shape[0]

  for i in range(n - 1, -1, -1):
    x[i] = (y[i] - np.dot(U[i, i + 1:], x[i + 1:])) / U[i, i]

  return x

U = np.array([[1, 2, 3],
               [0, 4, 5],
               [0, 0, 6]])
y = np.array([10, 20, 30])

x = back_substitution(U, y)

print(x)