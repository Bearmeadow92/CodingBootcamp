from flask_bcrypt import Bcrypt
from flask import Flask, flash
import re

app = Flask(__name__)

app.secret_key = "kiskis"