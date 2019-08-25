#!/usr/bin/env python
# -*- coding: latin-1 -*-
# -*- coding: utf-8 -*-

import re

def get_tokens(text):
    return text.split(' ')

def clear_tokens(tokens):
    clean_tokens = []
    for token in tokens:
        auxiliar_token = []
        for letter in token:
            if re.match(r'[a-záéíóúñA-ZÁÉÍÓÚÑ]', letter):
                auxiliar_token.append(letter)
        if (auxiliar_token != ''):
            clean_tokens.append(''.join(auxiliar_token))
    return clean_tokens

def delete_stop_words(tokens, stop_words):
    no_stop_words = []
    for token in tokens:
        if(token not in stop_words):
            no_stop_words.append(token)
    return no_stop_words

def get_stop_words(file_direction):
    file = open(file_direction, 'r')
    stop_words = file.read()
    stop_words = stop_words.split()
    return ' '.join(stop_words)

def  process(text, stop_words):
    stop_words = [word.encode("utf-8") for word in stop_words]
    tokens = get_tokens(text)
    clean_tokens = clear_tokens(tokens)
    clean_tokens = delete_stop_words(clean_tokens, stop_words)
    return ' '.join(clean_tokens)

