from flask_app import app
from flask import render_template, request, redirect

from flask_app.models.thought import Thought

##!CREATE
## TODO Show the new thought form
@app.route('/thoughts/new')
def new_thought():
    return render_template('new_thought.html')

## TODO handle new thought form
@app.route('/create/thought', methods=['POST'])
def create_thought():
    print(request.form)
    data = {'content': request.form['content'],'likes': 0, 'user_id': int(request.form['user_id'])}
    thought = Thought.save(data) #! class method in thought class, find it in ../controllers/thought.py
    return redirect(f"/thoughts")


##! READ
@app.route('/thoughts')
def thoughts():
    return render_template('thoughts.html', thoughts = Thought.get_all())

@app.route('/thoughts/<int:id>')
def show_thought(id):
    data = {'id': id}
    return render_template('show_thought.html', thought = Thought.get_one(data))


#! UPDATE
## TODO route to edit thought form
@app.route('/thoughts/<int:id>/edit')
def edit_thought(id):
    data = {'id': id}
    thought = Thought.get_one(data)
    return render_template('edit_thought.html', thought = thought)

## TODO handle thought edit
@app.route('/edit/thought', methods=['POST'])
def update_thought():
    print(request.form)
    thought = Thought.update(request.form)
    print(thought)
    return redirect(f"/thoughts/{request.form['id']}")

## TODO handle like decrease
@app.route('/decrement_likes/<int:id>/<int:likes>')
def dec_likes(id, likes):
    data = {'id': id, 'likes': likes - 1}
    Thought.update_likes(data)
    return redirect('/thoughts')

## TODO handle like increase
@app.route('/increment_likes/<int:id>/<int:likes>')
def inc_likes(id, likes):
    data = {'id': id, 'likes': likes + 1}
    Thought.update_likes(data)
    return redirect('/thoughts')


#! DELETE
@app.route('/delete/<int:id>')
def destroy_thought(id):
    data = {'id':id}
    Thought.destroy(data)   #! class method in User class, find it in ../controllers/user.py
    return redirect('/thoughts')