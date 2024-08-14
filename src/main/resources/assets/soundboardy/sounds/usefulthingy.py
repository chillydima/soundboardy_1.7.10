import os.path
from time import sleep
import pyperclip

hto = os.walk(os.getcwd())
soundlist = ""
locale = ""

for i, hto, files in hto:
    for file in files:
        if file.rsplit(".")[1] == "ogg":
            soundlist += 	'"'+file.rsplit(".")[0]+'": {"category": "record","sounds": [{"name": "'+file.rsplit(".")[0]+'" ,"stream": true}]},\n'


pyperclip.copy(soundlist + "\n" + locale)
sleep(2)

