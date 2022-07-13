from flask import render_template, redirect, request, sessions
from flask_app import app

from flask_app.models.ninja import Ninja
from flask_app.models.dojo import Dojo
@app.route('/ninjas')
def ninjas():
    return render_template('ninjas.html', dojos= Dojo.get_all())

@app.route('/create/ninja', methods=["POST"])
def create_ninja():
    print(request.form)
    Ninja.save(request.form)
    return redirect('/dojos')