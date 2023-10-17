def reverse_word(word):
    rev_word = ''
    char_list = list(word)
    length = len(char_list)

    for i in range(length // 2):
        char_list[i], char_list[length - 1 - i] = char_list[length - 1 - i], char_list[i]

    rev_word = ''.join(char_list)
    return rev_word

word = input('What word do you want to reverse? ')
rev_word = reverse_word(word)
print(f'Original Word: {word}')
print(f'{word} reversed: {rev_word}')