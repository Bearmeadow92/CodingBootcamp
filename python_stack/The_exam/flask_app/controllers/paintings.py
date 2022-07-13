import re
from flask_app import app, Bcrypt
from flask import render_template,redirect,request,session,flash
from flask_app.models.painting import Painting




@app.route('/dashboard')
def dashboard():
    if "user_id" not in session:
        return redirect("/logout")
    return render_template('dashboard.html', paintings=Painting.get_all())


@app.route('/painting/create',methods=['POST'])
def create():
    print(request.form)

    if not Painting.validate_painting(request.form):
        return redirect('/painting/new')
    Painting.save(request.form)
    return redirect('/dashboard')


@app.route('/painting/new')
def recipes_new():
    if "user_id" not in session:
        return redirect("/logout")
    return render_template('new_painting.html')


@app.route('/painting/<int:id>')
def painting(id):
    data ={ 
        "id":id
    }
    if "user_id" not in session:
        return redirect("/logout")
    return render_template("show_painting.html", paintings=Painting.get_one(data))

@app.route('/destroy/<int:id>')
def destroy(id):
    if 'user_id' not in session:
        flash("please sign in/register")
        return redirect ('/')
    data ={
        'id': id
    }
    Painting.destroy(data)
    if "user_id" not in session:
        return redirect("/logout")
    return redirect('/dashboard')

@app.route('/edit/<int:id>')
def edit(id):
    data ={ 
        "id":id
    }
    if "user_id" not in session:
        return redirect("/logout")
    return render_template("edit_painting.html",paintings=Painting.get_one(data))


@app.route('/painting/update',methods=['POST'])
def update():
    print(request.form)
    if not Painting.validate_painting(request.form):
        return redirect(f"/edit/{request.form['id']}")
    Painting.update(request.form)
    if "user_id" not in session:
        return redirect("/logout")
    return redirect('/dashboard')