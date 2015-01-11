from nltk.tokenize import word_tokenize
from nltk.corpus import stopwords
from nltk.tokenize import RegexpTokenizer
from nltk.tokenize import BlanklineTokenizer
import nltk

def strip_non_ascii(string):
    ''' Returns the string without non ASCII characters'''
    stripped = (c for c in string if 0 < ord(c) < 127)
    return ''.join(stripped)

stopset = set(stopwords.words('english'))
with open('nounsentence.txt', 'r') as text_file:
 text = text_file.read()
 text = text.lower()
 text = strip_non_ascii(text)
 sentences = nltk.sent_tokenize(text)
 sentences = [nltk.word_tokenize(sent) for sent in sentences]
 sentences = [nltk.pos_tag(sent) for sent in sentences]
 print(sentences)
# print(nltk.ne_chunk(sentences)) 
