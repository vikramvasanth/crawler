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
with open('HAdoopCSV.csv', 'r') as text_file:
 text = text_file.read()
 text = text.lower()
 text = strip_non_ascii(text)
 tokenizer = RegexpTokenizer(r'\w+')
 s=BlanklineTokenizer().tokenize(text)
 tokens=tokenizer.tokenize(str(text))
 print(s)
 tokens = [w for w in tokens if not w in stopset]
 fdist1 = nltk.FreqDist(tokens)
 print(fdist1.most_common(500) )
# tags=nltk.pos_tag(tokens)
# print(fdist1[0:99])
# fdist1.plot(20, cumulative = True)
