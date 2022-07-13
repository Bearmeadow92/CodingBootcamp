import re
from flask_app import app, Bcrypt
from flask import render_template,redirect,request,session,flash
from flask_app.models.recipe import Recipe


@app.route('/dashboard')
def dashboard():
    return render_template('dashboard.html', recipes = Recipe.get_all())

@app.route('/recipe/create',methods=['POST'])
def create():
    print(request.form)

    if not Recipe.validate_recipe(request.form):
        return redirect('/recipe/new')
    Recipe.save(request.form)
    return redirect('/dashboard')


@app.route('/recipe/new')
def recipes_new():
    return render_template('new_recipes.html')


@app.route('/recipe/<int:id>')
def recipe(id):
    data ={ 
        "id":id
    }
    return render_template("show_recipe.html", recipes=Recipe.get_one(data))

@app.route('/destroy/<int:id>')
def destroy(id):
    if 'user_id' not in session:
        flash("please sign in/register")
        return redirect ('/')
    data ={
        'id': id
    }
    Recipe.destroy(data)
    return redirect('/dashboard')

@app.route('/edit/<int:id>')
def edit(id):
    data ={ 
        "id":id
    }
    return render_template("edit_recipes.html",recipe=Recipe.get_one(data))


@app.route('/recipe/update',methods=['POST'])
def update():
    print(request.form)
    if not Recipe.validate_recipe(request.form):
        return redirect(f"/edit/{request.form['id']}")
    Recipe.update(request.form)
    return redirect('/dashboard')