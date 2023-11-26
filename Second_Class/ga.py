while True:
    end = int(input("End? "))
    if end != 0:
        break
    one = int(input('1: '))
    two = int(input('2: '))
    three = int(input('3: '))
    four = int(input('4: '))
    five = int(input('5: '))
    six = int(input('6: '))
    seven = int(input('7: '))
    eight = int(input('8: '))

    score = (one + two) - (three + four) + (five + six) - (seven + eight)
    print(score)